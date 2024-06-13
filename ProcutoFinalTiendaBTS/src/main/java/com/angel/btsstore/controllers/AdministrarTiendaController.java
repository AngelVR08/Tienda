package com.angel.btsstore.controllers;

import com.angel.btsstore.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.sql.*;

public class AdministrarTiendaController {

    @FXML
    private Button salir;
    @FXML
    private Button coleccionables;
    @FXML
    private Button disco;
    @FXML
    private Button elimProductoBtn;
    String url = "jdbc:mysql://localhost:3306/tienda?serverTimezone=UTC";
    String username = "root";
    String pass = "12345678";

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    //imprimir los datos de sql
    {
        try {
            connection = DriverManager.getConnection(url, username, pass);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM products");

            while (resultSet.next()){
                System.out.println( resultSet.getString("nombre") + " | " + resultSet.getString("precio") +
                        resultSet.getString("fechaSalida") + " | " + resultSet.getString("stock") + " | ");
            }

            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onColeccionablesBtn(MouseEvent event){
        App.nuevaVentana(event,"AgregarColeccionable","Agrega un coleccionable...");
    }
    @FXML
    void onAgregarEmpleadoCLick(MouseEvent event){
        App.nuevaVentana(event,"EmpleadosBTS","Empleados...");
    }
    @FXML
    void onHistorialVentasCLick(MouseEvent event){
        App.nuevaVentana(event,"HistorialVentasBTS","Historial de las ventas...");
    }
    @FXML
    void onGestionEmpleadosClick(MouseEvent event){
        App.nuevaVentana(event,"EmpleadosBTS","Empleados...");
    }
    @FXML
    void onDiscoBtn(MouseEvent event){
        App.nuevaVentana(event,"AgregarDisco","Agrega un Disco...");
    }
    @FXML
    void onEliminarBtn(MouseEvent event){
        App.nuevaVentana(event,"EliminarProducto","Elimina un producto...");
    }
    @FXML
    void onSalirBtn(MouseEvent event){
        App.nuevaVentana(event,"TiendaInicio","Bts Store");
    }

}
