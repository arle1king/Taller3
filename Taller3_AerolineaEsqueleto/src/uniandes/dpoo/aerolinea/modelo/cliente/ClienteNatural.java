package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural extends Cliente {
	public static final String NATURAL = "Natural";  
	private String nombre;

	public ClienteNatural(String nombre, String identificacion) {
		this.nombre = nombre;
	} 
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipoCliente() {
        return NATURAL;
    }

	@Override
	public int getTamanoEmpresa() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getIdentificador() {
		// TODO Auto-generated method stub
		return null;
	}
}
	
