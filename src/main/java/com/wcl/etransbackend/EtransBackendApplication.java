package com.wcl.etransbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EtransBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtransBackendApplication.class, args);
    }

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() { //解决特殊符号报错问题
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers(connector -> connector.setProperty("relaxedQueryChars", "\"<>[\\]^`{|}"));
        return factory;
    }
}
