/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifocajero;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Daniel
 */
public class Cajero {
    
    private int ProcesosCompletados;
    private int cantidad_de_procesos;
    private Proceso Po;
    private JFCajero JMod;
    DefaultTableModel modelo;
    JTable tabla;

    
    
    
    public Cajero(){      
       
        
    }
    
    public void vaciarCola(ColaP Cola,JFCajero F)throws InterruptedException{
                
        this.cantidad_de_procesos = Cola.getNProcesos();
        
        
        
        if (this.cantidad_de_procesos == 0){
            //Si no hay procesos en la cola, lanza una ventana
            JOptionPane.showMessageDialog(null, "No hay procesos para completar");
        }

        else{                
            //Si hay procesos en la cola ejecuta la lógica para atenderlos
            JOptionPane.showMessageDialog(null, "Hay "+(Cola.getNProcesos() - 1)+" procesos en espera por ser atendidos.");
            do{
                
                int i = 0;
                //Si queda solo un proceso en la cola, pero ya se atendieron todas las facturas, se rompe el proceso.

                System.out.println("Procesos actuales: "+Cola.getNProcesos());
                System.out.println("Nombre del proceso: "+Cola.get(i).getNombre()+
                        ", facturas pendientes: "+Cola.get(i).getNfacturas());
                //Selecciona el Primer procesos en la cola y lo atiende
                Po = this.atenderProceso(Cola.get(i));
                if(Cola.getNProcesos() == 1 && Cola.get(0).getNfacturas() == 0){
                    System.out.println("entrando al if de salida de while");
                    break;
                }                
                if (Po.getNfacturas()== 0){
                    System.out.println(Po.getNombre()+ " atendido y finalizado");                    
                    F.modelo2.removeRow(0);
                    JOptionPane.showMessageDialog(null, Po.getNombre()+" finalizado.");
                    Cola.pop();                    
                    this.cantidad_de_procesos = cantidad_de_procesos - 1;                                                            
                }
                 
                else{                    
                    System.out.println("Entrando en el segundo else");
                    if (Cola.getNProcesos() == 1){                        
                        System.out.println(Po.getNombre()+" atendido y reinsertado.");
                        this.atenderProceso(Cola.get(i));                        
                    }
                    else{
                        F.modelo2.moveRow(0, 0, Cola.getNProcesos() -1);
                        Cola.pop();
                        Cola.push(Po);
                        System.out.println(Po.getNombre()+" atendido y reinsertado.");
                        this.vaciarCola(Cola,F);
                        
                    }
                    
                    
                }
                
                
                
                
            //
            }while (!Cola.isEmpty());
            System.out.println("Saliendo del while");
        }
    }
    
    public Proceso atenderProceso(Proceso P)throws InterruptedException {
        
        System.out.println("Atendiendo proceso: "+P.getNombre());
        if (P.getNfacturas() == 3){
            P.setNfacturas(0);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("-----Factura atendida");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("-----Factura atendida");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("-----Factura atendida");
            return P;            
         
        }
        if (P.getNfacturas() == 2){
            P.setNfacturas(0);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("-----Factura atendida");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("-----Factura atendida");
            return P;
            
        }
        if (P.getNfacturas() == 1){
            P.setNfacturas(0);            
            TimeUnit.SECONDS.sleep(1);   
            System.out.println("-----Factura atendida");
            return P;            
        }
        if (P.getNfacturas() <= 0){
            return P;
        }
        else{
            
            
            TimeUnit.SECONDS.sleep(1);
            System.out.println("-----Factura atendida");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("-----Factura atendida");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("-----Factura atendida");
            
            P.setNfacturas(P.getNfacturas() - 3);
            
            System.out.println("Facturas restantes del "+ P.getNombre()+": "+P.getNfacturas());
            
            return P;
        }
        
    }
    
}
