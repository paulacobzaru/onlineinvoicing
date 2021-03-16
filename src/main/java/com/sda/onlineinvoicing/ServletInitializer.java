package com.sda.onlineinvoicing;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(OnlineinvoicingApplication.class);
        //Spring boot comes with Tomcat (that means that Spring Boot has embedded Tomcat);
        // Our Spring boot application runs on Tomcat
        // Tomcat is a web server
    }
}
