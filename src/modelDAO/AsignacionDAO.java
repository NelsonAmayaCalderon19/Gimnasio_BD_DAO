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
import javax.swing.JOptionPane;
import modelVO.AsignacionVO;
import modelVO.ClienteVO;

/**
 *
 * @author NELSON
 */
public class AsignacionDAO {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
    
public boolean insertar(AsignacionVO dts){
    
        sSQL ="INSERT INTO ASIGNACION (cliente,clase,fecha_inicio,fecha_fin)"+ 
                "VALUES (?,?,?,?)";
        
      try{ 
          PreparedStatement pst = cn.prepareStatement(sSQL);
          pst.setString(1, dts.getCliente());
          pst.setString(2, dts.getClase());
          pst.setDate(3, (Date) dts.getFecha_inicio());
          pst.setDate(4, (Date) dts.getFecha_fin());
          
          
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
