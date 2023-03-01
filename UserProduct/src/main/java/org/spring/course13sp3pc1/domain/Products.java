package org.spring.course13sp3pc1.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class Products {
    @Id
    private String productId;
    private String title1;
    private String content1;
    private int price;

    public Products() {
    }

    public Products(String productId, String title1, String content1, int price) {
        this.productId = productId;
        this.title1 = title1;
        this.content1 = content1;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
