
/**
 * Esta clase permite crear comidas e introducir sus elementos básicos como
 * su nombre y su número de calorías.
 * 
 * @author (Jorge Jaular Lasaga) 
 * @version (23/02/2018)
 */
public class Comida
{
    // Nombre de la comida.
    private String nombre;
    // Número de calorias de la comida en gramos.
    private int calorias;

    /**
     * Constructor de la clase Comida, crea un alimento en función de los 
     * parámetros.
     * @param nombre - indica el nombre de la comida.
     * @ calorias - indica el número de calorias de la comida.
     */
    public Comida(String nombre, int calorias)
    {
        // Inicialización de los atributos.
        this.nombre = nombre;
        this.calorias = calorias;
    }

    /**
     * Devuelve el nombre de la comida. 
     * @return nombre.
     */
    public String getNombreComida()
    {
        return nombre;
    }
    
    /**
     * Devuelve el número de calorias de la comida.
     * @return calorias.
     */
    public int getNumCalorias()
    {
        return calorias;
    }
}
