package com.angel.btsstore.models;

import java.util.ArrayList;

public class Ticket {
    private ArrayList<Producto> productosVendidos = new ArrayList<>();
    private double total;

    public Ticket() {
    }

    public Ticket(double total) {
        this.total = total;
    }

    public ArrayList<Producto> getProductosVendidos() {
        return productosVendidos;
    }

    public double getTotal() {
        return total;
    }

    public void setProductosVendidos(ArrayList<Producto> productosVendidos) {
        this.productosVendidos = productosVendidos;
    }
}
