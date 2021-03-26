package wm2.second.assignment.library.controller;

import org.springframework.http.ResponseEntity;
import wm2.second.assignment.library.model.dto.RegistrationModel;
import wm2.second.assignment.library.model.entity.BookEntity;

import javax.xml.ws.Response;

public interface LibraryWS {
    ResponseEntity getBooksService();

    ResponseEntity getBookByNameService(String bookName);
    ResponseEntity getBookByAuthorService(String bookAuthor);
    ResponseEntity getBookByGenreService(String bookGenre);
    ResponseEntity getBookByAvailableService();

}