package gs.rs.service.hello1;

import gs.rs.service.api.HelloService;

public class HelloServiceImpl1 implements HelloService {

    public String sayHello(String a) {
        return "Hello " + a + ", Welcome to Profile Application!!!";
    }

}
