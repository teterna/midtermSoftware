package Altyndana.midterm.models;

import Altyndana.midterm.dto.AuthorDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne()
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany(mappedBy = "bookList")
    List<Reader> readerList;
}
