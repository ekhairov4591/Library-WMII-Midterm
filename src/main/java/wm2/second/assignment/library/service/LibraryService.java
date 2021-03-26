package wm2.second.assignment.library.service;


import wm2.second.assignment.library.model.entity.BookEntity;

public interface LibraryService {
Iterable getAllBooks();

boolean pickBook(BookEntity book);
}
