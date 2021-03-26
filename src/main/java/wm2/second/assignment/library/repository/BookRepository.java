
package wm2.second.assignment.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wm2.second.assignment.library.model.entity.BookEntity;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {

    List<BookEntity> findAllByBookname(String bookname);
    List<BookEntity> findAllByBookauthor(String bookname);
    List<BookEntity> findAllByGenre(String bookname);
    List<BookEntity> findAllByDate(String bookname);


    List<BookEntity> findAllByAvailable(String available);
}