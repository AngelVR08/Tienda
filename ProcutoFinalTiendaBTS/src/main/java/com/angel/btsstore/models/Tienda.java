package com.angel.btsstore.models;


public class Tienda {
    Inventario inventario = new Inventario();
    Venta venta = new Venta();
    RegistroVentas ventas = new RegistroVentas();
    RegistroEmpleados empleados = new RegistroEmpleados();

    public RegistroEmpleados getEmpleados() {
        return empleados;
    }

    public RegistroVentas getVentas() {
        return ventas;
    }

    public Inventario getInventario() {
        return inventario;
    }
    public Venta getVenta() {
        return venta;
    }
}
