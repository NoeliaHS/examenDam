package exam;
/**
 * Importem les funcions Scanner i Random per a la seva utilització. 
 * 
 */
import java.util.Scanner;
import java.util.Random;

/**
 * Classe principal del programa. 
 * @author Gustau
 * @version 1.0
 * 
 */
public class Main {

/**
 * Definim les constants. 
 * String Vector on s'indica els valors "hola"/"programació"/"casa". 
 * Int index variable 
 * String P variable que espera una lletra.
 */
    static protected String paraules[] = {"hola","programaciÃ³","casa"};
    static protected int index;
    static protected String p;

    /**
     * S'inicia el programa.
	 * Ens torna un missatge per pantalla que ens indicia l'inici del joc. 
	 * 
     */
    public static void main(String[] args) {
        System.out.println("ComenÃ§a el joc!");
        
        /**
         * Indiquem el nombre de lletres que tindrà el joc. 
         */
        Random rand = new Random();
        index = rand.nextInt(3);
        for (int i=0; i<paraules[index].length(); i++) {
            p += "_";
        }
        /**
         * Ens mostra per pantalla el valor de P. 
         */
        System.out.println(p);
        
        /**
         * Ens llegeix la lletra que li indiquem. 
         */
        Scanner reader = new Scanner(System.in);

        /**
         * Iniciem el contadors d'erros a 0;
         */
        int num_errors = 0;
        
        /**
         * Podrem jugar i introduir lletres mentre no hagim acertat les lletres ni haguem arribat 
         * al màxim d'intents. 
         */
        while (!p.equals(paraules[index]) && num_errors < 5) {
            if (!nova_lletra(reader.next().charAt(0))) {
                num_errors++;
            }
            System.out.println(p);
        }
   }
    /**
     * Funció que rep la lletra nova en cada intent, i la compara amb els valors del vector. 
     * Ens indicarà null o no null, segons la lletra es trobi o no.  
     * 
     * @param nova char Rep per paràmetre la lletra que volem comprovar que es trobi al penjat. 
     * @return boolean Indica si es la lletra es troba o no entre les seleccionades aleatoriament al vector. 
     */
    static public boolean nova_lletra(char nova) {
        boolean trobada = false;
        String paraula_old = p;
        p = "";
        for (int i=0; i<paraules[index].length(); i++) {
            if (paraules[index].charAt(i) == nova) {
                p += paraules[index].charAt(i);
                trobada = true;
            }
            else {
                p += paraula_old.charAt(i);
            }
        }
        return trobada;
    }

}


