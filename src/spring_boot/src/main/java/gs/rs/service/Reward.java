package gs.rs.service;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Reward")
public class Reward {
    private long id;
    private String description;
    private Map<Long, Product> products = new HashMap<>();

    public Reward() {
        init();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String d) {
        this.description = d;
    }

    @GET
    @Path("products/{productId}/")
    public Product getProduct(@PathParam("productId")int productId) {
        System.out.println("----invoking getProduct with id: " + productId);
        return products.get(Long.valueOf(productId));
    }

    final void init() {
        Product p = new Product();
        p.setId(323);
        p.setDescription("product 323");
        products.put(p.getId(), p);
    }
}
