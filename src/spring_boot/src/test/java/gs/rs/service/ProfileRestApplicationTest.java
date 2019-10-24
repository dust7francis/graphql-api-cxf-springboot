package gs.rs.service;

import org.apache.cxf.jaxrs.client.WebClient;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProfileRestApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProfileRestApplicationTest {

    @LocalServerPort
    private int port;
    @Test
    public void testHelloRequest() throws Exception {
        WebClient wc = WebClient.create("http://localhost:" + port + "/services/helloservice");
        wc.accept("text/plain");
        
        // HelloServiceImpl1
        wc.path("sayHello").path("Steve");
        String greeting = wc.get(String.class);
        Assert.assertEquals("Hello Steve, Welcome to Profile Application!!!", greeting); 
 
        // Reverse to the starting URI
        wc.back(true);

        // HelloServiceImpl2
        wc.path("sayHello2").path("Steve");
        greeting = wc.get(String.class);
        Assert.assertEquals("Hello2 Steve, Welcome to Profile Application!!!", greeting); 
    }

}
