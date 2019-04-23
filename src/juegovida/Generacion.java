/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegovida;

import java.util.Random;

/**
 *
 * @author gabriel
 */
public class Generacion {

    // Una generación es un conjunto de celulas
    //Una matriz de NxN
    private Celula[][] matrizCelula;

    public Generacion(int numeroCelulasMatriz) {

        //Reservo espacio de memoria para las celulas
        matrizCelula = new Celula[numeroCelulasMatriz][numeroCelulasMatriz];

        //Para cada posición de la matriz creo una celula 
        //y la coloco en su posición
        for (int i = 0; i < numeroCelulasMatriz; i++) {
            for (int j = 0; j < numeroCelulasMatriz; j++) {
                Celula tmp = new Celula();
                this.ponerCelula(i, j, tmp);
            }
        }

    }

    public Celula[][] getMatrizCelula() {
        return matrizCelula;
    }

    public void setMatrizCelula(Celula[][] matrizCelula) {
        this.matrizCelula = matrizCelula;
    }

    // i y j deben ser maximo el numero que se cree la matriz sino dará error
    public Celula getCelula(int i, int j) {
        return matrizCelula[i][j];
    }

    //método que recibe los valores de una celula y las introduce en la matriz
    public void ponerCelula(int i, int j, Celula tmp) {
        matrizCelula[i][j] = tmp;
    }

    //Método que genera un número aleatorio entre 5 y 70 que posteriormente será utilizado para llenar la matriz de celulas
    public static int tamañoAleatorioMatriz() {
        Random aleo = new Random();
        int tamaño = aleo.nextInt(70 - 5 + 1) + 5;
        return tamaño;
    }

    //Método que devuelve un número aleatorio entre 0 y 1.
    public static int generarEstado() {
        Random aleo = new Random();
        int numero = aleo.nextInt(1 - 0 + 1) + 0;
        return numero;
    }

    // método estatico que genera una celula viva o muerta y la guarda en una matriz de celula la cual es devuelta para generar la matriz en la interfaz gráfica
    // para ello hace uso del método genearEstado() en el cual si el número generado es 0 la celula esta viva y si es 1 muerta. 
    public static Celula[][] generarCelulaAleatoria(int tamaño) {
        Celula[][] aux = new Celula[tamaño][tamaño];
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                aux[i][j] = Celula.generarCelula(generarEstado());

            }
        }

        return aux;
    }

    //método que copia el estado actual de la matriz de células y devuelve esta copia
    public Celula[][] copiarMatriz() {

        Celula[][] matrizCopia;
        matrizCopia = new Celula[this.matrizCelula.length][this.matrizCelula.length];
        for (int i = 0; i < this.matrizCelula.length; i++) {
            for (int j = 0; j < this.matrizCelula.length; j++) {
                matrizCopia[i][j] = this.matrizCelula[i][j];
            }
        }
        return matrizCopia;
    }

    
    // método que se encarga de la lógica central del juego 
    //Este método recibe la matriz de celulas copia que devuelve el método copiarMatriz y la recorre realizando las modificaciones 
    // pertinententes en base a la lógica del juego matando y recusitando celulas según las reglas del juego.
    // Una vez realizadas todas las modificaciones se devuelve la matriz copia que será la que se muestre en la siguiente generación.
    public static Celula[][] AnalizarSituacionCelula(Celula[][] aux) {

        for (int i = 0; i < aux.length; i++) {
            for (int j = 0; j < aux.length; j++) {
                
//                aux[i][j].isEstado() == true // ij célula analizada
//                aux[i][j-1].isEstado() == true // IZQUIERDA dela célula analizada 
//                aux[i][j+2].isEstado() == true //DERECHA dela célula analizada 
//                aux[i][j-1].isEstado() == true // ARRIBA dela célula analizada 
//                aux[i+1][j].isEstado() == true // ABAJO dela célula analizada 
                
                
                
                //si la celula esta muerta y tiene 3 vivas a su alrededor la celula nace (estado==true) en el siguiente turno
                if (aux[i][j].isEstado() == false && aux[i][j - 1].isEstado() == true && aux[i][j + 2].isEstado() == true && aux[i - 1][j].isEstado() == true
                        || aux[i][j].isEstado() == false && aux[i][j + 2].isEstado() == true && aux[i - 1][j].isEstado() == true && aux[i + 1][j].isEstado() == true
                        || aux[i][j].isEstado() == false && aux[i + 1][j].isEstado() == true && aux[i][j - 1].isEstado() == true && aux[i][j + 2].isEstado() == true) {

                    aux[i][j].resucitarCelula();
                }

                // si la célula esta viva con 2 ó 3 células vecinas vivas sigue viva.
                if (aux[i][j].isEstado() == true && aux[i][j - 1].isEstado() == true && aux[i][j + 2].isEstado() == true
                        || aux[i][j].isEstado() == true && aux[i][j - 1].isEstado() == true && aux[i - 1][j].isEstado() == true
                        || aux[i][j].isEstado() == true && aux[i][j - 1].isEstado() == true && aux[i + 1][j].isEstado() == true
                        || aux[i][j].isEstado() == true && aux[i - 1][j].isEstado() == true && aux[i + 1][j].isEstado() == true) {

                    aux[i][j].resucitarCelula();

                }
                
                if (aux[i][j].isEstado() == true && aux[i][j-1].isEstado() == true && aux[i][j+2].isEstado() == true && aux[i-1][j].isEstado() == true
                   || aux[i][j].isEstado() == true && aux[i][j+2].isEstado() == true && aux[i-1][j].isEstado() == true && aux[i+1][j].isEstado() == true
                   ||aux[i][j].isEstado() == true && aux[i-1][j].isEstado() == true && aux[i+1][j].isEstado() == true && aux[i][j-1].isEstado() == true 
                   ||aux[i][j].isEstado() == true  && aux[i-1][j].isEstado() == true && aux[i+1][j].isEstado() == true && aux[i][j-1].isEstado() == true
                   ||aux[i][j].isEstado() == true && aux[i+1][j].isEstado() == true && aux[i][j-1].isEstado() == true && aux[i][j+2].isEstado() == true  ) {
                    
                }
                
                // Una célula viva que tenga 0 o 1 células vecinas vivas muere por “soledad“.
                  if (aux[i][j].isEstado() == true &&  aux[i][j-1].isEstado() == false && aux[i][j+2].isEstado() == false &&   aux[i][j-1].isEstado() == false &&  aux[i+1][j].isEstado() == true
                     || aux[i][j].isEstado() == true &&  aux[i][j+2].isEstado() == false && aux[i][j-1].isEstado() == false &&  aux[i+1][j].isEstado() == false && aux[i][j-1].isEstado() == true
                     || aux[i][j].isEstado() == true && aux[i+1][j].isEstado() == false && aux[i][j-1].isEstado() == false && aux[i][j+2].isEstado() == false && aux[i][j-1].isEstado() == true
                     || aux[i][j].isEstado() == true && aux[i][j-1].isEstado() == false && aux[i][j-1].isEstado() == false && aux[i+1][j].isEstado() == false &&  aux[i][j+2].isEstado() == true  ) {
                      
                      aux[i][j].matarCelula();

                }
                  //Una célula que tenga más de 3 vecinas vivas o permanece muerta o muere por "sobrepoblación".
                  // si esta viva muere
                  if (aux[i][j].isEstado() == true && aux[i][j-1].isEstado() == true &&   aux[i][j+2].isEstado() == true &&  aux[i][j-1].isEstado() == true
                     || aux[i][j].isEstado() == true && aux[i][j-1].isEstado() == true &&  aux[i][j-1].isEstado() == true && aux[i+1][j].isEstado() == true
                     ||aux[i][j].isEstado() == true && aux[i][j-1].isEstado() == true && aux[i][j+2].isEstado() == true && aux[i+1][j].isEstado() == true  ) {
                    
                      aux[i][j].matarCelula(); //matamos la celula
                      // si la célula esta muerta entonces revive
                }else if (aux[i][j].isEstado() == false && aux[i][j-1].isEstado() == true &&   aux[i][j+2].isEstado() == true &&  aux[i][j-1].isEstado() == true
                     || aux[i][j].isEstado() == false && aux[i][j-1].isEstado() == true &&  aux[i][j-1].isEstado() == true && aux[i+1][j].isEstado() == true
                     ||aux[i][j].isEstado() == false && aux[i][j-1].isEstado() == true && aux[i][j+2].isEstado() == true && aux[i+1][j].isEstado() == true ) {
                    
                    aux[i][j].resucitarCelula();// resucitamos la célula
                }
                  

            }
        }
        
        return aux;
    }

    
}
