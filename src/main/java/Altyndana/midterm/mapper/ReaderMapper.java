package Altyndana.midterm.mapper;

import Altyndana.midterm.dto.BookDto;
import Altyndana.midterm.dto.ReaderDto;
import Altyndana.midterm.models.Book;
import Altyndana.midterm.models.Reader;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReaderMapper {
    @Mapping(target = "nameDto", source = "name")
    ReaderDto toDto(Reader reader);

    @Mapping(target = "name", source = "nameDto")
    Reader toEntity(ReaderDto readerDto);

    List<ReaderDto> toDtoList(List<Reader> readerList);
}
