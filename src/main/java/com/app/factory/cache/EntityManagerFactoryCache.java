package com.app.factory.cache;

import com.app.services.UserServiceImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityManagerFactoryCache {

    private static Map<String, EntityManagerFactory> map = new HashMap<>();

    static {
        UserServiceImpl userService = new UserServiceImpl();
        Map<String, Map<String, String>> credentialMaps = userService.getCredentialMaps();
        Map<String, String> mapForEF = null;
        for(Map.Entry<String, Map<String, String>> credentialMap : credentialMaps.entrySet()){
            mapForEF = new HashMap<>();
            mapForEF.put("javax.persistence.jdbc.url", credentialMap.getValue().get("url"));
            mapForEF.put("javax.persistence.jdbc.user", credentialMap.getValue().get("user"));
            mapForEF.put("javax.persistence.jdbc.password", credentialMap.getValue().get("password"));
            map.put(credentialMap.getKey(), Persistence.createEntityManagerFactory("dummyPU", mapForEF));
        }
    }

    private EntityManagerFactoryCache(){

    }

    public static EntityManagerFactory getFactory(String key){
        return map.containsKey(key) ? map.get(key) : null;
    }


}
