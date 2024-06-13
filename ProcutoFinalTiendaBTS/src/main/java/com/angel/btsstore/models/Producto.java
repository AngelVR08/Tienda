package com.angel.btsstore.models;

import java.util.Objects;

public class Producto {
    protected String nombre;
    protected double precio;
    protected String fechaSalida;
    protected int cantidad;

    public Producto(String nombre, double precio, String fechaSalida, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.fechaSalida = fechaSalida;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }
    public double getPrecio() {
        return precio;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(nombre, producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

}
