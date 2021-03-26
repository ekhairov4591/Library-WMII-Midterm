package wm2.second.assignment.library.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import wm2.second.assignment.library.controller.LibraryWS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wm2.second.assignment.library.model.entity.BookEntity;
import wm2.second.assignment.library.service.LibraryService;

import java.util.List;


@RestController
@RequestMapping("/auth")
public class LibraryWSImpl implements LibraryWS {

    protected static Logger log = LoggerFactory.getLogger(LibraryWSImpl.class);

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
    @RequestMapping(value = "/login/getbookbyname", method = RequestMethod.GET)
    public ResponseEntity getBookByNameService(@RequestParam("bookName") String bookName) {

        try{
            List<BookEntity> book = libraryService.getBookByName(bookName);
            log.info("Retrieved book by name in getBookByName()");
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e){
            log.info("Retrieval Exception in getBookByName()");
        }
        log.info("Failed to Retrieve in getBookByName()");
        return ResponseEntity.notFound().build(); // if no available books
    }

    @Override
    @RequestMapping(value = "/login/getbookbyauthor", method = RequestMethod.GET)
    public ResponseEntity getBookByAuthorService(@RequestParam("author") String bookAuthor) {

        try{
            List<BookEntity> book = libraryService.getBookByAuthor(bookAuthor);
            log.info("Retrieved book by name in getBookByAuthor()");
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e){
            log.info("Retrieval Exception in getBookByAuthor()");
        }
        log.info("Failed to Retrieve in getBookByAuthor()");
        return ResponseEntity.notFound().build(); // if no available books
    }

    @Override
    @RequestMapping(value = "/login/getbookbygenre", method = RequestMethod.GET)
    public ResponseEntity getBookByGenreService(@RequestParam("genre") String bookGenre) {

        try{
            List<BookEntity> book = libraryService.getBookByGenre(bookGenre);
            log.info("Retrieved book by name in getBookByGenre()");
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e){
            log.info("Retrieval Exception in getBookByGenre()");
        }
        log.info("Failed to Retrieve in getBookByGenre()");
        return ResponseEntity.notFound().build(); // if no available books
    }

    @Override
    @RequestMapping(value = "/login/getbookbyav", method = RequestMethod.GET)
    public ResponseEntity getBookByAvailableService() {

        try{
            List<BookEntity> book = libraryService.getBookByAvailable();
            log.info("Retrieved book by name in getBookByAvailable()");
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e){
            log.info("Retrieval Exception in getBookByAvailable()");
        }
        log.info("Failed to Retrieve in getBookByAvailable()");
        return ResponseEntity.notFound().build(); // if no available books
    }


}