package com.angel.btsstore.controllers;

import com.angel.btsstore.App;
import com.angel.btsstore.models.RegistroVentas;
import com.angel.btsstore.models.Ticket;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class HistorialVentasController {

    @FXML
    private ListView<String> lista;

    @FXML
    private Button salirBtn;

    @FXML
    void onSalirClick(MouseEvent event) {
        App.nuevaVentana(event,"AdministrarTienda","Bts Store");
    }
    @FXML
    void initialize() {
        RegistroVentas ventas = App.getTienda().getVentas();
        lista.getItems().clear();

        for (Ticket i: ventas.getTickets()){
            lista.getItems().add(ventas.imprimirTicket(i));
        }
    }
}
