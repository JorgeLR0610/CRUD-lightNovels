package com.ln.crudln.db;//El chiste de este archivo es que será la única parte del programa que toca directamente el archivo de la base de datos

import com.ln.crudln.model.LightNovel;

import java.sql.*; //El * importa todas las clases necesarias para la conectividad con bases de datos en Java (JDBC API). Incluye Connection, Statement, ResultSet, SQLException, etc.
import java.util.ArrayList;
import java.util.List;

public class LightNovelDAO {
    private final String url = "jdbc:sqlite:lightnovels.db"; //Se define la dirección de la BD, que en este caso es lightnovels.db, aunque no la he creado aún

    public LightNovelDAO() { //Constructor
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS light_novels (" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "    title TEXT NOT NULL UNIQUE," +
                    "    author TEXT NOT NULL," +
                    "    pages INTEGER NOT NULL" +
                    ");";
            //Se añadió un campo id y title es UNIQUE, esto es una práctica estándar y muy recomendable para evitar duplicados.
            stmt.execute(sql);
        } catch (
                SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    public void addBook(LightNovel ln) {
        String sql = "INSERT INTO light_novels(title, author, pages) VALUES(?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ln.getTitle());
            pstmt.setString(2, ln.getAuthor());
            pstmt.setInt(3, ln.getPages());
            pstmt.executeUpdate();

        } catch (
                SQLException e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    public List<LightNovel> getAllBooks() {
        String sql = "SELECT * FROM light_novels";
        List<LightNovel> lightNovels = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                LightNovel ln = new LightNovel(
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("pages")
                );
                lightNovels.add(ln);
            }
        } catch (
                SQLException e) {
            System.out.println("Error getting books: " + e.getMessage());
        }
        return lightNovels;
    }

    public void updateBook(String oldTitle, LightNovel newBookData) {
        String sql = "UPDATE light_novels SET title = ?, author = ?, pages = ? WHERE title = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newBookData.getTitle());
            pstmt.setString(2, newBookData.getAuthor());
            pstmt.setInt(3, newBookData.getPages());
            pstmt.setString(4, oldTitle); // El placeholder más importante
            pstmt.executeUpdate();

        } catch (
                SQLException e) {
            System.out.println("Error updating book: " + e.getMessage());
        }
    }

    public void deleteBook(String title) {
        String sql = "DELETE FROM light_novels WHERE title = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, title);
            pstmt.executeUpdate();

        } catch (
                SQLException e) {
            System.out.println("Error deleting book: " + e.getMessage());
        }

    }
}
