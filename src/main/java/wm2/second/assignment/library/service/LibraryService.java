package wm2.second.assignment.library.service;


import wm2.second.assignment.library.model.entity.BookEntity;

import java.util.List;

public interface LibraryService {
    Iterable getAllBooks();

    List<BookEntity> getBookByName(String bookName);

    List<BookEntity> getBookByAuthor(String bookAuthor);

    List<BookEntity> getBookByGenre(String bookGenre);

    List<BookEntity> getBookByDate(String date);

    List<BookEntity> getBookByAvailable();
}