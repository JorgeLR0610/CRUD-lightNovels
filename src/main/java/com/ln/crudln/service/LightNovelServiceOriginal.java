package com.ln.crudln.service;

import com.ln.crudln.db.LightNovelDAO;
import com.ln.crudln.model.LightNovel;

import java.util.ArrayList;
import java.util.List;

//Este archivo contendrá la lógica del negocio, concretamente los métodos de agregar, eliminar, etc.
public class LightNovelServiceOriginal {
    List<LightNovel> lightNovels = new ArrayList<>(); //Se crea una lista de objetos de la clase LightNovel, cuyo nombre será lightNovels, usando un ArrayList


    public void addBook(String title, String author, int pages) {
        lightNovels.add(new LightNovel(title, author, pages));
    }

    public void deleteBook(int index) {
        if (index >= 0 && index < lightNovels.size()) {
            lightNovels.remove(index);
        }
    }

    public void modifyBook(int index, String newTitle, String newAuthor, int newPages) { //Para modificar un libro, se tendrá que acceder a él mediante el número de índice
        if (index >= 0 && index < lightNovels.size()) {
            LightNovel ln = lightNovels.get(index); //Es necesario crear un objeto de la clase LightNovel original para que pueda usar los setters, de modo que al crearse se le asignan los datos del libro actual
            ln.setTitle(newTitle);
            ln.setAuthor(newAuthor);
            ln.setPages(newPages);
        }
    }

    public List<LightNovel> getBooks() {
        return lightNovels;
    }
}
