package ma.coca2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationApiGateway {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationApiGateway.class,args);

    }
}
