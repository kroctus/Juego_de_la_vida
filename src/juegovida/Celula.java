/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegovida;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author gabriel
 */
public class Celula extends JButton {
    
    private boolean estado;
    
    
    public Celula(){
        super();
        this.estado=false;
        this.setBackground(Color.black);//Ponemos el color del botón negro
    }

    public boolean isEstado() {
        return estado;
    }

    public void matarCelula(){
        this.estado=false;
        this.setBackground(Color.black);//Ponemos el color del botón negro
    }
    
    public void resucitarCelula(){
        this.estado=true;
        this.setBackground(Color.white);
    }
    
    
    
}
