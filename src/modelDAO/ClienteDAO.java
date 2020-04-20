/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelVO.ClienteVO;

/**
 *
 * @author NELSON
 */
public class ClienteDAO {
     private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
    private String sSQL2="";
    public Integer totalregistros;
    
    
    public boolean insertar(ClienteVO dts){
    
        sSQL ="INSERT INTO CLIENTE (Cedula,Nombre,Apellidos,Direccion,Telefono,Fecha_Ingreso)"+ 
                "VALUES (?,?,?,?,?,?)";
        
      try{ 
          PreparedStatement pst = cn.prepareStatement(sSQL);
          pst.setString(1, dts.getCedula());
          pst.setString(2, dts.getNombre());
          pst.setString(3, dts.getApellidos());
          pst.setString(4, dts.getDireccion());
          pst.setString(5, dts.getTelefono());
          pst.setDate(6, (Date) dts.getFecha_Ingreso());
          
          
          
          int n=pst.executeUpdate();
          if(n!=0){
              return true;
          }else{
              return false;
          }
    }catch(Exception e){
        JOptionPane.showConfirmDialog(null, e);
        return false;
    }
}
    public boolean buscar(ClienteVO dts,String buscar){
     int cont=0;   
    sSQL = "SELECT * FROM CLIENTE WHERE Cedula LIKE "+ buscar +" ";
    try{
        Statement st = cn.createStatement();
        ResultSet rs=st.executeQuery(sSQL);
        
        while(rs.next()){
            dts.setNombre(rs.getString("Nombre"));
            dts.setApellidos(rs.getString("Apellidos"));
            dts.setDireccion(rs.getString("Direccion"));
            dts.setTelefono(rs.getString("Telefono"));
            dts.setFecha_Ingreso(rs.getDate("Fecha_Ingreso"));
            
            cont++;
        }
           
          if(cont!=0){
              cont=0;
              return true;              
          }else{
              cont=0;
              return false;           
          }
        
        
    }catch(Exception e){
      JOptionPane.showConfirmDialog(null, e);
      cont=0;
       return false;      
    }
}
    public boolean actualizar(ClienteVO dts){
    sSQL ="UPDATE CLIENTE SET Direccion=?,Telefono=?" +
            " WHERE Cedula=?";
    
    
    try{
        PreparedStatement pst = cn.prepareStatement(sSQL);
          
          pst.setString(1, dts.getDireccion());
          pst.setString(2, dts.getTelefono());
          pst.setString(3, dts.getCedula());
          
          
          int n=pst.executeUpdate();
          if(n!=0){
              return true;
          }else{
              return false;
          }
    }catch(Exception e){
        JOptionPane.showConfirmDialog(null, e);
        return false;
    }
}
    public boolean eliminar(ClienteVO dts){
    sSQL ="DELETE FROM CLIENTE WHERE Cedula=?";
    try{
        PreparedStatement pst = cn.prepareStatement(sSQL);
          
          pst.setString(1, dts.getCedula());
          
          int n=pst.executeUpdate();
          if(n!=0){
              return true;
          }else{
              return false;
          }
    }catch(Exception e){
        JOptionPane.showConfirmDialog(null, e);
        return false;
    }
}
}
