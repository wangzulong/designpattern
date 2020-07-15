package com.wangzulong.designpattern.factorymethod;

/**
 * @author wangzulong
 * @version 1.0
 * @date 2020/7/12 16:12
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Applicatoin applicatoin = new ConcreateProductA();
        Product product = applicatoin.getObejct();
        product.method1();
    }
}

interface Product {
    public void method1();
}

class ProductA implements  Product{

    @Override
    public void method1() {
        System.out.println("构建ProductA");
    }
}

class ProductB implements  Product{

    @Override
    public void method1() {
        System.out.println("构建ProductB");
    }
}

class SimpleFactory {
    public static  Product createProduct(String type) {
        if (type.equals("A")) {
            return new ProductA();
        } else if (type.equals("B")) {
            return new ProductB();
        }
        return null;
    }
}

abstract class Applicatoin {

    abstract Product createProduct();

    Product getObejct() {
        Product product = createProduct();
        // ...
        return product;
    }
}

class ConcreateProductA extends  Applicatoin {

    @Override
    Product createProduct() {
        return new ProductA();
    }
}

class ConcreateProductB extends  Applicatoin {

    @Override
    Product createProduct() {
        return new ProductB();
    }
}