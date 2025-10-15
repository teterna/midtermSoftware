package Altyndana.midterm.service.sImpl;

import Altyndana.midterm.dto.AuthorDto;
import Altyndana.midterm.mapper.AuthorMapper;
import Altyndana.midterm.models.Author;
import Altyndana.midterm.models.Book;
import Altyndana.midterm.repository.AuthorRepo;
import Altyndana.midterm.repository.BookRepo;
import Altyndana.midterm.service.AuthorS;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorSImpl implements AuthorS {
    private final AuthorRepo authorRepo;
    private final AuthorMapper authorMapper;
    private final BookRepo bookRepo;

    @Override
    public List<AuthorDto> getAll() {
        return authorMapper.toDtoList(authorRepo.findAll());
    }

    @Override
    public AuthorDto getById(Long id) {
        return authorMapper.toDto(authorRepo.findById(id));
    }

    @Override
    public boolean delete(Long id) {
        if (authorRepo.existsById(id)) {
            authorRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean save(AuthorDto authorDto) {
        Author author = authorMapper.toEntity(authorDto);
        authorRepo.save(author);
        return true;
    }

    @Override
    public boolean update(Long id, AuthorDto authorDto) {
        Author newAuthor = authorMapper.toEntity(authorDto);
        Author oldAuthor = authorRepo.findById(id).orElseThrow();
        oldAuthor.setFName(newAuthor.getFName());
        oldAuthor.setLName(newAuthor.getLName());
        oldAuthor.setEmail(newAuthor.getEmail());
        oldAuthor.setAge(newAuthor.getAge());

        authorRepo.save(oldAuthor);
        return true;
    }

    @Override
    public boolean saveWBook(Long id, Long bookId) {
        if (authorRepo.existsById(id) && bookRepo.existsById(bookId)) {
            Author author = authorRepo.findById(id).orElseThrow();
            Book book = bookRepo.findById(bookId).orElseThrow();

            author.getBookList().add(book);

            book.setAuthor(author);

            authorRepo.save(author);

            return true;
        } else {
            return false;
        }
    }
}
