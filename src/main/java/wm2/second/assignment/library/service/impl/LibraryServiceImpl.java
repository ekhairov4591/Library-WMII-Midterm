package wm2.second.assignment.library.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wm2.second.assignment.library.repository.BookRepositroy;
import wm2.second.assignment.library.repository.UserRepository;
import wm2.second.assignment.library.service.LibraryService;


@Service
public class LibraryServiceImpl implements LibraryService {

    protected static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepositroy bookRepositroy;

    @Override
    public Iterable getAllBooks() {

        //BookEntity book;

        Iterable book = bookRepositroy.findAll(); // finding all Not Null IDs

        if(book == null ) return null;
        else
        return book;
    }


}
