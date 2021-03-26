package wm2.second.assignment.library.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import wm2.second.assignment.library.controller.AuthenticationWS;
import wm2.second.assignment.library.controller.LibraryWS;
import wm2.second.assignment.library.model.dto.RegistrationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wm2.second.assignment.library.model.entity.BookEntity;
import wm2.second.assignment.library.model.entity.UserEntity;
import wm2.second.assignment.library.service.LibraryService;

import java.util.List;


@RestController
@RequestMapping("/auth")
public class LibraryWSImpl implements LibraryWS {

    protected static Logger log = LoggerFactory.getLogger(AuthenticationWSImpl.class);

    //injecting service
    @Autowired
    private LibraryService libraryService;

    @Override
    @RequestMapping(value = "/login/books", method = RequestMethod.GET)
    public ResponseEntity getBooksService() {

        try {
            Iterable book = libraryService.getAllBooks();

            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e){
            log.info("Retrieval Exception");
        }
        log.info("Failed to Retrieve");
        return ResponseEntity.notFound().build(); // if no books
    }

    @Override
    @RequestMapping(value = "/login/pickBook", method = RequestMethod.POST)
    public ResponseEntity pickBookService(@RequestHeader("bookId") Long bookId,
                                          @RequestHeader("email") String email) {

        BookEntity bookEntity;
        UserEntity userEntity;


        return null;
    }

}
