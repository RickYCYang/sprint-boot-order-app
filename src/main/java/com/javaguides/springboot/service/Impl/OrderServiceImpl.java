package com.javaguides.springboot.service.Impl;

import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.javaguides.springboot.dto.OrderRequest;
import com.javaguides.springboot.dto.OrderResponse;
import com.javaguides.springboot.repository.OrderRepository;
import com.javaguides.springboot.repository.PaymentRepository;
import com.javaguides.springboot.service.OrderService;
import lombok.AllArgsConstructor;
import com.javaguides.springboot.entity.Order;
import com.javaguides.springboot.entity.Payment;
import com.javaguides.springboot.exception.PaymentException;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    PaymentRepository paymentRepository;

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("IN_PROGRESS");
        order.setOrderTackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if (!payment.getType().equals("DEBIT")) {
            throw new PaymentException("Payment card type does not support");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTackingNumber(order.getOrderTackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");

        return orderResponse;
    }
}
