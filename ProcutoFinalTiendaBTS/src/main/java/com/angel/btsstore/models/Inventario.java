package com.angel.btsstore.models;

import java.util.ArrayList;

public class Inventario {
    ArrayList <Producto> productos = new ArrayList<>();
    ArrayList <Producto> productosAgotar = new ArrayList<>();
    public ArrayList<Producto> getProductos() {
        return productos;
    }
    public ArrayList<Producto> getProductosAgotar() {
        return productosAgotar;
    }
    public Boolean elimProducto (String nombre){
        boolean eliminado = false;
        for (int i = 0; i < productos.size(); i++){
            if (nombre.equalsIgnoreCase(productos.get(i).getNombre())){
                productos.remove(i);
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }
    public boolean elimProductAgotar(String eliminar) {
        boolean eliminado = false;

        for (int i = 0; i < productosAgotar.size() - 1; i++) {
            if (eliminar.equalsIgnoreCase(productosAgotar.get(i).getNombre())) {
                productos.remove(i);
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }
    public boolean agregarProducto(Producto producto){
        return productos.add(producto);
    }
    public boolean agregarAgotar(String name){
        for (Producto i:productos){
            if (name.equalsIgnoreCase(i.getNombre())){
                return productosAgotar.add(i);
            }
        }
        return false;
    }
    public Producto buscarProducto(String nombre){
        Producto producto = null;
        for (Producto i:productos){
            if (nombre.equalsIgnoreCase(i.getNombre())){
                producto = i;
                break;
            }
        }
        return producto;
    }
    public void reducirStock(String name) {
        Producto producto = buscarProducto(name);
        if (producto != null && producto.getCantidad() > 0) {
            producto.setCantidad(producto.getCantidad() - 1);
            if (producto.getCantidad() < 2 && !productosAgotar.contains(producto)) {
                productosAgotar.add(producto);
            }
        }
    }
}
