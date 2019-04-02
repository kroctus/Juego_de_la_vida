/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegovida;

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

    public Celula getCelula( int i, int j ){
        return matrizCelula[i][j];
    }
    
    public void ponerCelula(int i, int j, Celula tmp) {
        matrizCelula[i][j] = tmp;
    }

}
