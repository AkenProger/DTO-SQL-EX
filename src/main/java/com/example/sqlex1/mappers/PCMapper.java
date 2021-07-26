package com.example.sqlex1.mappers;

import com.example.sqlex1.models.PC;
import com.example.sqlex1.models.dto.PCDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface PCMapper {
    PCMapper INSTANCE = Mappers.getMapper(PCMapper.class);
    PC toPC(PCDto pcDto);
    PCDto toPcDto(PC pc);

    List<PC> toPCs(List<PCDto> pcDtos);
    List<PCDto> toPCDtos(List<PC> pcDtos);

}
