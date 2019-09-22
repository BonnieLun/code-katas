package com.byinal.stripe;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

// Write a map implementation with a get function that lets you retrieve the value of a key at a particular time.
// It should contain the following methods:
//    set(key, value, time): # sets key to value for t = time.
//    get(key, time): # gets the key at t = time.

//TreeMap key'leri dogal sirasinda tutuyor. performans O(log n). key'ler sirali oldugu icin aradigindan bi oncekine, en yuksege, en dusuge kolay ulasabiliyorsun
//LinkedHashMap performans olarak daha iyi O(1) ama keyler sadece insertion-ordered veya access-ordered olabiliyor
public class TimestampMap<K, V> {

    private Map<K, TreeMap<Integer, V>> myMap;
    private Map<Integer, V> innerMap;

    public TimestampMap() {
        innerMap = new TreeMap<Integer, V>();
        myMap = new HashMap<K, TreeMap<Integer, V>>();
    }

    public void set(K key, V value, Integer timestamp){
        TreeMap<Integer, V> valueMap = myMap.get(key);
        if(null == valueMap){
            valueMap = new TreeMap<Integer, V>();
        }
        valueMap.put(timestamp, value);
        myMap.put(key, valueMap);
    }


    public V get(K key, Integer timestamp){
        TreeMap<Integer, V> valueMap = myMap.getOrDefault(key, new TreeMap<Integer, V>());
        Integer timestampWillBeSearched = valueMap.floorKey(timestamp);
        return valueMap.getOrDefault(timestampWillBeSearched, null);
    }

}

class App {

    public static void main(String[] args) {
        TimestampMap<Integer, Integer> timestampMap = new TimestampMap<>();

        timestampMap.set(1, 1, 0);
        timestampMap.set(1, 2, 2);

        assertEquals(new Integer(1), timestampMap.get(1, 0));
        assertEquals(new Integer(1), timestampMap.get(1, 1));
        assertEquals(new Integer(2), timestampMap.get(1, 3));
        assertEquals(new Integer(2), timestampMap.get(1, 2));
    }

}
