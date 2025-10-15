package Altyndana.midterm.mapper;

import Altyndana.midterm.dto.BookDto;
import Altyndana.midterm.models.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "nameDto", source = "name")
    BookDto toDto(Book book);

    @Mapping(target = "name", source = "nameDto")
    Book toEntity(BookDto bookDto);

    List<BookDto> toDtoList(List<Book> bookList);
}
