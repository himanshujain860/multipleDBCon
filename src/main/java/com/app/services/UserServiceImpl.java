package com.app.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl {

    public Map<String, Map<String, String>> getCredentialMaps(){
        Map<String, Map<String, String>> credentialMaps = new HashMap<>();
        Map<String, String> credentialMap = new HashMap<>();
        credentialMap.put("url", "jdbc:mysql://192.168.10.45:3306/uat_db");
        credentialMap.put("user", "root");
        credentialMap.put("password", "ranosys123");
        credentialMaps.put("user1", credentialMap);
        credentialMap = new HashMap<>();
        credentialMap.put("url", "jdbc:mysql://192.168.10.45:3306/develop_journey");
        credentialMap.put("user", "root");
        credentialMap.put("password", "ranosys123");
        credentialMaps.put("user2", credentialMap);
        return credentialMaps;
    }
}
