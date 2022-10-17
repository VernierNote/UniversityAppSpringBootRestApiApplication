package com.java.springboot.task.mapper;

import com.java.springboot.task.dto.FacultyDto;
import com.java.springboot.task.entity.Faculty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.stream.Collectors;

@Mapper
public interface FacultyMapper {

    FacultyMapper MAPPER = Mappers.getMapper(FacultyMapper.class);

        @Mappings({
            @Mapping(source = "faculty.id", target = "id"),
            @Mapping(source = "faculty.name", target = "name"),
    })
    FacultyDto mapToDto(Faculty faculty);

    default Page<FacultyDto> mapCollectionToDto(
            Page<Faculty> source) {
        return new PageImpl(source.getContent().stream().map(this::mapToDto).collect(Collectors.toList()), source.getPageable(), source.getTotalElements());
    }
}
