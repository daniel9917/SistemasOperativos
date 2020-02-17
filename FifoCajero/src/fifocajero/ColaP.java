/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifocajero;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Daniel
 */
public class ColaP {
    
    private ArrayList<Proceso> Procesos;
    
    public ColaP(){
        Procesos = new ArrayList();        
    }
    
    public void push(Proceso P){
        this.Procesos.add(P);
        JOptionPane.showMessageDialog(null, "Proceso añadido correctamente.");
        System.out.println("Procesos actuales: "+this.Procesos.size());
    }
    
    public Proceso pop(){
        this.Procesos.remove(0);
        return this.get(0);
        
    }
    
    public Proceso get(int index){
        
        return this.Procesos.get(index);        
        
    }
    
    public int getNProcesos(){
        return this.Procesos.size();
    }
    
    //Metodo que verifica si la cola de procesos está vacía
    public boolean isEmpty(){
        return this.Procesos.isEmpty();               
    }
    
    
    
    
    
}
