package Altyndana.midterm.service.sImpl;

import Altyndana.midterm.dto.ReaderDto;
import Altyndana.midterm.mapper.ReaderMapper;
import Altyndana.midterm.models.Book;
import Altyndana.midterm.models.Reader;
import Altyndana.midterm.repository.BookRepo;
import Altyndana.midterm.repository.ReaderRepo;
import Altyndana.midterm.service.ReaderS;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderSImpl implements ReaderS {
    private final BookRepo bookRepo;
    private final ReaderMapper readerMapper;
    private final ReaderRepo readerRepo;

    @Override
    public List<ReaderDto> getAll() {
        return readerMapper.toDtoList(readerRepo.findAll());
    }

    @Override
    public ReaderDto getById(Long id) {
        return readerMapper.toDto(readerRepo.findById(id).orElseThrow());
    }

    @Override
    public boolean delete(Long id) {
        if (readerRepo.existsById(id)) {
            readerRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean save(ReaderDto readerDto) {
        Reader reader = readerMapper.toEntity(readerDto);
        readerRepo.save(reader);
        return true;
    }

    @Override
    public boolean update(Long id, ReaderDto readerDto) {
        Reader newBook = readerMapper.toEntity(readerDto);
        Reader oldBook = readerRepo.findById(id).orElseThrow();
        oldBook.setName(newBook.getName());

        readerRepo.save(oldBook);
        return true;
    }

    @Override
    public boolean saveW(Long id, Long bookId) {
        if (bookRepo.existsById(id) && bookRepo.existsById(bookId)) {
            Book book = bookRepo.findById(bookId).orElseThrow();
            Reader reader = readerRepo.findById(id).orElseThrow();

            reader.getBookList().add(book);
            book.getReaderList().add(reader);

            return true;
        } else {
            return false;
        }
    }
}
