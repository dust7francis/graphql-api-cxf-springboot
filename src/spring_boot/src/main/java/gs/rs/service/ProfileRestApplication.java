package gs.rs.service;
import java.util.Arrays;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.openapi.OpenApiFeature;
import org.apache.cxf.jaxrs.swagger.ui.SwaggerUiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import gs.rs.service.ProfileService;
import gs.rs.service.hello1.HelloServiceImpl1;
import gs.rs.service.hello2.HelloServiceImpl2;

@SpringBootApplication
public class ProfileRestApplication {
    @Autowired
    private Bus bus;

    public static void main(String[] args) {
        SpringApplication.run(ProfileRestApplication.class, args);
    }

    @Bean
    public Server rsServer() {
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setBus(bus);
        sf.setServiceBeans(Arrays.<Object>asList(new ProfileService(), new HelloServiceImpl1(), new HelloServiceImpl2()));
        sf.setAddress("/");
        sf.setFeatures(Arrays.asList(createOpenApiFeature(), new LoggingFeature()));
        return sf.create();
    }

    @Bean
    public OpenApiFeature createOpenApiFeature() {
        final OpenApiFeature openApiFeature = new OpenApiFeature();
        openApiFeature.setPrettyPrint(true);
        openApiFeature.setTitle("Customer Profile REST Application");
        openApiFeature.setContactName("Profile Get Started");
        openApiFeature.setDescription("Backend profile applications to serve requests "
         + "from api gateway.");
        openApiFeature.setVersion("1.0.0");
        openApiFeature.setSwaggerUiConfig(
            new SwaggerUiConfig()
                .url("/services/helloservice/openapi.json"));
        return openApiFeature;
    }
}
