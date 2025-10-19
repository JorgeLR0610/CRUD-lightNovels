package com.ln.crudln.ui;

import com.ln.crudln.service.LightNovelService;
import com.ln.crudln.model.LightNovel;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner sc = new Scanner(System.in);
    //En lugar de instanciar: LightNovelService service = new LightNovelService(); es mejor inyectar la dependencia, es decir, crear el objeto pero pasarlo como parámetro en el constructor
    private final LightNovelService service; //Ahora está como un atributo

    public Menu(LightNovelService service){
        this.service = service;
    }

    public void addBookUI() {
        System.out.print("Type the book's title: ");
        String title = sc.nextLine();

        System.out.print("Type the author's name: ");
        String author = sc.nextLine();

        System.out.print("Type the book's pages: ");
        int pages = sc.nextInt();
        sc.nextLine();

        service.addBook(title, author, pages);
        System.out.println("Book successfully added.\n");
    }

    public void deleteBookUI() {
        System.out.print("Type the book's title to delete: ");
        String title = sc.nextLine();

        service.deleteBook(title);
        System.out.println("Book successfully deleted.\n");
    }

    public void modifyBookUI() {
        System.out.print("Type the book's title to modify: ");
        String oldTitle = sc.nextLine();

        System.out.print("Type the new book's title: ");
        String newTitle = sc.nextLine();

        System.out.print("Type the new author's name: ");
        String newAuthor = sc.nextLine();

        System.out.print("Type the new book's pages: ");
        int newPages = sc.nextInt();

        service.modifyBook(oldTitle, newTitle, newAuthor, newPages);

        System.out.println("Book successfully modified.\n");
    }

    public void getBooksUI() {
        List<LightNovel> ln = service.getBooks();
        if (ln.isEmpty()){
            System.out.println("There are no books in your library yet.");
            return;
        }

        System.out.println("----Book list----");
        for (LightNovel book : ln) {
            System.out.println(book); //Esto utilizar el toString() del objeto de la clase LightNovel que modifiqué.
        }
    }

    public void showMenu() {
        int op = 0;
        while (op != 5) {
            System.out.println("\n----MENU----");
            System.out.println("1. Add a book");
            System.out.println("2. Delete a book");
            System.out.println("3. Edit a book");
            System.out.println("4. Show all books");
            System.out.println("5. Close the program");
            System.out.print("\nType the option's number that you want: ");
            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    addBookUI();
                    break;

                case 2:
                    deleteBookUI();
                    break;

                case 3:
                    modifyBookUI();
                    break;

                case 4:
                    getBooksUI();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Type a valid option please.\n");
                    break;
            }
        }
    }
}
