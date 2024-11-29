package com.project.ace_tprevesion.Contoller;

import com.project.ace_tprevesion.DTO.request.PhoneRequestDto;
import com.project.ace_tprevesion.DTO.response.PhoneResponseDto;
import com.project.ace_tprevesion.Service.impl.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PhoneGraphQLController {

    @Autowired
    private PhoneService phoneService;

    // Mutation pour ajouter un téléphone
    @QueryMapping
    public PhoneResponseDto savePhone(PhoneRequestDto phoneRequestDto) {
        return phoneService.addPhone(phoneRequestDto);
    }

    // Mutation pour supprimer un téléphone


    // Requête pour obtenir des téléphones par modèle
    @QueryMapping
    public List<PhoneResponseDto> getPhoneByModel(String model) {
        return phoneService.getPhonesByModel(model);
    }

    // Requête pour obtenir des téléphones par modèle et prix
    @QueryMapping
    public List<PhoneResponseDto> getPhoneByModelAndPrice(String model, Float price) {
        return phoneService.getPhonesByModelAndPrice(model, price);
    }
}