package uniandes.dpoo.aerolinea.modelo.cliente;

import org.json.JSONObject;

/**
 * Esta clase se usa para representar a los clientes de la aerolínea que son empresas
 */
public class ClienteCorporativo extends Cliente
{
    // TODO completar
	private String nombreEmpresa;
	private int tamanoEmpresa;
	public static final String CORPORATIVO = "Corporativo";
	public static final int GRANDE = 1;
	public static final int MEDIANA = 2;
	public static final int PEQUEÑA = 3;

    /**
     * Constructor de ClienteCorporativo
     * @param nombreEmpresa Nombre de la empresa
     * @param tamanoEmpresa Tamaño de la empresa
     */
    public ClienteCorporativo(String nombreEmpresa, int tamanoEmpresa) {
        super(); // Llama al constructor de Cliente si tiene atributos heredados
        this.nombreEmpresa = nombreEmpresa;
        this.tamanoEmpresa = tamanoEmpresa;
    }

    /**
     * Crea un nuevo objeto ClienteCorporativo a partir de un objeto JSON.
     * 
     * El objeto JSON debe tener dos atributos: nombreEmpresa (una cadena) y tamanoEmpresa (un número).
     * @param cliente El objeto JSON que contiene la información.
     * @return El nuevo objeto inicializado con la información.
     */
    public static ClienteCorporativo cargarDesdeJSON(JSONObject cliente) {
        String nombreEmpresa = cliente.getString("nombreEmpresa");
        int tam = cliente.getInt("tamanoEmpresa");
        return new ClienteCorporativo(nombreEmpresa, tam);
    }

    /**
     * Salva este objeto de tipo ClienteCorporativo dentro de un objeto JSONObject para que ese objeto se almacene en un archivo.
     * @return El objeto JSON con toda la información del cliente corporativo.
     */
    public JSONObject salvarEnJSON() {
        JSONObject jobject = new JSONObject();
        jobject.put("nombreEmpresa", this.nombreEmpresa);
        jobject.put("tamanoEmpresa", this.tamanoEmpresa);
        jobject.put("tipo", CORPORATIVO);
        return jobject;
    }

    // Getters y setters para nombreEmpresa y tamanoEmpresa (si son necesarios)
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getTamanoEmpresa() {
        return tamanoEmpresa;
    }

    public void setTamanoEmpresa(int tamanoEmpresa) {
        this.tamanoEmpresa = tamanoEmpresa;
    }
}
