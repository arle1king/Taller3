package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {
	
	private String codigo;
	private int tarifa;
	private boolean usado;
	private Vuelo vuelo;
	private Cliente cliente;
	
	// Constructor de la clase
	public Tiquete(String codigo, Vuelo vuelo, Cliente cliente, int tarifa) {
        this.codigo = codigo;
        this.vuelo = vuelo;
        this.cliente = cliente;
        this.tarifa = tarifa;
        this.usado = false; // Inicialmente, el tiquete no está usado
    }

	// Método para marcar el tiquete como usado
    public void marcarComoUsado() {
        if (!usado) {
            this.usado = true;
        } else {
            System.out.println("El tiquete ya ha sido usado.");
        }
    }
    
    // Método para verificar si el tiquete ha sido usado
    public boolean isUsado() {
        return usado;
    }
    
    // Método para establecer si el tiquete ha sido usado
    public void setUsado(boolean usado) {
        this.usado = usado;
    }
    
    // Método para obtener la tarifa del tiquete
    public int getTarifa() {
        return tarifa;
    }
    
    // Método para establecer la tarifa del tiquete
    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }
    
    // Método para obtener el código del tiquete
    public String getCodigo() {
        return codigo;
    }
    
    // Método para establecer el código del tiquete
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    // Método para obtener el vuelo asociado al tiquete
    public Vuelo getVuelo() {
        return vuelo;
    }
    
    // Método para establecer el vuelo asociado al tiquete
    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
    
    // Método para obtener el cliente que compró el tiquete
    public Cliente getCliente() {
        return cliente;
    }
    
    // Método para establecer el cliente que compró el tiquete
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
