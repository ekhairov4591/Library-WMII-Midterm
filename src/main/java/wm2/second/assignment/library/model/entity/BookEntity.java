package wm2.second.assignment.library.model.entity;

import wm2.second.assignment.library.model.dto.RegistrationModel;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Type was AUTO
    @Column(name="id")
    private Long id;

    private String bookname;
    private String bookauthor;
    private String date;
    private String genre;
    private int available;


    public BookEntity() {
    }

    public BookEntity(String bookname, String bookauthor, String date, String genre, int available) {
        this.bookname = bookname;
        this.bookauthor = bookauthor;
        this.date = date;
        this.genre = genre;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", bookauthor='" + bookauthor + '\'' +
                ", date='" + date + '\'' +
                ", genre='" + genre + '\'' +
                ", available=" + available +
                '}';
    }
}
