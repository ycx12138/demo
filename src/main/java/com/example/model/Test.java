package com.example.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author: ycx
 * @date: 2018/5/4 15:29
 * @description： stream流练习
 */
public class Test implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }

    public void test() {
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("addasl");
        list.add("addasd");
        list.add("北京");
        list.add("poiuujh");
        list.add("mnbbv");
        list.add("lmnttu");
        list.parallelStream().sorted(Comparator.comparing(String::length));
//        list.stream().filter(s->!s.equals("北京")).collect(Collectors.toList()).forEach(System.out::println);
//        list.stream().filter(s -> !s.equals("北京"))
//                .map(String::toUpperCase)
//                .collect(Collectors.toCollection(TreeSet::new))
//                .forEach(System.out::println);
//        Stream<String> stringOptional = list.stream().parallel().filter(s -> !s.equals("北京"));
//        Optional<String> s = list.stream().parallel().filter(str -> str.startsWith("p")).findFirst();
//        Object[] arr = stringOptional.toArray();
//        Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));
//        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9, 11);
//        IntSummaryStatistics statistics = list1.stream().filter(integer -> integer > 2).mapToInt(i -> i * 2).skip(2).limit(2).summaryStatistics();
//        System.out.println(statistics.getMax());//18
//        System.out.println(statistics.getMin());//14
//        System.out.println(statistics.getAverage());//16
//       IntStream.iterate(3, i -> i * 2).skip(2).limit(5).distinct().forEach(System.out::println);
//        Stream.generate(Math::random)
//                .limit(5)
//                .map(i -> Math.ceil(i * 100))
//                .sorted((a,b)->{
//                    System.out.println(a);
//                    System.out.println(b);
//                    return a.compareTo(b);
//                })
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
//        IntStream.range(1, 100).limit(5).distinct().forEach(System.out::println);
//        Stream<List<String>> inputStream = Stream.of(
//                Arrays.asList("q"),
//                Arrays.asList("a", "p"),
//                Arrays.asList("h", "k", "l")
//        );
//        inputStream.flatMap((childList) -> childList.stream())
//                .peek(e -> System.out.print(" " + e))
//                .sorted()
//                .map(String::toUpperCase)
//                .collect(Collectors.toCollection(ArrayList::new))
//                .forEach(System.out::println);
//        String s = "abc";
//        String str  = Optional.ofNullable(s).orElse("bca");
//        System.out.println(str);
        List<UserInfo> userInfo = new ArrayList<UserInfo>();
        userInfo.add(new UserInfo("a", 20));
        userInfo.add(new UserInfo("c", 20));
        userInfo.add(new UserInfo("a", 17));
        userInfo.add(new UserInfo("h", 16));
        userInfo.add(new UserInfo("m", 18));
//        Map<Boolean, List<UserInfo>> listMap = userInfo.stream().collect(Collectors.partitioningBy(l -> l.getAge() > 18));
//        Map<String, Optional<String>> stringListMap = userInfo.stream()
//                .collect(Collectors
//                        .groupingBy(UserInfo::getUsername,
//                                mapping(UserInfo::getAddress,
//                                        maxBy(Comparator.comparing(String::length)))));
//        Map<Integer, String> stringMap = userInfo.stream().collect(
//                groupingBy(UserInfo::getAge,
//                        mapping(UserInfo::getUsername,
//                                joining(","))));
//        System.out.println("");
//        for (String key: stringListMap.keySet()){
//            System.out.println(String.valueOf(key));
//            for (UserInfo u:stringListMap.get(key)
//                 ) {
//                System.out.print(String.join(",",u.getUsername(),u.getAge().toString()));
//            }
//            System.out.println();
//        }
//        for (Map.Entry<Boolean,List<UserInfo>> entry:listMap.entrySet()){
//            System.out.println(entry.getKey());
//        }
//        Iterator<Map.Entry<Boolean,List<UserInfo>>> iterator = listMap.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<Boolean,List<UserInfo>> entry = iterator.next();
//            System.out.println(String.join(",",entry.getKey().toString(),entry.getValue().get(0).getUsername()));
//        }
//        listMap.forEach((key, value) -> System.out.println(String.valueOf(key) + value.get(0).getUsername()));
//        List list1 = list.stream().filter(e -> !e.equals("北京")).sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(ArrayList::new));
//        list1.forEach(System.out::println);
//        userInfo.stream()
//                .sorted(Comparator.comparing(UserInfo::getUsername)
////                        .thenComparing(t->-t.getAge()))
//                        .thenComparing(t->-t.getAge()))
//                .forEach(e-> System.out.println(e.getUsername()+e.getAge()));
//        IntStream.range(0,100).forEach(System.out::println);
//        int[] words = {1,3,8,10,6};
//        Arrays.stream(words).parallel().forEach(
//                s->{
//                    if (s.length()<12){
//
//                    }
//                }
//        );
    }
}

