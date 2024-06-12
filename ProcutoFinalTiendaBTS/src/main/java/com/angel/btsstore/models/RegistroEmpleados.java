package com.angel.btsstore.models;

import java.util.ArrayList;
import java.util.Iterator;

public class RegistroEmpleados {
    ArrayList<Empleado> empleados = new ArrayList<>();

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public boolean agregarEmpleado(Empleado empleado){
        return empleados.add(empleado);
    }
    public boolean eliminarEmpleadoPorNombre(String nombre) {
        Iterator<Empleado> iterator = empleados.iterator();
        while (iterator.hasNext()) {
            Empleado empleado = iterator.next();
            if (empleado.getNombre().equalsIgnoreCase(nombre)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
