package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	private List<Tiquete>	tiquetesSinUsar;
	private List<Tiquete> tiquetesUsados;;
	
	
	public abstract boolean getTipoCliente();
	public abstract int getTamanoEmpresa();
    public abstract String getIdentificador();
    public void agregarTiquete(Tiquete tiquete) {
        if (tiquete != null) {
            tiquetesSinUsar.add(tiquete);
        }
    }
    public void usarTiquetes(Vuelo vuelo) {
        List<Tiquete> tiquetesAUsar = new ArrayList<>();
        
        for (Tiquete tiquete : tiquetesSinUsar) {
            if (tiquete.getVuelo().equals(vuelo)) {
                tiquete.marcarComoUsado();
                tiquetesAUsar.add(tiquete);
            }
        }
        tiquetesSinUsar.removeAll(tiquetesAUsar);
        tiquetesUsados.addAll(tiquetesAUsar);
    }
    public int calcularValorTotalTiquetes() {
    	int total=0;
    	for (Tiquete tiquete : tiquetesSinUsar) {
    		Vuelo vuelo=tiquete.getVuelo();
    		total+=CalculadoraTarifas.calcularTarifa(vuelo, this);
    	}
    	return total;
    }
    
    
	

}
