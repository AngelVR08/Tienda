package com.angel.btsstore.controllers;

import com.angel.btsstore.App;
import com.angel.btsstore.models.Disco;
import com.angel.btsstore.models.Inventario;
import com.angel.btsstore.models.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AgregarDiscoController{

    @FXML
    private Button agregarDisbtm;

    @FXML
    private TextField albumTxt;

    @FXML
    private TextField fSalidaTxt;

    @FXML
    private ListView<String> inventarioDistxt;

    @FXML
    private TextField nombreDistxt;

    @FXML
    private TextField precioDistxt;
    @FXML
    private TextField cantidadTxt;
    @FXML
    private Button salirDisbtm;
    @FXML
    void initialize(){
        Inventario inventario = App.getTienda().getInventario();

        inventarioDistxt.getItems().clear();
        for (Producto i: inventario.getProductos()){
         if (i instanceof Disco){
             inventarioDistxt.getItems().add(((Disco) i).imprimirProduct());
         }
        }

    }
    @FXML
    void onAgregarBtn(){
        Inventario inventario = App.getTienda().getInventario();

        String nombre = nombreDistxt.getText();
        double precio = Double.parseDouble(precioDistxt.getText());
        String fSalida = fSalidaTxt.getText();
        String album = albumTxt.getText();
        int cantidad = Integer.parseInt(cantidadTxt.getText());

        Disco disco = new Disco(nombre,precio,fSalida,cantidad,album);
        boolean agregado = inventario.agregarProducto(disco);
        if (agregado){
            inventarioDistxt.getItems().add(disco.imprimirProduct());
            System.out.println("Disco Agregado");
        }else{
            System.out.println("Disco no agregado");
        }
    }
    @FXML
    void onSalirBtn(MouseEvent event){
        App.nuevaVentana(event,"AdministrarTienda","Bts Store");
    }

}