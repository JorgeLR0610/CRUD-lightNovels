package com.ln.crudln;

import com.ln.crudln.db.LightNovelDAO;
import com.ln.crudln.service.LightNovelService;
import com.ln.crudln.ui.Menu;

public class Main {
    public static void main(String[] args) {
        //1. Crear el nuevo dao (Acceso a datos)
        LightNovelDAO dao = new LightNovelDAO();

        //2. Inyectar el DAO en el servicio
        LightNovelService service = new LightNovelService(dao);

        //3. Inyectar el servicio en el menú
        Menu menu = new Menu(service);

        //Iniciar la aplicación
        menu.showMenu();
    }
}
