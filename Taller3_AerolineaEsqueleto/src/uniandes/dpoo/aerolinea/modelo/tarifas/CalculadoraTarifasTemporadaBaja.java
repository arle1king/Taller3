package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {

    private static final int COSTO_POR_KM_NATURAL = 600;
    private static final int COSTO_POR_KM_CORPORATIVO = 900;
    private static final double DESCUENTO_PEQ = 0.02;
    private static final double DESCUENTO_MEDIANAS = 0.1;
    private static final double DESCUENTO_GRANDES = 0.2;

   

    @SuppressWarnings("unlikely-arg-type")
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
        if ("CORPORATIVO".equals(cliente.getTipoCliente())) {
            return calcularDistanciaVuelo(vuelo.getRuta()) * COSTO_POR_KM_CORPORATIVO;
        } else {
            return calcularDistanciaVuelo(vuelo.getRuta()) * COSTO_POR_KM_NATURAL;
        }
    }

    @SuppressWarnings("unlikely-arg-type")
	protected double calcularPorcentajeDescuento(Cliente cliente) {
    	boolean tipoCliente = cliente.getTipoCliente();
		if ("CORPORATIVO".equals(tipoCliente)) {
    		if (cliente.getTamanoEmpresa()==1) {
	            return DESCUENTO_GRANDES;
	        } else if (cliente.getTamanoEmpresa()==2) {
	            return DESCUENTO_MEDIANAS;
	        } else if (cliente.getTamanoEmpresa()==3) {
	            return DESCUENTO_PEQ;
	        } else {
	            return 0;
        }
    	}
		return 0;
    }
}
