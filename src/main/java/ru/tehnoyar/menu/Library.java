package main.java.ru.tehnoyar.menu;

import java.util.ArrayList;

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

    public String findBook (ArrayList<Book> bookList, String inputText) {
        ArrayList<String> findList = new ArrayList<>();
        for (int i = 0; i < bookList.size(); i++) {
            String findString =  bookList.get(i).getBookName();
            if (findString.matches(".*" + inputText + ".*")) {
                findList.add(findString);
            }
        }
        return findList.toString();
    }


    public ArrayList<Book> getBooks() {
        return bookList;
    }
}
