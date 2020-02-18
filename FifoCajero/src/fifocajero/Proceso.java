/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifocajero;

/**
 *
 * @author Jose Daniel 
 */
public class Proceso {
    private int nfacturas;
    private String nombre;
    
    public Proceso(int n, String nombre){
        this.nombre = nombre;
        this.nfacturas = n;       
    }

    public int getNfacturas() {
        return nfacturas;
    }

    public void setNfacturas(int nfacturas) {
        this.nfacturas = nfacturas;
    }                

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }        
    
}
