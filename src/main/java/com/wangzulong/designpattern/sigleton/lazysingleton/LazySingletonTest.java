package com.wangzulong.designpattern.sigleton.lazysingleton;

/**
 * @author wangzulong
 * @version 1.0
 * @date 2020/7/9 10:12
 */
public class LazySingletonTest {
    public static void main(String[] args) {
        new Thread(() -> {
            LazySingleton lazySingleton = LazySingleton.getInstance();
            System.out.println(lazySingleton);
        }).start();

        new Thread(() -> {
            LazySingleton lazySingleton = LazySingleton.getInstance();
            System.out.println(lazySingleton);
        }).start();
    }
}

class LazySingleton {
    private volatile static LazySingleton instance;

    public LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                    // 字节码层
                    // JIT， CPU
                    // 1. 分配空间
                    // 2. 初始化
                    // 3. 引用赋值
                }
            }
        }
        return instance;
    }
}
