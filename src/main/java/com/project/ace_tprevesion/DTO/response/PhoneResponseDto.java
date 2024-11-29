package com.project.ace_tprevesion.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneResponseDto {
    private String model;
    private String color;
    private String imei;
    private Float price;
}
