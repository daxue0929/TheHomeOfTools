package org.daxue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class OnLineToolsApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnLineToolsApplication.class, args);
    }

    @Value("${server.port}")
    public String port;

    @Bean
    public Object test() {
        System.out.println("[daxue] current application is run on:" + port);
        return new Object();
    }
}
