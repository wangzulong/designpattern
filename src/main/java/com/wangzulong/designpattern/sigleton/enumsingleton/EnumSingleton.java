package com.wangzulong.designpattern.sigleton.enumsingleton;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 * @author wangzulong
 * @version 1.0
 * @date 2020/7/11 23:26
 */

public enum EnumSingleton {
    INSTANCE;

    public void print() {
        System.out.println(this.hashCode());
    }

}

class EnumTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException {
//        Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(String.class, int.class);
//        declaredConstructor.setAccessible(true);
//        declaredConstructor.newInstance("INSTANCE", 0);

        EnumSingleton instance = EnumSingleton.INSTANCE;

//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("enumsingleton"));
//        objectOutputStream.writeObject(instance);
//        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("enumsingleton"));
        Object o = (EnumSingleton)objectInputStream.readObject();

        System.out.println(o == instance);

    }
}