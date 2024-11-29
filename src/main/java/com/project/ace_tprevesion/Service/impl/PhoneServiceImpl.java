package com.project.ace_tprevesion.Service.impl;

import com.project.ace_tprevesion.DTO.request.PhoneRequestDto;
import com.project.ace_tprevesion.DTO.response.PhoneResponseDto;
import com.project.ace_tprevesion.Entity.Phone;
import com.project.ace_tprevesion.Mapper.PhoneMapper;
import com.project.ace_tprevesion.Repository.PhoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class PhoneServiceImpl  implements  PhoneService{
    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;

    @Override
    public List<PhoneResponseDto> getPhonesByModel(String model) {
        List<Phone> phones = phoneRepository.getPhoneByModel(model);
        return phones.stream()
                .map(phoneMapper::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PhoneResponseDto> getPhonesByModelAndPrice(String model, Float price) {
        List<Phone> phones = phoneRepository.getPhoneByModelAndPrice(model, price);
        return phones.stream()
                .map(phoneMapper::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PhoneResponseDto addPhone(PhoneRequestDto phoneRequestDto) {
        Phone phone = phoneMapper.dtoToModel(phoneRequestDto);
        Phone savedPhone = phoneRepository.save(phone);
        return phoneMapper.modelToDto(savedPhone);
    }



    @Override
    public PhoneResponseDto updatePhone(Long phoneId, PhoneRequestDto phoneRequestDto) {
        // Vérifiez que le téléphone existe avant de le mettre à jour
        Phone existingPhone = phoneRepository.findById(phoneId)
                .orElseThrow(() -> new RuntimeException("Phone not found with id: " + phoneId));

        // Mettez à jour les champs nécessaires
        existingPhone.setModel(phoneRequestDto.getModel());
        existingPhone.setColor(phoneRequestDto.getColor());
        existingPhone.setPrice(phoneRequestDto.getPrice());
        existingPhone.setImei(phoneRequestDto.getImei());

        // Sauvegardez les modifications
        Phone updatedPhone = phoneRepository.save(existingPhone);

        // Retournez le Phone mis à jour sous forme de DTO
        return phoneMapper.modelToDto(updatedPhone);
    }

    @Override
    public void deletePhoneById(Long id) {
        if (phoneRepository.existsById(id)) {
            throw new RuntimeException("Phone not found with id: " + id);
        }
        phoneRepository.deleteById(id);
    }
}