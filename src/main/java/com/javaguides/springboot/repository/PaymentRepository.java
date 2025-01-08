package com.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javaguides.springboot.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
