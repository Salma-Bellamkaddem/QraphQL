package com.project.ace_tprevesion.Service.impl;

import com.project.ace_tprevesion.DTO.request.PhoneRequestDto;
import com.project.ace_tprevesion.DTO.response.PhoneResponseDto;

import java.util.List;

public interface PhoneService {
    List<PhoneResponseDto> getPhonesByModel(String model);

    // Trouver les téléphones par modèle et prix
    List<PhoneResponseDto> getPhonesByModelAndPrice(String model, Float price);

    // Ajouter un téléphone
    PhoneResponseDto addPhone(PhoneRequestDto phoneRequestDto);


    PhoneResponseDto updatePhone(Long phoneId, PhoneRequestDto phoneRequestDto);

    void deletePhoneById(Long id);

    // Supprimer un téléphone par ID
}
