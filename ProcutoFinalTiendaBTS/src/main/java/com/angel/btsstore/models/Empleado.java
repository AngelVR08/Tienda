package com.angel.btsstore.models;

public class Empleado {
    String nombre;
    String puesto;
    double salario;

    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String imprimirEmpleado(){
        String stringBuilder = "--------------------\n" +
                "Nombre: " + " < " + nombre + " >\n" +
                "Puesto: " + " < " + puesto + " >\n" +
                "salario: " + " < " + salario + " >\n";

        return stringBuilder;
    }
}
