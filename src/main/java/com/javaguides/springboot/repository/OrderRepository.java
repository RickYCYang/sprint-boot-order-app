package com.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javaguides.springboot.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
