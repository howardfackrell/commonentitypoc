package com.octanner.poc.commonentityserver;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by IntelliJ IDEA.
 * User: Howard.Fackrell
 * Date: 2/27/12
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class BaseDao {


        protected EntityManager entityManager;

        protected EntityManager initManager(String persistenceUnit)
        {
            Map properties = getPersistenceProperties(persistenceUnit);
    		if(entityManager==null || !entityManager.isOpen()){
    			EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit, properties);
    			entityManager = emf.createEntityManager();
    		}
            return entityManager;
        }

        private Map getPersistenceProperties(String persistenceUnitName)
        {
            Map map = new HashMap<String, String>();
            ResourceBundle bundle = ResourceBundle.getBundle(persistenceUnitName);
            Enumeration<String> e = bundle.getKeys();
            String key = null;
            while (e.hasMoreElements())
            {
                key = e.nextElement();
                map.put(key, bundle.getString(key));
            }
            return map;
        }

}
