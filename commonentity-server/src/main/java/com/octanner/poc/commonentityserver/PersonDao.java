package com.octanner.poc.commonentityserver;

import com.octanner.poc.commonentity.Person;

import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Howard.Fackrell
 * Date: 2/27/12
 * Time: 5:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonDao extends BaseDao {
    private static String persistenceUnit = "PersonPU";

    public PersonDao()
    {
        super.initManager(persistenceUnit);
    }

    public Person save(Person person)
        {
            entityManager.getTransaction().begin();
            if (person.getId() == null)
            {
                person = entityManager.merge(person);
            }
            else
            {
                entityManager.persist(person);
            }

            entityManager.getTransaction().commit();
            return person;
        }

        public Collection<Person> retrievePersons()
        {
            entityManager.getTransaction().begin();
            Query q = entityManager.createQuery("select p from Person p");
            List<Person> persons;
            persons = q.getResultList();
            entityManager.getTransaction().commit();
            return persons;
        }
    
    public Person getPersonByName(String name)
    {
        entityManager.getTransaction().begin();
        Query q = entityManager.createQuery("select p from Person p where name=:name");
        q.setParameter("name", name);
        Person p = (Person) q.getSingleResult();
        entityManager.getTransaction().commit();
        return p;
    }

        public void deleteAll()
        {
            entityManager.getTransaction().begin();
            Query q = entityManager.createQuery("delete from Person p");
            q.executeUpdate();
            entityManager.getTransaction().commit();
        }
}
