package com.wangzulong.designpattern.sigleton.innerClassSingleton;


import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangzulong
 * @version 1.0
 * @date 2020/7/10 9:04
 */
public class InnerClassSingletonTest {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, IOException, ClassNotFoundException {
//        new Thread(() -> {
//            InnerClassSingleton lazySingleton = InnerClassSingleton.getInstance();
//            System.out.println(lazySingleton);
//        }).start();
//
//        new Thread(() -> {
//            InnerClassSingleton lazySingleton = InnerClassSingleton.getInstance();
//            System.out.println(lazySingleton);
//        }).start();

/*        Constructor<InnerClassSingleton> declaredConstructor = InnerClassSingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        InnerClassSingleton innerClassSingleton = declaredConstructor.newInstance();
        InnerClassSingleton instance = InnerClassSingleton.getInstance();

        System.out.println(innerClassSingleton == instance);*/

        InnerClassSingleton instance = InnerClassSingleton.getInstance();

//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("testSerializable"));
//        objectOutputStream.writeObject(instance);
//        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("testSerializable"));
        Object o = (InnerClassSingleton) objectInputStream.readObject();

        System.out.println(instance == o);

    }
}

class InnerClassSingleton implements Serializable {
    public static final long serialVersionUID = 42L;

    private static class InnerClassHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton() {
        if (InnerClassHolder.instance != null) {
            throw new RuntimeException("单例不允许多个实例");
        }
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.instance;
    }

    Object readResolve() throws ObjectStreamException {
        return InnerClassHolder.instance;
    }
}