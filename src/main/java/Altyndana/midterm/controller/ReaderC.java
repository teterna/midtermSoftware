package Altyndana.midterm.controller;

import Altyndana.midterm.dto.BookDto;
import Altyndana.midterm.dto.ReaderDto;
import Altyndana.midterm.service.BookS;
import Altyndana.midterm.service.ReaderS;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class ReaderC {
    private final ReaderS readerS;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(readerS.getAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getById(Long id) {
        return new ResponseEntity<>(readerS.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ReaderDto authorDto) {
        return new ResponseEntity<>(readerS.save(authorDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ReaderDto readerDto) {
        return new ResponseEntity<>(readerS.update(id, readerDto), HttpStatus.OK);
    }

    @PutMapping("/{id}/book/{bookId}")
    public ResponseEntity<?> saveW(@PathVariable Long id, @PathVariable Long bookId) {
        return new ResponseEntity<>(readerS.saveW(id, bookId), HttpStatus.OK);
    }
}

