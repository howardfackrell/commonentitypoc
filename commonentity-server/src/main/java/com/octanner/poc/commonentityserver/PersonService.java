package com.octanner.poc.commonentityserver;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.octanner.poc.commonentity.Person;

/**
 * Created by IntelliJ IDEA.
 * User: Howard.Fackrell
 * Date: 2/27/12
 * Time: 5:19 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/entities/Person")
public class PersonService {

    PersonDao personDao = new PersonDao();


    @GET
        @Path("/{name}")
        @Produces({MediaType.APPLICATION_JSON})
    public Person getPerson(@PathParam("name") String name)
    {
        Person p = personDao.getPersonByName(name);
        return p;
    }
}
