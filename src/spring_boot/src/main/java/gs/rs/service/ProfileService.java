package gs.rs.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/profileservice/")
@Produces("text/xml")
public class ProfileService {
    long currentId = 123;
    Map<Long, Profile> profiles = new HashMap<>();
    Map<Long, Reward> rewards = new HashMap<>();

    public ProfileService() {
        init();
    }

    @GET
    @Path("/profiles/{id}/")
    public Profile getProfile(@PathParam("id") String id) {
        System.out.println("----invoking getProfile, Profile id is: " + id);
        long idNumber = Long.parseLong(id);
        return profiles.get(idNumber);
    }

    @PUT
    @Path("/profiles/")
    public Response updateProfile(Profile profile) {
        System.out.println("----invoking updateProfile, Profile first name is: " + profile.getFirstName());
        Profile p = profiles.get(profile.getId());
        Response r;
        if (p != null) {
            profiles.put(profile.getId(), profile);
            r = Response.ok().build();
        } else {
            r = Response.notModified().build();
        }

        return r;
    }

    @POST
    @Path("/profiles/")
    public Response addProfile(Profile profile) {
        System.out.println("----invoking addProfile, Profile first name is: " + profile.getFirstName());
        profile.setId(++currentId);

        profiles.put(profile.getId(), profile);

        return Response.ok(profile).build();
    }

    @DELETE
    @Path("/profiles/{id}/")
    public Response deleteProfile(@PathParam("id") String id) {
        System.out.println("----invoking deleteProfile, Profile id is: " + id);
        long idNumber = Long.parseLong(id);
        Profile p = profiles.get(idNumber);

        Response r;
        if (p != null) {
            r = Response.ok().build();
            profiles.remove(idNumber);
        } else {
            r = Response.notModified().build();
        }

        return r;
    }

    @Path("/rewards/{rewardId}/")
    public Reward getReward(@PathParam("rewardId") String rewardId) {
        System.out.println("----invoking getReward, Reward id is: " + rewardId);
        long idNumber = Long.parseLong(rewardId);
        return rewards.get(idNumber);
    }

    final void init() {
        Profile p = new Profile();
        p.setFirstName("John");
        p.setLastName("Smith");
        p.setAddress("1 Infinite Loop");
        p.setId(123);
        profiles.put(p.getId(), p);

        Reward r = new Reward();
        r.setDescription("reward 223");
        r.setId(223);
        rewards.put(r.getId(), r);
    }

}
