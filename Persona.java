import java.util.ArrayList;
/**
 * Esta clase simula a una persona y la alimentación que tiene. Podremos hacerle
 * preguntas y estipular sus características básicas como altura, peso, edad
 * o género.
 * 
 * @author (Jorge Jaular Lasaga) 
 * @version (23/02/2018)
 */
public class Persona
{
    // Nombre de la persona.
    private String nombre;
    // Género de la persona. Devuelve true si es hombre y false si es mujer.
    private boolean genero;
    // Peso de la persona en kilogramos.
    private int peso;
    // Altura de la persona en centímetros.
    private int altura;
    // Edad de la persona indicada en años.
    private int edad;
    // Comida que la persona puede comer.
    private Comida comida;
    // Total de calorias acumuladas por la persona.
    private int totalCalorias;
    /**
     * Constructor de la clase Persona. Crea una persona con las características
     * que se indican por parámetro.
     * @param nombre - nombre de la persona.
     * @param genero - genero de la persona.
     * @param peso - peso de la persona (en kg).
     * @param altura - altura de la persona (en cm).
     * @param edad - edad de la persona (en años).
     */
    public Persona(String nombre, boolean genero, int peso, int altura, int edad)
    {
        // Inicialización de los atributos.
        this.nombre = nombre;
        this.genero = genero;
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
        comida = null;
        totalCalorias = 0;
    }
    
    public int comer(Comida comida)
    {
        int limiteComida = 0;
        int aDevolver = comida.getNumCalorias();
        if (genero) {
            limiteComida = 10*peso + 6*altura + 5*edad + 5;
        }
        else {
            limiteComida = 10*peso + 6*altura + 5*edad - 161;
        }
        if (getCaloriasIngeridas() > limiteComida) {
            aDevolver = -1;
        }
        else {
            totalCalorias += comida.getNumCalorias();
        }        
        return aDevolver;
    }
    
    public int getCaloriasIngeridas()
    { 
        return totalCalorias;
    }
}
