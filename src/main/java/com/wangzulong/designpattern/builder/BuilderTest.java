package com.wangzulong.designpattern.builder;

/**
 * @author wangzulong
 * @version 1.0
 * @date 2020/7/12 22:34
 */
public class BuilderTest {
    public static void main(String[] args) {
        ProductBuilder productBuilder = new DefaultConcreteProductBuilder();
        Director director = new Director(productBuilder);
        Product product = director.makeProduct("productName", "companyName", "var1", "var2", "var3");
        System.out.println(product);
    }
}

interface ProductBuilder {
    void builderProductName(String productName);

    void builderCompanyName(String companyName);

    void builderVar1(String var1);

    void buliderVar2(String var2);

    void builderVar3(String var3);

    Product build();
}

class DefaultConcreteProductBuilder implements ProductBuilder {

    private String productName;
    private String companyName;
    private String var1;
    private String var2;
    private String var3;

    @Override
    public void builderProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void builderCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void builderVar1(String var1) {
        this.var1 = var1;
    }

    @Override
    public void buliderVar2(String var2) {
        this.var2 = var2;
    }

    @Override
    public void builderVar3(String var3) {
        this.var3 = var3;
    }

    @Override
    public Product build() {
        return new Product(this.productName, this.companyName, this.var1, this.var2, this.var3);
    }

}

class Director {
    private ProductBuilder productBuilder;

    public Director(ProductBuilder productBuilder) {
        this.productBuilder = productBuilder;
    }

    public Product makeProduct(String productName, String companyName, String var1, String var2, String var3) {
        productBuilder.builderProductName(productName);
        productBuilder.builderCompanyName(companyName);
        productBuilder.builderVar1(var1);
        productBuilder.buliderVar2(var2);
        productBuilder.builderVar3(var3);

        Product product = productBuilder.build();
        return product;
    }
}

class Product {

    private String productName;
    private String companyName;
    private String var1;
    private String var2;
    private String var3;

    public Product() {

    }

    public Product(String productName, String companyName, String var1, String var2, String var3) {
        this.productName = productName;
        this.companyName = companyName;
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", var1='" + var1 + '\'' +
                ", var2='" + var2 + '\'' +
                ", var3='" + var3 + '\'' +
                '}';
    }
}
