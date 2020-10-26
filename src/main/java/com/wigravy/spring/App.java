package com.wigravy.spring;


import com.wigravy.spring.model.Product;
import com.wigravy.spring.services.ProductService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.security.ProtectionDomain;
import java.util.List;


public class App {
    public static void main(String[] args)  {
        Server server = new Server(8189);

        ProtectionDomain domain = App.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/app");
        webAppContext.setWar(location.toExternalForm());

        server.setHandler(webAppContext);

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
