package com.wangzulong.designpattern.adapter.v1;

/**
 * @author wangzulong
 * @version 1.0
 * @date 2020/7/17 20:21
 */
public class AdapterTest1 {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Adapter  adapter = new Adapter(adaptee);
        adapter.output5v();
    }
}

class Adaptee {
    public int output220v() {
        return 220;
    }
}

interface Target {
    int output5v();
}

class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int output5v() {
        int a = adaptee.output220v();
        // ...
        System.out.println(String.format("原始电压： %d v -> 输出电压： %d v", a, 5));


        return 5;
    }
}