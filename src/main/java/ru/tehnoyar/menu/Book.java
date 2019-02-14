package main.java.ru.tehnoyar.menu;

import java.util.Date;

public class Book {
    private String bookName;
    private String author;
    private Date dateRead;
    private BookStatus status;

    public Book() {}

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    public Book(String bookName, String author, BookStatus status) {
        this.bookName = bookName;
        this.author = author;
        this.status = status;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDateRead() {
        return dateRead;
    }

    public void setDateRead(Date dateRead) {
        this.dateRead = dateRead;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("\"%s\", %s", bookName, author);
    }


}
