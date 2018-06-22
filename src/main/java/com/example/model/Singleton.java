package com.example.model;

/**
 * @author: ycx
 * @date: 2018/6/19 11:14
 * @description： 单例练习
 */
public class Singleton {

    private Singleton() {
    }

    //懒汉式
//    private static Singleton singleton = null;
//
//    public static Singleton getInstance() {
//        if (singleton == null) {.
//            synchronized (Singleton.class) {
//                if (singleton == null) {
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }
    //静态内部类
    private static final class lazyHolder{
        private static final Singleton s = new Singleton();
    }

    public static final Singleton getInstance(){
        return lazyHolder.s;
    }
    //饿汉式
//    private static final Singleton s = new Singleton();
//
//    public static Singleton getInstance(){
//        return s;
//    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        if (s1 == s2) {
            System.out.println("1");
        } else {
            System.out.println("2");
        }
    }
}
