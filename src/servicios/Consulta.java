/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import vista.Vista;
/**
 *
 * @author NELSON
 */
public class Consulta {
    public Vista vista;
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    
    
    public Integer contarClientes(){
        int cantidad=0;
    String SQL2= "select count(Cedula) as cantidad from cliente ";
        try{
        Statement st = cn.createStatement();
        ResultSet rs=st.executeQuery(SQL2);
        
        while(rs.next()){
cantidad = Integer.parseInt(rs.getString("cantidad"));
        }

    }catch(Exception e){
      JOptionPane.showConfirmDialog(null, e);

      
    }
        return cantidad;
    }
    public Integer contarInstructores(){
        int cantidad=0;
    String SQL2= "select count(Codigo) as cantidad from instructor ";
        try{
        Statement st = cn.createStatement();
        ResultSet rs=st.executeQuery(SQL2);
        
        while(rs.next()){
cantidad = Integer.parseInt(rs.getString("cantidad"));
        }

    }catch(Exception e){
      JOptionPane.showConfirmDialog(null, e);

      
    }
        return cantidad;
    }
public Integer contarClases(){
    int cantidad=0;
    String SQL2= "select count(Codigo) as cantidad from clase ";
        try{
        Statement st = cn.createStatement();
        ResultSet rs=st.executeQuery(SQL2);
        
        while(rs.next()){
cantidad = Integer.parseInt(rs.getString("cantidad"));
        }

    }catch(Exception e){
      JOptionPane.showConfirmDialog(null, e);

      
    }
        return cantidad;
    }
}
