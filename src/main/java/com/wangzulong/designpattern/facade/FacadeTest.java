package com.wangzulong.designpattern.facade;

/**
 * @author wangzulong
 * @version 1.0
 * @date 2020/7/16 23:27
 */
public class FacadeTest {
    public static void main(String[] args) {
        Client1 client1 = new Client1();
        client1.doSomething();
    }
}

class Client1 {
    Facade facade = new Facade();
    public void doSomething() {
        facade.doSomething();
    }
}

class Client2 {
    Facade facade = new Facade();
    public void doSomething() {
        facade.doSomething();
    }
}

class Facade {
    SubSystem1 subSystem1 = new SubSystem1();
    SubSystem2 subSystem2 = new SubSystem2();
    SubSystem3 subSystem3 = new SubSystem3();

    public void doSomething() {
        subSystem1.method1();
        subSystem2.method2();
        subSystem3.method3();
    }
}


class SubSystem1 {
    public void method1() {
        System.out.println("SubSystem1.method1.executed.");
    }
}

class SubSystem2 {
    public void method2() {
        System.out.println("SubSystem2.method2.executed.");
    }
}

class SubSystem3 {
    public void method3() {
        System.out.println("SubSystem3.method3.executed.");
    }
}