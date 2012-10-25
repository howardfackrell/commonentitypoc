package com.octanner.poc.commonentityserver;


import com.octanner.poc.commonentity.Person;
import com.sun.net.httpserver.HttpServer;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

/**
 * Created by IntelliJ IDEA.
 * User: Howard.Fackrell
 * Date: 2/27/12
 * Time: 6:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class App {
//    public static void main(String[] args)
//    {
//        PersonDao personDao = new PersonDao();
//        Person p =  personDao.getPersonByName("matt");
//        System.out.println(p);
//    }



    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(9998).build();
    }

    public static final URI BASE_URI = getBaseURI();

    protected static HttpServer startServer() throws IOException {
        System.out.println("Starting grizzly...");
        ResourceConfig rc = new PackagesResourceConfig("com.sun.jersey.samples.helloworld.resources");
        return GrizzlyServerFactory.createHttpServer(BASE_URI, rc);
    }

    public static void main(String[] args) throws IOException {
        HttpServer httpServer = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nTry out %shelloworld\nHit enter to stop it...",
                BASE_URI, BASE_URI));
        System.in.read();
        httpServer.stop();
    }

}
