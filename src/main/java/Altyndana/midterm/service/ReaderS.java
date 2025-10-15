package Altyndana.midterm.service;

import Altyndana.midterm.dto.BookDto;
import Altyndana.midterm.dto.ReaderDto;

import java.util.List;

public interface ReaderS {
    List<ReaderDto> getAll();
    ReaderDto getById(Long id);
    boolean delete(Long id);
    boolean update(Long id, ReaderDto readerDto);
    boolean save(ReaderDto readerDto);
    boolean saveW(Long id, Long bookId);
}
