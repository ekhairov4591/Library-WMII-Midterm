package wm2.second.assignment.library.model.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Data // automatically creates getters & setters, toString, equals, hash methods
public class BookModel implements Serializable {
    private String name;
    private String author;
    private String description;
    private Date published_at;
}
