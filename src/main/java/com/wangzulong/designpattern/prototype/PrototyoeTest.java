package com.wangzulong.designpattern.prototype;

import java.io.*;

/**
 * @author wangzulong
 * @version 1.0
 * @date 2020/7/15 20:38
 */
public class PrototyoeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        BaseInfo baseInfo = new BaseInfo("test");
        Product product = new Product("productName", "companyName", "var1", "var2", "var3", baseInfo);
        Product clone = product.clone();
        System.out.println("original:" + product);
        System.out.println("conle:" + clone);

        product.getBaseInfo().setName("change");
        System.out.println("original:" + product);
        System.out.println("conle:" + clone);
    }

}

class BaseInfo implements Cloneable, Serializable{
    static final long serialVersionUID = 1L;

    private String  name;

    public BaseInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected BaseInfo clone() throws CloneNotSupportedException {
        return (BaseInfo) super.clone();
    }

    @Override
    public String toString() {
        return "BaseInfo{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Product implements Cloneable, Serializable {
    static final long serialVersionUID = 1L;

    private String productName;
    private String companyName;
    private String var1;
    private String var2;
    private String var3;
    private BaseInfo baseInfo;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public String getVar2() {
        return var2;
    }

    public void setVar2(String var2) {
        this.var2 = var2;
    }

    public String getVar3() {
        return var3;
    }

    public void setVar3(String var3) {
        this.var3 = var3;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public Product() {

    }

    public Product(String productName, String companyName, String var1, String var2, String var3, BaseInfo baseInfo) {
        this.productName = productName;
        this.companyName = companyName;
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.baseInfo = baseInfo;
    }

    @Override
    protected Product clone() throws CloneNotSupportedException {

        //version 1
//        Product clone = (Product) super.clone();
//        clone.setBaseInfo(this.baseInfo.clone());
//        return clone ;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        try (ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            Product product = (Product) objectInputStream.readObject();
            return product;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return super.hashCode() + "Product{" +
                "productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", var1='" + var1 + '\'' +
                ", var2='" + var2 + '\'' +
                ", var3='" + var3 + '\'' +
                baseInfo.hashCode() + ", baseInfo='" + baseInfo + '\'' +
                '}';
    }
}