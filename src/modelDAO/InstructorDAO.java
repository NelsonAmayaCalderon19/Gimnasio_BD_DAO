/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;



import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelVO.ClaseVO;
import modelVO.InstructorVO;

/**
 *
 * @author NELSON
 */
public class InstructorDAO {
   private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
    private String sSQL2="";
    public Integer totalregistros;
    
    
    public boolean insertar(InstructorVO dts){
    
        sSQL ="INSERT INTO INSTRUCTOR (Codigo,Nombres,Apellidos,Telefono,Especialidad,Jornada,Horario)"+ 
                "VALUES (?,?,?,?,?,?,?)";
        
      try{ 
          PreparedStatement pst = cn.prepareStatement(sSQL);
          pst.setString(1, dts.getCodigo());
          pst.setString(2, dts.getNombres());
          pst.setString(3, dts.getApellidos());
          pst.setString(4, dts.getTelefono());
          pst.setString(5, dts.getEspecialidad());
          pst.setString(6, dts.getJornada());
          pst.setString(7, dts.getHorario());
          
          
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
    public boolean buscar(InstructorVO dts,String buscar){
     int cont=0;
//    DefaultTableModel modelo;
//    String [] titulos = {"ID","Número","Piso","Descripción","Caracteristicas","Precio","Estado","Tipo Habitación"};
//    String [] registro = new String[8];
//    totalregistros=0;
//    modelo = new DefaultTableModel(null,titulos);
   
    sSQL = "SELECT * FROM INSTRUCTOR WHERE Codigo LIKE "+ buscar +" ";
    try{
        Statement st = cn.createStatement();
        ResultSet rs=st.executeQuery(sSQL);
        
        while(rs.next()){
            dts.setNombres(rs.getString("Nombres"));
            dts.setApellidos(rs.getString("Apellidos"));
            dts.setTelefono(rs.getString("Telefono"));
            dts.setEspecialidad(rs.getString("Especialidad"));
            dts.setJornada(rs.getString("Jornada"));
            dts.setHorario(rs.getString("Horario"));
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
    public boolean actualizar(InstructorVO dts){
    sSQL ="UPDATE INSTRUCTOR SET Telefono=?,Especialidad=?,Jornada=?,Horario=?" +
            " WHERE Codigo=?";
    
    
    try{
        PreparedStatement pst = cn.prepareStatement(sSQL);
          
          
          pst.setString(1, dts.getTelefono());
          pst.setString(2, dts.getEspecialidad());
          pst.setString(3, dts.getJornada());
          pst.setString(4, dts.getHorario());
          pst.setString(5, dts.getCodigo());
          
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
    public boolean eliminar(InstructorVO dts){
    sSQL ="DELETE FROM INSTRUCTOR WHERE Codigo=?";
    try{
        PreparedStatement pst = cn.prepareStatement(sSQL);
          
          pst.setString(1, dts.getCodigo());
          
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
     public boolean eliminar2(InstructorVO dts){
    sSQL ="DELETE FROM CLASES  WHERE Instructor=?";
    try{
        PreparedStatement pst = cn.prepareStatement(sSQL);
          
          pst.setString(1, dts.getNombres());
          
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
