package com.angel.btsstore.controllers;

import com.angel.btsstore.App;
import com.angel.btsstore.models.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class TiendaInicioController {
    @FXML
    private Label masInfoBtn;
    @FXML
    private Button administracionBtn;
    @FXML
    private Button agregarBtn;
    @FXML
    private TextField agregarPAgotar;
    @FXML
    private TextField buscarProductTxt;
    @FXML
    private ListView<String> listaProductos;
    @FXML
    private Button salirBtn;
    @FXML
    private Button pAgotarBtn;
    @FXML
    void cerrarVentana() {
        Stage stage = (Stage) salirBtn.getScene().getWindow();

        stage.close();
    }
    @FXML
    void initialize() {
        Tienda tienda = App.getTienda();
        Inventario inventario = tienda.getInventario();

        listaProductos.getItems().clear();
        for (Producto i:inventario.getProductos()){
            if (i instanceof Disco){
                listaProductos.getItems().add(((Disco) i).imprimirProduct());
            } else if (i instanceof Coleccionable) {
                listaProductos.getItems().add(((Coleccionable) i).imprimirProduct());
            }
        }
    }
    @FXML
    void onVerAgotarClick(MouseEvent event){
        App.nuevaVentana(event,"ProductosPorAgotarBTS", "Productos por agotar...");
    }
    @FXML
    void onAdministracionCLick(MouseEvent event){
        App.nuevaVentana(event,"AdministrarTienda","Administra la tienda...");
    }
    @FXML
    void onAgregarAgotarClick(){
        Inventario inventario = App.getTienda().getInventario();

        String agotar = agregarPAgotar.getText();

        boolean exito = inventario.agregarAgotar(agotar);
        if (exito){
            App.showAlert(Alert.AlertType.INFORMATION,"Exito","Se actualizo la lista.");
        }else {
            App.showAlert(Alert.AlertType.ERROR,"Error","No se encontro el producto.");
        }
    }
    @FXML
    void onVentasClick(MouseEvent event){
        App.nuevaVentana(event,"ZonasVentasBTS","Ventas...");
    }
    @FXML
    void btnNavegador() {
        String url = "https://www.facebook.com/BTSshopMex?mibextid=ZbWKwL";
        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
        } catch (java.io.IOException | java.net.URISyntaxException e) {
            e.printStackTrace();
            App.showAlert(Alert.AlertType.ERROR,"Error","No se pudo abrir el navegador");
        }
    }
    @FXML
    void buscarClick(){
        Inventario inventario = App.getTienda().getInventario();

        String objetivo = buscarProductTxt.getText();
        Producto producto = inventario.buscarProducto(objetivo);
        if (producto == null){
            App.showAlert(Alert.AlertType.ERROR,"Error","No se encontro el producto");
        }else{
            listaProductos.getItems().clear();
            listaProductos.getItems().add("------------------------------------");
            listaProductos.getItems().add("         Producto buscado:");
            if (producto instanceof Disco){
                listaProductos.getItems().add(((Disco) producto).imprimirProduct());
            } else if (producto instanceof Coleccionable) {
                listaProductos.getItems().add(((Coleccionable) producto).imprimirProduct());
            }
        }
    }
}
