package com.app;

import com.app.factory.cache.EntityManagerFactoryCache;

public class MainClassTest {

    public static void main(String[] args) {
        System.out.println(EntityManagerFactoryCache.getFactory("user1"));
        System.out.println(EntityManagerFactoryCache.getFactory("user2"));
    }
}
