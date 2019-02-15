package main.java.ru.tehnoyar.menu;

import jdk.nashorn.internal.runtime.ECMAException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Library library = new Library();
    private static File fileDirectory = new File("library.txt");


    public static void main(String[] args) throws Exception {
        LibrarySerializer serrilalize = new LibrarySerializer();
        startMenu();
        int value = 0;
        while (value != 9) {
            switch (reader.readLine()) {
                case "1":
                    bookInitialize();
                    break;
                case "2":
                    bookInitializeStatus();
                    break;
                case "3":
                    showBookList(library);
                    break;
                case "4":
                    showBookFromAuthor(library);
                    break;
                case "5":
                    clearNotepad(library);
                    break;
                case "6":
                    serrilalize.serialize(library);
                    break;
                case "7":
                    case7();
                    break;
                case "9":
                    System.out.println("Выход из программы");
                    break;
                default:
                    System.out.println("Неверный формат введённых данных, введите заново");
                    break;
            }
            startMenu();
        }

    }

    public static void startMenu() {
        System.out.println("Добро пожаловать, дружище,  в мою самопальную программу");
        System.out.println();
        System.out.printf("%-25s%-5s%n", "Цифра на клавиатуре", "Пункт меню");
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("%-25s%-10s%n", "1", "Создание книги (название, имя автора)");
        System.out.printf("%-25s%-10s%n", "2", "Создание книги (название, имя автора, статус прочтения)");
        System.out.printf("%-25s%-10s%n", "3", "Показать список книг из файла txt");
        System.out.printf("%-25s%-10s%n", "4", "Показать список книг из списка,  а не из txt");
        System.out.printf("%-25s%-10s%n", "5", "Очистить весь список книг");
        System.out.printf("%-25s%-10s%n", "6", "Сохранение списка книг в файл");
        System.out.printf("%-25s%-10s%n", "7", "Поиск по названию книги");
        System.out.printf("%-25s%-10s%n", "9", "Выйти из программы");
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("%-65s%-5s%n", " ", "введите число...");
    }

    //"1"
    public static void bookInitialize() throws Exception {
        while (true) {
            System.out.println("Введите название книги");
            String name = reader.readLine();
            if (name.isEmpty()) {
                System.out.println("Пустая строка...");
                break;
            }
            library.addBook(name);
            System.out.println("Введите имя автора");
            String author = reader.readLine();
        }
    }

    //"2"
    public static void bookInitializeStatus() throws Exception {
        PrintWriter fWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileDirectory, true)));
        while (true) {
            try {
                System.out.println("Введите название книги");
                fWriter.flush();
                String name = reader.readLine();
                fWriter.print("Книга: " + name + "   ");
                if (name.isEmpty()) {
                    break;
                }
                System.out.print("Введите имя автора");
                String author = reader.readLine();
                if (!author.isEmpty()) {
                    fWriter.println("Автор: " + author + "   ");
                }
                System.out.println("Статус книги : 1 - ПРОЧИТАНА 2 - ЗАПЛАНИРОВАНА 3 - ОТЛОЖЕНА");
                int numState = Integer.parseInt(reader.readLine());
                fWriter.println("Статус книги: " + BookStatus.parseStatus(numState));
                fWriter.close();
                library.addBook(name, author, BookStatus.parseStatus(numState));
            } catch (IOException ioException) {
            }
        }
    }

    //"3"
    public static void showBookList(Library library) throws FileNotFoundException {
        Scanner scanner = new Scanner(fileDirectory);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    //"4"
    public static void showBookFromAuthor(Library library) {
        ArrayList<Book> books = library.getBooks();
        for (Book book : books) {
            System.out.println(book.getBookName());
            System.out.println(book.getAuthor());
        }

    }

    //"5"
    public static void clearNotepad(Library library) throws Exception {
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileDirectory)));
        for (Book book : library.getBooks()) {
            System.out.println("Очистка библиотеки");
            writer.print("");
            writer.close();
        }

//        System.out.println("Точно хотите очистить всю библиотеку? ");
//        System.out.println("Да - 1    Нет - 2   Не знаю - 3");
//        int num = Integer.parseInt(reader.readLine());
//        switch (num) {
//            case 1:
//                System.out.println("Файл очищен");
//                writer.print("");
//                break;
//            case 2:
//                return;
//            case 3://как по кругу  пустить
//                System.out.println("Я тоже не знаю ");
//                System.out.println("Точно хотите очистить всю библиотеку? \n");
//                System.out.println("Да - 1    Нет - 2   Не знаю - 3");
//                break;
//            default:
//                System.out.println("Неверный формат ввёдённых данных");
//        }
//        writer.close();
    }
    //"7"
    public static void case7() throws IOException {
        System.out.println("Введите название книги для поиска");
        String bookName = reader.readLine();
        System.out.println(library.findBook(library.getBooks(), bookName));
    }

    public static void inputBookName() throws IOException {
        System.out.println("Введите название книги");
        String name = reader.readLine();
        if (name.isEmpty()) {
            System.out.println("Пустая строка...");
            return;
        }
        library.addBook(name);
    }

    public static void inputAuthorName() throws IOException {
        System.out.println("Введите имя автора");
        String author = reader.readLine();
        if (!author.isEmpty()) {
            System.out.println("Автор: " + author);
        }
    }

    public void inputBookStatus() throws Exception {
        System.out.println("Статус книги : 1 - ПРОЧИТАНА 2 - ЗАПЛАНИРОВАНА 3 - ОТЛОЖЕНА");
        int numState = Integer.parseInt(reader.readLine());
        System.out.println("Статус книги: " + BookStatus.parseStatus(numState));
    }
}
