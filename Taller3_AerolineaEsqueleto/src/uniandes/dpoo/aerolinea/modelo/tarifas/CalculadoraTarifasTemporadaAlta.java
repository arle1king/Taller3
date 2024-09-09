package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {

    private static final int COSTO_POR_KM = 1000;

    @Override
    protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
        return calcularDistanciaVuelo(vuelo.getRuta()) * COSTO_POR_KM;
    }

    @Override
    protected double calcularPorcentajeDescuento(Cliente cliente) {
        // En temporada alta, podrías definir descuentos diferentes o ningún descuento
        return 0;
    }
}
