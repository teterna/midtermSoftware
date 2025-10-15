package Altyndana.midterm.controller;

import Altyndana.midterm.dto.AuthorDto;
import Altyndana.midterm.service.AuthorS;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorC {
    private final AuthorS authorS;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(authorS.getAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getById(Long id) {
        return new ResponseEntity<>(authorS.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody AuthorDto authorDto) {
        return new ResponseEntity<>(authorS.save(authorDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AuthorDto authorDto) {
        return new ResponseEntity<>(authorS.update(id, authorDto), HttpStatus.OK);
    }

    @PutMapping("/{id}/book/{bookId}")
    public ResponseEntity<?> saveW(@PathVariable Long id, @PathVariable Long bookId) {
        return new ResponseEntity<>(authorS.saveWBook(id, bookId), HttpStatus.OK);
    }
}
