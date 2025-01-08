package com.javaguides.springboot.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class OrderResponse {
    private String orderTackingNumber;
    private String status;
    private String message;
}
