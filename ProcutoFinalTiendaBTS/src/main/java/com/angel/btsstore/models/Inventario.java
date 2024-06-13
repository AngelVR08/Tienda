package com.angel.btsstore.models;

import java.util.ArrayList;

import java.sql.*;

public class Inventario {
    String url = "jdbc:mysql://localhost:3306/tienda?serverTimezone=UTC";
    String username = "root";
    String pass = "12345678";
    ArrayList <Producto> productos = new ArrayList<>();
    ArrayList <Producto> productosAgotar = new ArrayList<>();
    public ArrayList<Producto> getProductos() {
        return productos;
    }
    public ArrayList<Producto> getProductosAgotar() {
        return productosAgotar;
    }
    public Boolean elimProducto(String nombre) {
        boolean eliminado = false;  // Inicializa eliminado antes del bucle

        for (int i = 0; i < productos.size(); i++) {
            if (nombre.equalsIgnoreCase(productos.get(i).getNombre())) {
                productos.remove(i);
                eliminado = true;
                break;  // Añadir break para salir del bucle una vez que se haya eliminado el producto
            }
        }
        //eliminar en sql
        String sql = "DELETE FROM products WHERE nombre = ?";
        // HACE LA CONEXION CON LA BASE DE DATOS
        try (Connection connection = DriverManager.getConnection(url, username, pass);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, nombre);
            int rowsDeleted = preparedStatement.executeUpdate();
            // Verifica si el producto fue eliminado del ArrayList y de la base de datos
            return eliminado && rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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
    //agregar en sql
    public boolean agregarProducto(Producto product){
        productos.add(product);
        //SE HACE LA SENTENCIA
        String sql = "INSERT INTO products (nombre, precio, fechaSalida, stock) VALUES (?, ?, ?, ?)";
        //HACE LA CONECCION
        try (Connection connection = DriverManager.getConnection(url, username, pass);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            //SETEA LOS DATOS PARA PODER MANDARLOS A LA BASE DE DATOS
            preparedStatement.setString(1,product.getNombre());
            preparedStatement.setDouble(2,product.getPrecio());
            preparedStatement.setString(3,product.getFechaSalida());
            preparedStatement.setInt(4,product.getCantidad());

            //EXECUTA LA SENTENCIA
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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
