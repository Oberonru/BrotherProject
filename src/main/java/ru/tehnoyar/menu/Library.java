package main.java.ru.tehnoyar.menu;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Library {
    ArrayList<Book> bookList = new ArrayList<>();

    public void addBook(String nameOrAuthor) {
        bookList.add(new Book(nameOrAuthor));
    }

    public void addBook(String bookName, String author) {
        bookList.add(new Book(bookName, author));
    }

    public void addBook(String bookName, String author, BookStatus currentStatus) {
        bookList.add(new Book(bookName, author, currentStatus));
    }

    public String stringCorrector(String text) {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String newString = matcher.group();
            return newString;
        }
        return text;
    }

    public Book findBookByName(String name) {
        for (Book book : bookList) {
            if (book.getBookName().equals(name)) {
                return book;
            }
        }
        return null;
    }

    public Book findBookByAuthor(String author) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getAuthor().startsWith(author)) {
                System.out.println(bookList.get(i));
                return bookList.get(i);
            }
        }
        return null;
    }


    public ArrayList<Book> getBooks() {
        return bookList;
    }
}
