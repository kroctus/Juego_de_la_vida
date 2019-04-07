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
   public static int generarEstado(){
        Random aleo = new Random();
        int numero= aleo.nextInt(1-0+1)+0;
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


}
