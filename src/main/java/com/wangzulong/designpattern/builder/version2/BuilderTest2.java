package com.wangzulong.designpattern.builder.version2;

/**
 * @author wangzulong
 * @version 1.0
 * @date 2020/7/12 22:58
 */
public class BuilderTest2 {
    public static void main(String[] args) {
        Product build = new Product.Builder().productName("product").companyName("company").var1("var1").var2("var2").var3("var3").build();
        System.out.println(build);
    }
}

class Product {

    private final String productName;
    private final String companyName;
    private final String var1;
    private final String var2;
    private final String var3;

    static class Builder {
        private String productName;
        private String companyName;
        private String var1;
        private String var2;
        private String var3;

        public Builder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder var1(String var1) {
            this.var1 = var1;
            return this;
        }

        public Builder var2(String var2) {
            this.var2 = var2;
            return this;
        }

        public Builder var3(String var3) {
            this.var3 = var3;
            return this;
        }

        Product build() {
            return new Product(this.productName, this.companyName, this.var1, this.var2, this.var3);
        }
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