package com.wangzulong.designpattern.adapter.v2;

/**
 * @author wangzulong
 * @version 1.0
 * @date 2020/7/17 20:28
 */
public class AdapterTest2 {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
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

class Adapter extends Adaptee implements Target {
    @Override
    public int output5v() {
        int a = super.output220v();
        // ...
        System.out.println(String.format("原始电压： %d v -> 输出电压： %d v", a, 5));


        return 5;
    }
}