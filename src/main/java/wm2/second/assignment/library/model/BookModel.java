package wm2.second.assignment.library.model;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data // automatically creates getters & setters, toString, equals, hash methods
public class BookModel {
    private String name;
    private String author;
    private String description;
    private Date published_at;
}
