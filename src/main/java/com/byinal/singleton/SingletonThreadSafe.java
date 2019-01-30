package com.byinal.singleton;

public class SingletonThreadSafe {

    private static SingletonThreadSafe INSTANCE = null;
    private static final Object mutex = new Object();

    private SingletonThreadSafe(){}

    public static SingletonThreadSafe getInstance(){
        if(INSTANCE == null){
            synchronized (mutex){
                INSTANCE = new SingletonThreadSafe();
                return INSTANCE;
            }
        }
        return INSTANCE;
    }

}
