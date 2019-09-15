package com.byinal.stripe;


//To begin with, the database will support just one function: min_by_key. This function scans the array of records
//        and returns the record that has the minimum value for a specified key. Records that do not contain the specified
//        key are considered to have value 0 for the key. Note that keys may map to negative values!
//
//        Here's an example use case: each of your records contains data about a school student. You can use min_by_key to
//        answer questions such as "who is the youngest student?" and "who is the student with the lowest grade-point average?"
//
//        Implementation notes:
//
//        You should handle an empty array of records in an idiomatic way in your language of choice.
//        If several records share the same minimum value for the chosen key, you may return any of them.
//        Java function signature:
//
//public static Map<String, Integer> minByKey(String key, List<Map<String, Integer>> records);
//        Examples (in Python):
//
//        assert min_by_key("a", [{"a": 1, "b": 2}, {"a": 2}]) == {"a": 1, "b": 2}
//        assert min_by_key("a", [{"a": 2}, {"a": 1, "b": 2}]) == {"a": 1, "b": 2}
//        assert min_by_key("b", [{"a": 1, "b": 2}, {"a": 2}]) == {"a": 2}
//        assert min_by_key("a", [{}]) == {}
//        assert min_by_key("b", [{"a": -1}, {"b": -1}]) == {"b": -1}


//Step 2: first_by_key
//
//        Our next step in database development is to add a new function. We'll call this function first_by_key. It has much
//        in common with min_by_key. first_by_key takes three arguments:
//
//        a string key
//        a string sort direction (which must be either "asc" or "desc")
//        an array of records, just as in min_by_key.
//        If the sort direction is "asc", then we should return the minimum record, otherwise we should return the maximum
//        record. As before, records without a value for the key should be treated as having value 0.
//
//        Once you have a working solution, you should re-implement min_by_key in terms of first_by_key .
//
//        Java function signature:
//
//public static Map<String, Integer> firstByKey(String key, String direction, List<Map<String, Integer>> records);


//Step 3: first_by_key comparator
//
//        As we build increasingly rich orderings for our records, we'll find it useful to extract the comparison of records
//        into a comparator. This is a function or object (depending on your language) which determines if a record is "less
//        than", equal, or "greater than" another.
//
//        In object-oriented languages, you should write a class whose constructor accepts two parameters: a string key and a
//        string direction. The class should implement a method compare that takes as its parameters two records. This method
//        should return -1 if the first record comes before the second record (according to key and direction), zero if neither
//        record comes before the other, or 1 if the first record comes after the second.
//
//        In functional languages, you should write a function which accepts two parameters: a string key and a string direction.
//        The function should return a method that takes as its parameters two records.
//        ** This function should return -1 if the first record comes before the second record (according to key and direction),
//        ** zero if neither record comes before the other,
//        ** or 1 if the first record comes after the second.
//
//        You should then use your comparator in your implementation of first_by_key.


import java.util.*;


public class MinByKey {


    public static void main(String[] args) {
        Map<String, Integer> row1 = new HashMap<>();
        row1.put("a", 1);
        row1.put("b", 2);

        Map<String, Integer> row2 = new HashMap<>();
        row2.put("a", -2);

        List<Map<String, Integer>> db = new ArrayList<>();
        db.add(row1);
        db.add(row2);

        System.out.println(findMinByKey("a", db));
        System.out.println(findFirstByKey("a", "desc", db));
    }

    private static Map<String, Integer> findMinByKey(String key, List<Map<String, Integer>> db) {
        if (db.size() == 0) {
            return Collections.emptyMap();
        }
        Map<String, Integer> requestedRow = db.get(0);
        Integer firstValue = requestedRow.getOrDefault(key, 0);
        Integer value;
        for (Map<String, Integer> row : db) {
            value = row.getOrDefault(key, 0);
            if (value < firstValue) {
                requestedRow = row;
                firstValue = value;
            }
        }
        return requestedRow;
    }


    private static Map<String, Integer> findFirstByKey(String key, String operator, List<Map<String, Integer>> db) {
        Comparator comparator = new Comparator(key, operator);
        if (db.size() == 0) {
            return Collections.emptyMap();
        }
        Map<String, Integer> requestedRow = db.get(0);
        Integer firstValue = requestedRow.getOrDefault(key, 0);
        Integer value;
        for (Map<String, Integer> row : db) {
            if(comparator.compare(row, requestedRow) == -1){
                requestedRow = row;
            }
//            value = row.getOrDefault(key, 0);
//
//            if ("asc".equals(operator)) {
//                if (value < firstValue) {
//                    requestedRow = row;
//                    firstValue = value;
//                }
//            } else {
//                if (value > firstValue) {
//                    requestedRow = row;
//                    firstValue = value;
//                }
//            }
        }
        return requestedRow;
    }

}

class Comparator{

    private String key;
    private String operator;
    private Map<String, Integer> operatorMap = new HashMap<>();

    public Comparator(String key, String operator) {
        this.key = key;
        this.operator = operator;
        operatorMap.put("asc", 1);
        operatorMap.put("desc", -1);
    }

    public Integer compare(Map<String, Integer> row1, Map<String, Integer> row2){
        Integer row1Value = row1.getOrDefault(key, 0);
        Integer row2Value = row2.getOrDefault(key, 0);
        if(row1Value == row2Value) return 0;
        if(row1Value > row2Value) {
            return operatorMap.get(operator);
        } else {
            return -1 * operatorMap.get(operator);
        }
    }
}
