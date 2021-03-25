package wm2.second.assignment.library.repository;

import org.springframework.data.repository.CrudRepository;
import wm2.second.assignment.library.model.entity.BookEntity;

public interface BookRepositroy  extends CrudRepository<BookEntity, Long> {

    BookEntity findFirstByBookname(String bookName);

    BookEntity findBookEntityByBookauthor(String bookAuthor);

    BookEntity findBookEntityByAvailable(int available);

    BookEntity findAllByIdIsNotNull();
}
