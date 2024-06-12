package com.angel.btsstore.controllers;

import com.angel.btsstore.App;
import com.angel.btsstore.models.Coleccionable;
import com.angel.btsstore.models.Disco;
import com.angel.btsstore.models.Inventario;
import com.angel.btsstore.models.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ProductosPorAgotarController {

    @FXML
    private Button eliminarProbtm;

    @FXML
    private TextField AgotarElim;

    @FXML
    private Button salirAgotarBtn;

    @FXML
    private ListView<String> pocasExistencias;
    @FXML
    void initialize(){
        Inventario inventario = App.getTienda().getInventario();

        pocasExistencias.getItems().clear();

        for (Producto j: inventario.getProductosAgotar()){
            if (j instanceof Disco){
                pocasExistencias.getItems().add(((Disco) j).imprimirProduct());
            } else if (j instanceof Coleccionable) {
                pocasExistencias.getItems().add(((Coleccionable) j).imprimirProduct());
            }
        }
    }
    @FXML
    void onSalirBtnClick(MouseEvent event){
        App.nuevaVentana(event,"TiendaInicio","Bts Store");
    }

    @FXML
    void onEliminarBtn(){
        Inventario inventario = App.getTienda().getInventario();
        String eliminar = AgotarElim.getText();

        boolean eliminado = inventario.elimProductAgotar(eliminar);

        if (eliminado){
            System.out.println("Se elimino correctamente");
        }else {
            System.out.println("Fallo al eliminar");
        }
    }
}
