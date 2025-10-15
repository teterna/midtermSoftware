package Altyndana.midterm.service;

import Altyndana.midterm.dto.AuthorDto;
import Altyndana.midterm.dto.BookDto;

import java.util.List;

public interface BookS {
    List<BookDto> getAll();
    BookDto getById(Long id);
    boolean delete(Long id);
    boolean update(Long id, BookDto bookDto);
    boolean save(BookDto bookDto);
    boolean saveW(Long id, Long readerId);
}
