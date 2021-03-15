/*Realizar un programa utilizando hilos
que muestre un reproductor de vocales y ejecute 
el audio correspondiente a cada vocal.*/
package hilo_vocal;

import java.awt.*;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author wilberto david
 */
public class Ejercicio_1 extends Thread{ // Heredamos del Thread que es el hilo
    JLabel etVocal; //declaramos variable JLabel
    String[] texto; //Declaramos variable tipo String
    Font[] estilos; //Declaramos variable tipo Font
    int n; //Tipo entero
    
    public Ejercicio_1(){
        texto = new String[5]; //Elementos que tendra el arreglo
        estilos = new Font [5]; //Estilo de la letras
        cargarTexto();
        cargarEstilos();
        n=0;
    }
    
    public void run(){
        while(true){
            if(n<=4){ // Comparar que el arreglo sea menor igual a 4
                etVocal.setText(texto[n]); 
                etVocal.setFont(estilos[n]);
                n++;
            }else{
                n=0;//para reiniciar el ciclo
            }
            try{
                sleep(4700); // 4 segundos para cambiar la letra
            }catch(Exception ex){
                //En caso de error
                Logger.getLogger(Ejercicio_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void recibeVocal (JLabel etVocal){
        this.etVocal=etVocal; // para que la etiqueta reciba las vocales
    }

    private void cargarTexto() {
        //cargar el metodo con las letras que representara
        texto [0] = "A";
        texto [1] = "E";
        texto [2] = "I";
        texto [3] = "O";
        texto [4] = "U";
    }

    private void cargarEstilos() {
        //el tipo de letra y numero
        estilos [0] = new Font("Tahoma", 1, 50);
        estilos [1] = new Font("Tahoma", 1, 50);
        estilos [2] = new Font("Tahoma", 1, 50);
        estilos [3] = new Font("Tahoma", 1, 50);
        estilos [4] = new Font("Tahoma", 1, 50);
    }
}
