package com.byinal.singleton;

import java.util.Optional;

public class SingletonWithOptional {

    private static SingletonWithOptional INSTANCE = null;

    private SingletonWithOptional() { }

    public static SingletonWithOptional getInstance(){
        return Optional.ofNullable(INSTANCE)
                .orElseGet(() -> {
                    INSTANCE = new SingletonWithOptional();
                    return INSTANCE;
                });
    }


}
