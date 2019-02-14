package main.java.ru.tehnoyar.menu;

import java.io.*;
import java.nio.BufferUnderflowException;

public class LibrarySerializer {

    //"6"
    public static void serialize(Library library) throws Exception {
        File fileDirectory = new File("library.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter txtFile = new PrintWriter(new BufferedWriter(new FileWriter(fileDirectory, true)));

        for (Book book : library.getBooks()) {
            txtFile.println(String.format("Книга: \"%s\"   Автор: \"%s%\"n", book.getBookName(), book.getAuthor()));
        }
        txtFile.flush();
        txtFile.close();

    }
}
