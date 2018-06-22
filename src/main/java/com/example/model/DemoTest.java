package com.example.model;

import java.util.*;

/**
 * @author: ycx
 * @date: 2018/5/29 14:12
 * @description：手写一个排序算法 去重升序数组
 */
public final class DemoTest {
    // 多线程并发、IO、集合框架、数据库（事物、SQL、索引）、spring框架（springboot/springcloud）、redis、dubble、MQ、mongodb
    public static List<Integer> sortAndDistanct(Integer[] arr) {
//        List<Integer> list = Arrays.asList(arr);
//        list = list.stream().sorted().collect(Collectors.toList());
        Integer temp;
        for (Integer i=0;i<arr.length;i++){
            for (Integer j = 0;j<arr.length-1;j++){
                if (arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]= temp;
                }
            }
        }
        List<Integer> list = Arrays.asList(arr);
        List<Integer> list1 = new ArrayList<>();
        for (Integer i : list
                ) {
            if (!list1.contains(i)) {
                list1.add(i);
            }
        }
        return list1;
    }

    public static void main(String[] args) {
//        Integer[] arrs = {1, 3, 1, 9, 32, 23, 32, 67, 89, 111, 43, 54, 34, 45};
//        sortAndDistanct(arrs).stream().forEach(System.out::println);
//        Map <String,String> map = new HashMap<>();
//        map.put("key1","value1");
//        map.put("key2","value2");
//        map.put("key3","value3");
//        map.put("key4","value4");
//        map.put("key5","value5");
//        Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();
//        while (it.hasNext()){
//            Map.Entry<String,String> m = it.next();
//            System.out.println(m.getKey()+m.getValue());
//        }
        List list = new LinkedList();
        list.add("1");
        list.add("2");
        list.add(3);
        System.out.println(list.get(2));

    }
}





