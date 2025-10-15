package Altyndana.midterm.mapper;

import Altyndana.midterm.dto.AuthorDto;
import Altyndana.midterm.models.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    @Mapping(target = "fNameDto", source = "fName")
    @Mapping(target = "lNameDto", source = "lName")
    @Mapping(target = "emailDto", source = "email")
    @Mapping(target = "ageDto", source = "age")
    AuthorDto toDto(Optional<Author> author);

    @Mapping(target = "fName", source = "fNameDto")
    @Mapping(target = "lName", source = "lNameDto")
    @Mapping(target = "email", source = "emailDto")
    @Mapping(target = "age", source = "ageDto")
    Author toEntity(AuthorDto authorDto);

    List<AuthorDto> toDtoList(List<Author> authorsList);

}
