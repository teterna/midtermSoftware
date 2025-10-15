package Altyndana.midterm.service.sImpl;

import Altyndana.midterm.dto.BookDto;
import Altyndana.midterm.mapper.BookMapper;
import Altyndana.midterm.models.Book;
import Altyndana.midterm.models.Reader;
import Altyndana.midterm.repository.BookRepo;
import Altyndana.midterm.repository.ReaderRepo;
import Altyndana.midterm.service.BookS;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookSImpl implements BookS {
    private final BookRepo bookRepo;
    private final BookMapper bookMapper;
    private final ReaderRepo readerRepo;

    @Override
    public List<BookDto> getAll() {
        return bookMapper.toDtoList(bookRepo.findAll());
    }

    @Override
    public BookDto getById(Long id) {
        return bookMapper.toDto(bookRepo.findById(id).orElseThrow());
    }

    @Override
    public boolean delete(Long id) {
        if (bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean save(BookDto bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        bookRepo.save(book);
        return true;
    }

    @Override
    public boolean update(Long id, BookDto bookDto) {
        Book newBook = bookMapper.toEntity(bookDto);
        Book oldBook = bookRepo.findById(id).orElseThrow();
        oldBook.setName(newBook.getName());

        bookRepo.save(oldBook);
        return true;
    }

    @Override
    public boolean saveW(Long id, Long readerId) {
        if (bookRepo.existsById(id) && bookRepo.existsById(readerId)) {
            Book book = bookRepo.findById(readerId).orElseThrow();
            Reader reader = readerRepo.findById(id).orElseThrow();

            book.getReaderList().add(reader);
            reader.getBookList().add(book);

            return true;
        } else {
            return false;
        }
    }
}
