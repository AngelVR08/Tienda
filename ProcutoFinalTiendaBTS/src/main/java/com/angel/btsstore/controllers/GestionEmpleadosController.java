package com.angel.btsstore.controllers;

import com.angel.btsstore.App;
import com.angel.btsstore.models.Empleado;
import com.angel.btsstore.models.RegistroEmpleados;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class GestionEmpleadosController {

    @FXML
    private Button agregarBtn;

    @FXML
    private ListView<String> lista;

    @FXML
    private TextField nombreTxt;

    @FXML
    private TextField puestoTxt;

    @FXML
    private TextField salarioTxt;

    @FXML
    private Button salirBtn;

    @FXML
    private TextField elimTxt;

    @FXML
    void onAgregarClick() {
        RegistroEmpleados empleados = App.getTienda().getEmpleados();
        String nombre = nombreTxt.getText();
        String puesto = puestoTxt.getText();
        double salario = Double.parseDouble(salarioTxt.getText());

        Empleado empleado = new Empleado(nombre,puesto,salario);

        lista.getItems().add(empleado.imprimirEmpleado());
        boolean exito = empleados.agregarEmpleado(empleado);
        if (exito) {
            App.showAlert(Alert.AlertType.INFORMATION,"Exito","El empleado se agrego con exito.");
        }else{
            App.showAlert(Alert.AlertType.ERROR,"Erro","No se pudo agregar el empleado.");
        }
    }
    @FXML
    void onEliminarClick() {
        RegistroEmpleados empleados = App.getTienda().getEmpleados();;
        String eliminar = elimTxt.getText();
        boolean exito = empleados.eliminarEmpleadoPorNombre(eliminar);
        if (exito){
            App.showAlert(Alert.AlertType.INFORMATION,"Exito","Exito al borrar empleado");
        }
    }

    @FXML
    void onSalirClick(MouseEvent event) {
        App.nuevaVentana(event,"AdministrarTienda","Bts Store");
    }

    @FXML
    void initialize() {
        RegistroEmpleados empleados = App.getTienda().getEmpleados();
        lista.getItems().clear();

        for (Empleado i: empleados.getEmpleados()){
            lista.getItems().add(i.imprimirEmpleado());
        }
    }

}
