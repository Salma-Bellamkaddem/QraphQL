package com.project.ace_tprevesion.DTO.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneRequestDto {
    @NotBlank(message = "Le modèle est obligatoire.")
    private String model;
    @NotBlank(message = "La couleur est obligatoire.")
    private String color;
    @NotBlank(message = "L'IMEI est obligatoire.")
    private String imei;
    @NotNull(message = "Le prix est obligatoire.")
    private Float price;
}
