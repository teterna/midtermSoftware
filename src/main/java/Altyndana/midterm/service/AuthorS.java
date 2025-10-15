package Altyndana.midterm.service;

import Altyndana.midterm.dto.AuthorDto;

import java.util.List;

public interface AuthorS {
    List<AuthorDto> getAll();
    AuthorDto getById(Long id);
    boolean save(AuthorDto authorDto);
    boolean delete(Long id);
    boolean update(Long id, AuthorDto authorDto);
    boolean saveWBook(Long id, Long bookId);
}
