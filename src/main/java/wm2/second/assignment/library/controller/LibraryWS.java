package wm2.second.assignment.library.controller;

import org.springframework.http.ResponseEntity;
import wm2.second.assignment.library.model.dto.RegistrationModel;
import wm2.second.assignment.library.model.entity.BookEntity;

import javax.xml.ws.Response;

public interface LibraryWS {
    ResponseEntity getBooksService();

    ResponseEntity pickBookService(Long bookId, String email);

}
