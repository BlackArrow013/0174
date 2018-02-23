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
    // El número de calorías límite que una persona puede ingerir según su metabolismo basal.
    private int limiteComida;
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
        comida = new Comida("", 0);
        totalCalorias = 0;
        if (genero) {
            limiteComida = 10*peso + 6*altura + 5*edad + 5;
        }
        else {
            limiteComida = 10*peso + 6*altura + 5*edad - 161;
        }
    }
    
    /**
     * La persona se nutre comiendo. Come una comida creada en la clase Comida. Las calorías de las comidas son acumulativas, de modo que
     * si come más de lo que su metabolismo basal le permite, no seguirá comiendo y se devolverá -1. Si la persona come la comida, se
     * mostrará el número de calorías de la misma.
     * @param aDevolver - devuelve las calorías de la comida ingeridas, o -1 si no come nada.
     */
    public int comer(Comida nombreComida)
    {
        int aDevolver = nombreComida.getNumCalorias();
        if (getCaloriasIngeridas() > limiteComida) {
            aDevolver = -1;
        }
        else {
            totalCalorias += nombreComida.getNumCalorias();
            if (nombreComida.getNumCalorias() >= comida.getNumCalorias()) {
                comida = nombreComida;
            }
        }        
        return aDevolver;
    }

    /**
     * Devuelve el total de calorías ingeridas por la persona.
     */
    public int getCaloriasIngeridas()
    { 
        return totalCalorias;
    }

    /**
     * La persona responde a la pregunta planteada en el parámetro con una respuesta simple, a saber, sí, no o con la misma pregunta
     * en mayúsculas, y, además, la imprime por pantalla.
     * @param pregunta - Se escribe la pregunta a plantear.
     */
    public String contestar(String pregunta)
    {
        String respuesta = "";
        pregunta = pregunta.toLowerCase();
        if (pregunta.contains(nombre.toLowerCase()) || getCaloriasIngeridas() > limiteComida) {
            respuesta = pregunta.toUpperCase();
        }
        else {
            if (pregunta.length() % 3 == 0) {
                respuesta = "SI";
            }
            else {
                respuesta = "NO";
            }
        }
        System.out.println(respuesta);
        return respuesta;
    }
    
    public String getAlimentoMasCaloricoConsumido()
    {
        String alimentoMasCalorico = null;
        if (comida.getNombreComida() != "") {
            alimentoMasCalorico = comida.getNombreComida();
        }
        else {
            System.out.println("Aún no he comido.");
        }
        System.out.println(alimentoMasCalorico);
        return alimentoMasCalorico;
    }
}
