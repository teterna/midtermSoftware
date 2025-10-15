package Altyndana.midterm.controller;

import Altyndana.midterm.dto.AuthorDto;
import Altyndana.midterm.dto.BookDto;
import Altyndana.midterm.service.AuthorS;
import Altyndana.midterm.service.BookS;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookC {
    private final BookS bookS;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(bookS.getAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getById(Long id) {
        return new ResponseEntity<>(bookS.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody BookDto authorDto) {
        return new ResponseEntity<>(bookS.save(authorDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BookDto authorDto) {
        return new ResponseEntity<>(bookS.update(id, authorDto), HttpStatus.OK);
    }

    @PutMapping("/{id}/book/{readerId}")
    public ResponseEntity<?> saveW(@PathVariable Long id, @PathVariable Long readerId) {
        return new ResponseEntity<>(bookS.saveW(id, readerId), HttpStatus.OK);
    }
}
