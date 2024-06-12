package com.angel.btsstore.models;

import com.angel.btsstore.App;

import java.util.ArrayList;

public class Venta {
    private ArrayList<Producto> productosPorVender = new ArrayList<>();
    private double total;

    public ArrayList<Producto> getProductosPorVender() {
        return productosPorVender;
    }

    public double getTotal() {
        return total;
    }

    public void agregarVenta(String name){
        Inventario inventario = App.getTienda().getInventario();
        Producto productoEnInventario = inventario.buscarProducto(name);
        if (productoEnInventario != null && productoEnInventario.getCantidad() > 0) {
            productosPorVender.add(productoEnInventario);
            inventario.reducirStock(name);
        }
    }

    public double calcularTotal() {
        total = 0;
        for (Producto producto : productosPorVender) {
            total += producto.getPrecio();
        }
        return total;
    }
    public Ticket finalizarVenta() {
        Ticket ticket = new Ticket(total);
        ticket.setProductosVendidos(new ArrayList<>(productosPorVender));
        productosPorVender.clear();
        return ticket;
    }
}
