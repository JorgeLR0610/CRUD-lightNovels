package com.ln.crudln.model;

public class LightNovel {
    private String title, author;
    private int pages;

    public LightNovel(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    @Override
    public String toString() { //Es muy importante sobreescribir este método de toString porque es clave para definir cómo se representa esta clase a sí misma en texto (String), por ejemplo cuando se pone un sout(<objeto de la clase>) lo cual se hace en el archivo menu cuando muestro todos los libros
        return "Title: " + title + ", Author: " + author + ", Pages: " + pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
