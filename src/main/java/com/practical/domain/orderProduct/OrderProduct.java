package com.practical.domain.orderProduct;

import com.practical.domain.BaseEntity;
import com.practical.domain.Order.Order;
import com.practical.domain.product.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 중간 테이블의 역할은 두 Order와 product를 이어주는 역
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class OrderProduct extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ManyToOne 의 경우에는 FetchType이 기본적으로 EAGER인데, 항상 LAZY로 선언해주는게 좋다.
    // 기본적으로 즉시 사용해야하는 부분만 기본 전략인 EAGER를 사용하는게 좋다.
    // Product쪽에서는 orderProduct를 알 필요가 사실은 없을 것 같음, 상품들이 나는 어떤 주문들에 담겨있어!는 몰라도됨
    // 주문쪽에서만 나는 어떤 상품들로 이루어진 주문이야~ 만 알면됨, 그래서 Order와 Orderproduct만 양방향 관계를 줄 것
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;


    public OrderProduct( Order order, Product product) {
        this.order = order;
        this.product =  product;
    }
}
