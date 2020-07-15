package com.wangzulong.designpattern.sigleton.hungrysingleton;

/**
 * @author wangzulong
 * @version 1.0
 * @date 2020/7/9 11:00
 */
public class HungrySingletonTest {
    public static void main(String[] args) {
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
    }
}

// 饿汉模式
class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){

    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
