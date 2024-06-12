package com.angel.btsstore.controllers;

import com.angel.btsstore.App;
import com.angel.btsstore.models.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class ZonaVentasController {

    @FXML
    private Label cambioLbl;
    @FXML
    private TextField dineroTxt;
    @FXML
    private ListView<String> lista;
    @FXML
    private TextField nameTxt;
    @FXML
    private Label totalLbl;
    @FXML
    private Button venderBtn;
    @FXML
    private Button agregarPBtn;

    @FXML
    void onSalirClick(MouseEvent event) {
        App.nuevaVentana(event,"TiendaInicio","Bts Store");
    }
    @FXML
    void onVenderClick(){
        Venta venta = App.getTienda().getVenta();

        String dineroAux = dineroTxt.getText();
        if (dineroAux.isEmpty()) {
            App.showAlert(Alert.AlertType.ERROR, "Error", "Ingrese el dinero primero");
            return;
        }
        try {
            double dinero = Double.parseDouble(dineroAux);
            double cambio = dinero - venta.getTotal();
            cambioLbl.setText("CAMBIO:  $" + cambio);
        } catch (NumberFormatException e) {
            App.showAlert(Alert.AlertType.ERROR, "Error", "Ingrese un valor numérico válido para el dinero");
        }
        Ticket ticket = venta.finalizarVenta();
        App.getTienda().getVentas().agregarTicket(ticket);
    }
    @FXML
    void onAgregarClick(){
        Venta venta = App.getTienda().getVenta();
        String productoAgregar = nameTxt.getText();
        venta.agregarVenta(productoAgregar);
        lista.getItems().clear();
        for (Producto i: venta.getProductosPorVender()){
            if (i instanceof Disco){
                lista.getItems().add(((Disco) i).imprimirProduct());
            } else if (i instanceof Coleccionable) {
                lista.getItems().add(((Coleccionable) i).imprimirProduct());
            }
        }
        totalLbl.setText("Total: $" + venta.calcularTotal());
    }
    @FXML
    void initialize(){
        lista.getItems().clear();
    }
}
