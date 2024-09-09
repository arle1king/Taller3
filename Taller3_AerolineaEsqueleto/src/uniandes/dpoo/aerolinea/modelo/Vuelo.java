package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	
	private String fecha;
	private Ruta ruta;
	private Avion avion;
	private Collection<Tiquete> tiquetes;
	
	public Vuelo(Ruta ruta,String fecha,Avion avion) {
		 this.ruta = ruta;
	     this.fecha = fecha;
	     this.avion = avion;
	}
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException { // Este es un ejemplo, puede necesitar ajuste según la implementación
        
        // Verifica si hay suficiente espacio en el vuelo
        if (avion.getCapacidad()-tiquetes.size()<=0) {
            throw new VueloSobrevendidoException(this);
        }
        
        // Calcula el precio por tiquete
        int precioPorTiquete = CalculadoraTarifas.calcularTarifa(this, cliente);
        
        // Vende los tiquetes y los registra
        int valorTotal = 0;
        for (int i = 0; i < cantidad; i++) {
            // Genera un nuevo tiquete
            @SuppressWarnings("unused")
			Tiquete tiquete = GeneradorTiquetes.generarTiquete(this, cliente, precioPorTiquete);
            // Acumula el valor total
            valorTotal += precioPorTiquete;
        }
        
        return valorTotal;
    }

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}


	public Collection<Tiquete> getTiquetes() {
		return tiquetes;
	}


	public void setTiquetes(Collection<Tiquete> tiquetes) {
		this.tiquetes = tiquetes;
	}

	public int getEspacioDisponible() {
		// TODO Auto-generated method stub
		return avion.getCapacidad()-tiquetes.size();
	}

	public void agregarTiquete(Tiquete tiquete) {
		// TODO Auto-generated method stub
		tiquetes.add(tiquete);
		
	}
	

}
