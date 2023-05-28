package com.practical.api.service.order;

import com.practical.api.controller.order.request.OrderCreateRequest;
import com.practical.api.service.order.response.OrderResponse;
import com.practical.domain.Order.Order;
import com.practical.domain.product.Product;
import com.practical.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final ProductRepository productRepository;
    public OrderResponse createOrder(OrderCreateRequest request, LocalDateTime registeredDateTime) {
        List<String> productNumbers = request.getProductNumbers();
        // Product
        List<Product> products = productRepository.findAllByProductNumberIn(productNumbers);

        Order order = Order.create(products, registeredDateTime);

        // Order;
        return null;
    }
}
