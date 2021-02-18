package com.sda.onlineinvoicing;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(OnlineinvoicingApplication.class);
        //Spring boot comes with tomcat in it (that means spring boot has embedded tomcat);
        // Our Spring boot application runs on tomcat
        // Tomcat is a web server
    }

}
