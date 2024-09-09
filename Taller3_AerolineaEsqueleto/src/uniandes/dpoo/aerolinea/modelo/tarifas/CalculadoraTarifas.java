package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {

	protected static final double IMPUESTO = 0.28;

    // Método abstracto para calcular la tarifa final
    public static int calcularTarifa(Vuelo vuelo, Cliente cliente) {
        int costoBase = calcularCostoBase(vuelo, cliente);
        double descuento = calcularPorcentajeDescuento(cliente);
        int costoDes = (int)(costoBase * ( descuento));
        int costofin = calcularValorImpuestos(costoDes);
        return costofin;
	}

    // Método abstracto para calcular el costo base del vuelo
    protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);

    // Método abstracto para calcular el porcentaje de descuento del cliente
    protected abstract double calcularPorcentajeDescuento(Cliente cliente);

    // Método para calcular la distancia del vuelo
    protected int calcularDistanciaVuelo(Ruta ruta) {
        // Implementación simulada (podrías cambiar esto según la lógica de negocio)
        return ruta.getDistancia();
    }

    // Método para calcular el valor de los impuestos sobre el costo base
    protected int calcularValorImpuestos(int costoBase) {
        return (int) (costoBase * IMPUESTO);
    }
    
}
