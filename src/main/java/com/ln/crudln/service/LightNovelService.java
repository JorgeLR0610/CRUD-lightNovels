package com.ln.crudln.service;

import com.ln.crudln.db.LightNovelDAO;
import com.ln.crudln.model.LightNovel;

import java.util.ArrayList;
import java.util.List;

//Este archivo contendrá la lógica del negocio, concretamente los métodos de agregar, eliminar, etc.
public class LightNovelService {
    List<LightNovel> lightNovels = new ArrayList<>(); //Se crea una lista de objetos de la clase LightNovel, cuyo nombre será lightNovels, usando un ArrayList

    private final LightNovelDAO dao; //Un objeto de nombre dao de la clase LightNovelDao se crea como atributo de esta clase service para que efectúe las operaciones en la bd

    public LightNovelService(LightNovelDAO dao) {
        this.dao = dao;
    }

    public void addBook(String title, String author, int pages) {
        LightNovel ln = new LightNovel(title, author, pages);
        dao.addBook(ln);
    }

    public void deleteBook(String title) {
        dao.deleteBook(title);
    }

    public void modifyBook(String oldTitle, String newTitle, String newAuthor, int newPages) {
        LightNovel updatedLn = new LightNovel(newTitle, newAuthor, newPages); //Crea un objeto de la clase LightNovel con los nuevos datos
        dao.updateBook(oldTitle, updatedLn); //Le pasa el identificador antiguo y el objeto nuevo al DAO
    }

    public List<LightNovel> getBooks() {
        return dao.getAllBooks();
    }
}
