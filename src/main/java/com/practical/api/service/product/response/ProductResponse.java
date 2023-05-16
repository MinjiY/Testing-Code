package com.practical.api.service.product.response;

import com.practical.domain.product.Product;
import com.practical.domain.product.ProductSellingType;
import com.practical.domain.product.ProductType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductResponse {
    private Long id;
    private String productNumber;
    private ProductType productType;
    private ProductSellingType sellingType;
    private String name;
    private int price;

    // 이 생성자를 외부에서 생성 못하도록 막고 Builder로 만 생성할 수 있도록 한다.
    @Builder
    private ProductResponse(Long id, String productNumber, ProductType productType, ProductSellingType sellingType, String name, int price) {
        this.id = id;
        this.productNumber = productNumber;
        this.productType = productType;
        this.sellingType = sellingType;
        this.name = name;
        this.price = price;
    }

    public static ProductResponse of(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .productNumber(product.getProductNumber())
                .productType(product.getProductType())
                .sellingType(product.getSellingType())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}
