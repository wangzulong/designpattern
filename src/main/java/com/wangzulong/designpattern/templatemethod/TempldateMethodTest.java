package com.wangzulong.designpattern.templatemethod;

/**
 * @author wangzulong
 * @version 1.0
 * @date 2020/7/18 22:26
 */
public class TempldateMethodTest {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.operation();
    }
}

abstract class AbstractClass {
    public void operation() {
        //open
        System.out.println("pre ...");
        System.out.println("step 1");
        System.out.println("step 2");

        templateMethod();
        //sql ...
        //close
    }

    abstract  protected  void templateMethod();
}

class SubClass extends AbstractClass {

    @Override
    protected void templateMethod() {
        System.out.println("SubClass executed.");
    }
}
