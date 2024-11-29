package com.project.ace_tprevesion.Mapper;


import com.project.ace_tprevesion.DTO.request.PhoneRequestDto;
import com.project.ace_tprevesion.DTO.response.PhoneResponseDto;
import com.project.ace_tprevesion.Entity.Phone;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))

public interface PhoneMapper {
    Phone dtoToModel (PhoneRequestDto phoneRequestDto);
    PhoneResponseDto modelToDto (Phone phone);
default Page<PhoneResponseDto> modelToDtos(Page<Phone>phonePage){
    return phonePage.map(this::modelToDto);
}
}
