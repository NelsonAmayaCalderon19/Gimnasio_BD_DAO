/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasio;
import control.Controlador;
import servicios.Consulta;
import vista.*;
/**
 *
 * @author Claudia
 */
public class Gimnasio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Gimnasio g = new Gimnasio();
        Vista v = new Vista();
        Consulta cs = new Consulta();
        
        Controlador c = new Controlador(v,cs);
        
    }
    
}
