
package gs.rs.service.hello2;

import javax.ws.rs.Path;

import gs.rs.service.api.HelloService;

@Path("/sayHello2")
public class HelloServiceImpl2 implements HelloService {

    public String sayHello(String a) {
        return "Hello2 " + a + ", Welcome to Profile Application!!!";
    }

}
