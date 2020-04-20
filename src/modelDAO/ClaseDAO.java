/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import conexion.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import modelVO.ClaseVO;
import modelVO.ClienteVO;

/**
 *
 * @author NELSON
 */
public class ClaseDAO {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
    private String sSQL2="";
    public Integer totalregistros;
    
     public boolean insertar(ClaseVO dts){
    
        sSQL ="INSERT INTO CLASE (Codigo,Clase,Horario,Instructor)"+ 
                "VALUES (?,?,?,?)";
        
      try{ 
          PreparedStatement pst = cn.prepareStatement(sSQL);
          pst.setString(1, dts.getCodigo());
          pst.setString(2, dts.getTipo());
          pst.setString(3, dts.getHorario());
          pst.setString(4, dts.getInstructor());         
          
          int n=pst.executeUpdate();
          if(n!=0){
              return true;
          }else{
              return false;
          }
    }catch(Exception e){
        JOptionPane.showConfirmDialog(null, e.getMessage());
        return false;
    }
}
     
     public boolean buscar(ClaseVO dts,String buscar){
     int cont=0;

   
    sSQL = "SELECT * FROM CLASE WHERE Codigo LIKE '"+ buscar +"' ";
    try{
        Statement st = cn.createStatement();
        ResultSet rs=st.executeQuery(sSQL);
        
        while(rs.next()){
            dts.setTipo(rs.getString("Clase"));
            dts.setHorario(rs.getString("Horario"));
            dts.setInstructor(rs.getString("Instructor"));
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
    public boolean actualizar(ClaseVO dts){
    sSQL ="UPDATE CLASE SET Clase=?,Horario=?,Instructor=?" +
            " WHERE Codigo=?";
    
    
    try{
        PreparedStatement pst = cn.prepareStatement(sSQL);
          
          
          pst.setString(1, dts.getTipo());
          pst.setString(2, dts.getHorario());
          pst.setString(3, dts.getInstructor());
          pst.setString(4, dts.getCodigo());
          
          int n=pst.executeUpdate();
          if(n!=0){
              return true;
          }else{
              return false;
          }
    }catch(Exception e){
        JOptionPane.showConfirmDialog(null, e.getMessage());
        return false;
    }
} 
    
}
