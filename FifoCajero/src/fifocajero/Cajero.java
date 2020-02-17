/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifocajero;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Jose Daniel
 */
public class Cajero {
    
    private int ProcesosCompletados;
    private int cantidad_de_procesos;
    
    
    
    
    public Cajero(){   
        
        
    }
    
    public void vaciarCola(ColaP Cola)throws InterruptedException{
        this.cantidad_de_procesos = Cola.getNProcesos();
        while (this.cantidad_de_procesos != 0){
            if( atenderProceso( Cola.get(0))){
                Cola.pop();
                
            }
            
        }
    }
    
    public boolean atenderProceso(Proceso P)throws InterruptedException {
        if (P.getNfacturas() == 3){
            P.setNfacturas(0);
            TimeUnit.SECONDS.sleep(15);            
            return true;            
         
        }
        if (P.getNfacturas() == 2){
            P.setNfacturas(0);
            TimeUnit.SECONDS.sleep(10);   
            return true;
            
        }
        if (P.getNfacturas() == 1){
            P.setNfacturas(0);
            TimeUnit.SECONDS.sleep(5);   
            return true;            
        }
        else{
            P.setNfacturas(P.getNfacturas() - 3);
            return false;
        }
        
    }
    
}
