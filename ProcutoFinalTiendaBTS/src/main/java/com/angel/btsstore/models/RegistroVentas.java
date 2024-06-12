package com.angel.btsstore.models;

import java.util.ArrayList;

public class RegistroVentas {
    ArrayList<Ticket> tickets = new ArrayList<>();
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
    public void agregarTicket(Ticket ticket){
        tickets.add(ticket);
    }
    public String imprimirTicket(Ticket ticket) {
        StringBuilder ticketInfo = new StringBuilder();
        ticketInfo.append("Título: Ticket de Venta\n");
        ticketInfo.append("Productos Vendidos:\n");
        for (Producto producto : ticket.getProductosVendidos()) {
            ticketInfo.append("- ").append(producto.getNombre()).append(" - Precio: $").append(producto.getPrecio()).append("\n");
        }
        ticketInfo.append("Total: $").append(ticket.getTotal()).append("\n");
        return ticketInfo.toString();
    }
}
