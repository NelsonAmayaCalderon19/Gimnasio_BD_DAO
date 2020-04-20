/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import conexion.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;
import java.util.Calendar;
import javax.swing.JOptionPane;
import modelDAO.*;
import modelVO.*;
import servicios.Consulta;
import vista.Vista;

/**
 *
 * @author NELSON
 */
public class Controlador implements ActionListener {
  private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    private Vista v=null;  
    private Consulta c=null;
    
    public Controlador(Vista v,Consulta c){
        super(); 
        this.v=v;
        this.c=c;
        actionListener(this);
        v.jDateChooser1.setDate(new Date());
        v.dc1.setDate(new Date());
        v.dc1.setEnabled(false);
        v.btnActualizar.setEnabled(false);
        v.btnEliminar.setEnabled(false);
        v.btnActualizar2.setEnabled(false);
        v.btnEliminar2.setEnabled(false);
        v.lb1.setText(c.contarClientes().toString());
        v.lb2.setText(c.contarInstructores().toString());
        v.lb3.setText(c.contarClases().toString());
        v.btnActualizar3.setEnabled(false);
        v.btnVer1.setEnabled(false);
        v.btnVer2.setEnabled(false);
        mostrarClases();
    }
void limpiarCliente(){
    v.t1.setText("");
    v.t2.setText("");
    v.t3.setText("");
    v.t4.setText("");
    v.t5.setText("");
    v.jDateChooser1.setDate(new Date());
    v.btnBuscar.setEnabled(true);
    v.btnActualizar.setEnabled(false);
    v.btnEliminar.setEnabled(false);
    v.btnRegistrar.setEnabled(true);
    }
void limpiarAsignacion(){
    v.jCliente.setText("");
    v.jClase.removeAllItems();
    v.jDateChooser1.setDate(new Date());
    v.jDateChooser2.setDate(null);

    }
void limpiarInstructor(){
v.t6.setText("");
v.t7.setText("");
v.t8.setText("");
v.t9.setText("");
v.cb1.setSelectedIndex(0);
v.cb2.setSelectedIndex(0);
v.cb3.setSelectedIndex(0);
v.btnConsultar.setEnabled(true);
    v.btnActualizar2.setEnabled(false);
    v.btnEliminar2.setEnabled(false);
    v.btnRegistrar2.setEnabled(true);
}
    void limpiarClases(){
    v.t10.setText("");
    v.cb4.setSelectedIndex(0);
    v.cb5.removeAllItems();
    v.cb6.removeAllItems();
    v.btnActualizar2.setEnabled(false);
    v.btnVer1.setEnabled(false);
    v.btnVer2.setEnabled(false);
    v.btnRegistrar3.setEnabled(true);
    v.btnConsultar2.setEnabled(true);
    }
private void actionListener(ActionListener controlador){
v.jButton1.addActionListener(controlador);
v.jButton2.addActionListener(controlador);
v.jButton3.addActionListener(controlador);
v.btnRegistrar.addActionListener(controlador);
v.btnBuscar.addActionListener(controlador);
v.btnActualizar.addActionListener(controlador);
v.btnEliminar.addActionListener(controlador);
v.btnLimpiar.addActionListener(controlador);
v.btnRegistrar2.addActionListener(controlador);
v.btnConsultar.addActionListener(controlador);
v.btnActualizar2.addActionListener(controlador);
v.btnEliminar2.addActionListener(controlador);
v.btnLimpiar2.addActionListener(controlador);
v.btnRegistrar3.addActionListener(controlador);
v.btnActualizar3.addActionListener(controlador);
v.btnConsultar2.addActionListener(controlador);
v.btnVer1.addActionListener(controlador);
v.btnVer2.addActionListener(controlador);
v.btnCancelar.addActionListener(controlador);
v.btnAsignar.addActionListener(controlador);
    }

public void mostrarInstructores() {
int seleccionado = v.cb4.getSelectedIndex();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/gimnasio", "root", "");
            Statement stat = con.createStatement();
            String consulta = "SELECT * FROM instructor WHERE Especialidad LIKE '"+(String) v.cb4.getItemAt(seleccionado)+"'";
            ResultSet rs = stat.executeQuery(consulta);
            rs.first();
            do {
        v.cb5.addItem(rs.getString(2));
            } while (rs.next());            
        }catch(Exception e){
        e.getMessage();
        }
}
public void mostrarHorarios(){
int seleccionado = v.cb5.getSelectedIndex();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/gimnasio", "root", "");
            Statement stat = con.createStatement();
            String consulta = "SELECT * FROM instructor WHERE Nombres LIKE '"+(String) v.cb5.getItemAt(seleccionado)+"'";
            ResultSet rs = stat.executeQuery(consulta);
            rs.first();
            do {
        v.cb6.addItem(rs.getString(7));
            } while (rs.next());         
        }catch(Exception e){
        e.getMessage();
        }
}
public void mostrarClases(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/gimnasio", "root", "");
            Statement stat = con.createStatement();
            String consulta = "SELECT * FROM clase";
            ResultSet rs = stat.executeQuery(consulta);
            rs.first();
            do {
        v.jClase.addItem(rs.getString("codigo"));
            } while (rs.next());         
        }catch(Exception e){
        e.getMessage();
        }
}
public boolean verificardisponibilidadcodigo(String buscar){
    boolean estado=false;
String SQL2= "SELECT * FROM clase WHERE Codigo LIKE '"+buscar+"'";

try{
        Statement st = cn.createStatement();
        ResultSet rs=st.executeQuery(SQL2);
        
        while(rs.next()){
estado = true;
        }
    }catch(Exception e){
      JOptionPane.showConfirmDialog(null, e);
    }
return estado;
}

public boolean verificarhorario(String buscar,String buscar2){
    boolean estado = false;
String SQL2= "SELECT * FROM clase WHERE Horario LIKE '"+buscar+"' AND Instructor LIKE '"+buscar2+"'";

try{
        Statement st = cn.createStatement();
        ResultSet rs=st.executeQuery(SQL2);
        
        while(rs.next()){
estado = true;
        }
    }catch(Exception e){
      JOptionPane.showConfirmDialog(null, e.getMessage());
    }
return estado;
}
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
        if(e.getSource()==v.jButton1){
        Consulta c = new Consulta();
        v.lb1.setText(c.contarClientes().toString());
       
        }if(e.getSource()==v.jButton2){
        Consulta c = new Consulta();
        v.lb2.setText(c.contarInstructores().toString());
       
        }if(e.getSource()==v.jButton3){
        Consulta c = new Consulta();
        v.lb3.setText(c.contarClases().toString());
       
        }if(e.getSource()==v.btnRegistrar){
        
        if (v.t1.getText().length() == 0) {
            JOptionPane.showConfirmDialog(null, "Debes ingresar la Cedula del Cliente");
            v.t1.requestFocus();
            return;
        }
        if (v.t2.getText().length() == 0) {
            JOptionPane.showConfirmDialog(null, "Debes ingresar el Nombre del Cliente");
            v.t2.requestFocus();
            return;
        }

        if (v.t3.getText().length() == 0) {
            JOptionPane.showConfirmDialog(null, "Debes ingresar los Apellidos del Cliente");
            v.t3.requestFocus();
            return;
        }

        if (v.t4.getText().length() == 0) {
            JOptionPane.showConfirmDialog(null, "Debes ingresar la Dirección del Cliente");
            v.t4.requestFocus();
            return;
        }
        if (v.t5.getText().length() == 0) {
            JOptionPane.showConfirmDialog(null, "Debes ingresar el Telefono del Cliente");
            v.t5.requestFocus();
            return;
        }
        
        ClienteVO dts = new ClienteVO();
        ClienteDAO func = new ClienteDAO();
        
        dts.setCedula(v.t1.getText());
        dts.setNombre(v.t2.getText());
        dts.setApellidos(v.t3.getText());
        dts.setDireccion(v.t4.getText());
        dts.setTelefono(v.t5.getText());
        Calendar cal;
        int d,m,a;
        cal=v.dc1.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        dts.setFecha_Ingreso(new java.sql.Date(a,m,d));
                
        if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(null, "El Cliente fue Registrado Exitosamente");
                limpiarCliente();                          
        }
                 
        }if(e.getSource()==v.btnBuscar){
        
if (v.t1.getText().length() == 0) {
            JOptionPane.showConfirmDialog(null, "Debes ingresar la Cedula del Cliente");
            v.t1.requestFocus();
            return;
        }
        ClienteVO dts = new ClienteVO();
        ClienteDAO func = new ClienteDAO();
dts.setCedula(v.t1.getText());
if (func.buscar(dts,v.t1.getText())) {
                JOptionPane.showMessageDialog(null, "El Cliente fue Encontrado satisfactoriamente");
                v.t2.setText(dts.getNombre());
                v.t3.setText(dts.getApellidos());
                v.t4.setText(dts.getDireccion());
                v.t5.setText(dts.getTelefono());
                v.dc1.setDate(dts.getFecha_Ingreso());
                v.btnActualizar.setEnabled(true);
    v.btnEliminar.setEnabled(true);
    v.btnRegistrar.setEnabled(false);
    v.btnBuscar.setEnabled(false);
            }else{
JOptionPane.showMessageDialog(null, "El Cliente No fue Encontrado en la BD");
limpiarCliente();
}       
        }if(e.getSource()==v.btnActualizar){        
        if (v.t4.getText().length() == 0) {
            JOptionPane.showConfirmDialog(null, "Debes ingresar la Dirección del Cliente");
            v.t4.requestFocus();
            return;
        }
        if (v.t5.getText().length() == 0) {
            JOptionPane.showConfirmDialog(null, "Debes ingresar el Telefono del Cliente");
            v.t5.requestFocus();
            return;
        }
        ClienteVO dts = new ClienteVO();
        ClienteDAO func = new ClienteDAO();
        dts.setDireccion(v.t4.getText());
        dts.setTelefono(v.t5.getText());
            dts.setCedula((v.t1.getText()));
            if (func.actualizar(dts)) {
                JOptionPane.showMessageDialog(null, "Los Datos del Cliente Fueron Actualizados Exitosamente");
                limpiarCliente();
            }        
        }if(e.getSource()==v.btnEliminar){
         if (!v.t1.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(null, "Estás seguro de Eliminar el Cliente?","Confirmar",2);           
            if (confirmacion==0) {
                ClienteVO dts = new ClienteVO();
                ClienteDAO func = new ClienteDAO();
                dts.setCedula(v.t1.getText());
                func.eliminar(dts);
                JOptionPane.showMessageDialog(null, "Cliente Eliminado Exitosamente");
               limpiarCliente();
            }   
        }
        }if(e.getSource()==v.btnLimpiar){
        limpiarCliente();
        }if(e.getSource()==v.btnRegistrar2){
          if (v.t6.getText().length() == 0) {
            JOptionPane.showConfirmDialog(null, "Debes ingresar el Codigo del Instructor");
            v.t6.requestFocus();
            return;
        }
        if (v.t7.getText().length() == 0) {
            JOptionPane.showConfirmDialog(null, "Debes ingresar el Nombre del Instructor");
            v.t7.requestFocus();
            return;
        }
        if (v.t8.getText().length() == 0) {
            JOptionPane.showConfirmDialog(null, "Debes ingresar los Apellidos del Instructor");
            v.t8.requestFocus();
            return;
        }
        if (v.t9.getText().length() == 0) {
            JOptionPane.showConfirmDialog(null, "Debes ingresar el Telefono del Instructor");
            v.t9.requestFocus();
            return;
        }  
        InstructorVO dts = new InstructorVO();
        InstructorDAO func = new InstructorDAO();       
        dts.setCodigo(v.t6.getText());
        dts.setNombres(v.t7.getText());
        dts.setApellidos(v.t8.getText());
        dts.setTelefono(v.t9.getText());
        int seleccionado = v.cb1.getSelectedIndex();
        dts.setEspecialidad((String) v.cb1.getItemAt(seleccionado));
        seleccionado = v.cb2.getSelectedIndex();
        dts.setJornada((String) v.cb2.getItemAt(seleccionado));          
        seleccionado = v.cb3.getSelectedIndex();
        dts.setHorario((String) v.cb3.getItemAt(seleccionado));
        if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(null, "El Instructor fue Registrado Exitosamente");
                limpiarInstructor();                                          
        }       
        }if(e.getSource()==v.btnConsultar){
        if (v.t6.getText().length() == 0) {
            JOptionPane.showConfirmDialog(null, "Debes ingresar el Codigo del Instructor");
            v.t6.requestFocus();
            return;
        }

        InstructorVO dts = new InstructorVO();
        InstructorDAO func = new InstructorDAO();

dts.setCodigo(v.t6.getText());
if (func.buscar(dts,v.t6.getText())) {
                JOptionPane.showMessageDialog(null, "El Instructor fue Encontrado satisfactoriamente");
                v.t7.setText(dts.getNombres());
                v.t8.setText(dts.getApellidos());
                v.t9.setText(dts.getTelefono());
                v.cb1.setSelectedItem((dts.getEspecialidad()));
                v.cb2.setSelectedItem((dts.getJornada()));
                v.cb3.setSelectedItem((dts.getHorario()));
                v.btnActualizar2.setEnabled(true);
    v.btnEliminar2.setEnabled(true);
    v.btnRegistrar2.setEnabled(false);
    v.btnConsultar.setEnabled(false);
            }else{
JOptionPane.showMessageDialog(null, "El Instructor No fue Encontrado en la BD");
limpiarInstructor();
}       
        }if(e.getSource()==v.btnActualizar2){
        if (v.t9.getText().length() == 0) {
            JOptionPane.showConfirmDialog(null, "Debes ingresar el Telefono del Instructor");
            v.t9.requestFocus();
            return;
        }       
        InstructorVO dts = new InstructorVO();
        InstructorDAO func = new InstructorDAO();        
        dts.setTelefono(v.t9.getText());        
        int seleccionado = v.cb1.getSelectedIndex();
        dts.setEspecialidad((String) v.cb1.getItemAt(seleccionado));        
         seleccionado = v.cb2.getSelectedIndex();
        dts.setJornada((String) v.cb2.getItemAt(seleccionado));          
        seleccionado = v.cb3.getSelectedIndex();
        dts.setHorario((String) v.cb3.getItemAt(seleccionado));
        dts.setCodigo((v.t6.getText()));  
            if (func.actualizar(dts)) {
                JOptionPane.showMessageDialog(null, "Los Datos del Instructor Fueron Actualizados Exitosamente");
                limpiarInstructor();
            }        
        }if(e.getSource()==v.btnEliminar2){
        if (!v.t6.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(null, "Estás seguro de Eliminar el Instructor?","Confirmar",2);            
            if (confirmacion==0) {
               InstructorVO dts = new InstructorVO();
               InstructorVO dts2 = new InstructorVO();
        InstructorDAO func = new InstructorDAO();
                dts.setCodigo(v.t6.getText());
                dts2.setNombres(v.t7.getText());
                func.eliminar(dts);
                func.eliminar2(dts2);
                JOptionPane.showMessageDialog(null, "El Instructor y Las Clases que Este Daba Fueron Eliminadas Exitosamente");
               limpiarInstructor();
            }    
        }
        }if(e.getSource()==v.btnLimpiar2){
        limpiarInstructor();        
        }if(e.getSource()==v.btnRegistrar3){
        if (v.t10.getText().length() == 0) {
            JOptionPane.showConfirmDialog(null, "Debes ingresar el Codigo de la Clase");
            v.t10.requestFocus();
            return;
        }     
        int seleccionado = v.cb6.getSelectedIndex();
        
        
        int seleccionado2 = v.cb5.getSelectedIndex();
    if(verificardisponibilidadcodigo(v.t10.getText())==true){
JOptionPane.showMessageDialog(null,"Ojo!! Este Codigo de Clase Ya Existe, Elija Otro Código\n ","Advertencia",JOptionPane.WARNING_MESSAGE);

v.t10.requestFocus();
            return;
    
    }if(verificarhorario((String) v.cb6.getItemAt(seleccionado),(String) v.cb5.getItemAt(seleccionado2))==true){
        JOptionPane.showMessageDialog(null,"Ojo!! Este Instructor ya Tiene una Clase Asignada en este Mismo Horario, Elija Otro Instructor\n ","Advertencia",JOptionPane.WARNING_MESSAGE);

    }else{

        ClaseVO dts = new ClaseVO();
        ClaseDAO func = new ClaseDAO();        
        dts.setCodigo(v.t10.getText());        
        seleccionado = v.cb4.getSelectedIndex();
        dts.setTipo((String) v.cb4.getItemAt(seleccionado));               
        seleccionado = v.cb6.getSelectedIndex();
        dts.setHorario((String) v.cb6.getItemAt(seleccionado));       
         seleccionado = v.cb5.getSelectedIndex();
        dts.setInstructor((String) v.cb5.getItemAt(seleccionado));  
        if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(null, "La Clase fue Registrada Exitosamente");
                limpiarClases();
        }          
    }
        }if(e.getSource()==v.btnConsultar2){
        if (v.t10.getText().length() == 0) {
            JOptionPane.showConfirmDialog(null, "Debes ingresar el Codigo del Instructor");
            v.t10.requestFocus();
            return;
        }
        ClaseVO dts = new ClaseVO();
        ClaseDAO func = new ClaseDAO();
dts.setCodigo(v.t10.getText());
if (func.buscar(dts,v.t10.getText())) {
                JOptionPane.showMessageDialog(null, "La Clase fue Encontrada Exitosamente");
                
                v.cb4.setSelectedItem((dts.getTipo()));
                v.cb6.setSelectedItem((dts.getHorario()));
                v.cb5.setSelectedItem((dts.getInstructor()));
                mostrarInstructores();
                mostrarHorarios();
                v.btnActualizar3.setEnabled(true);
    v.btnVer1.setEnabled(true);
    v.btnVer2.setEnabled(true);
    v.btnRegistrar3.setEnabled(false);
    v.btnConsultar2.setEnabled(false);
            }else{
JOptionPane.showMessageDialog(null, "la Clase No fue Encontrada en la BD");
limpiarClases();
}
        }if(e.getSource()==v.btnActualizar3){
        if (v.t10.getText().length() == 0) {
            JOptionPane.showConfirmDialog(null, "Debes ingresar el Codigo de la Clase");
            v.t10.requestFocus();
            return;
        }
       ClaseVO dts = new ClaseVO();
        ClaseDAO func = new ClaseDAO();
        int seleccionado = v.cb4.getSelectedIndex();
        dts.setTipo((String) v.cb4.getItemAt(seleccionado));
                
        seleccionado = v.cb6.getSelectedIndex();
        dts.setHorario((String) v.cb6.getItemAt(seleccionado));
        
         seleccionado = v.cb5.getSelectedIndex();
        dts.setInstructor((String) v.cb5.getItemAt(seleccionado)); 
        dts.setCodigo((v.t10.getText()));
            
            
            if (func.actualizar(dts)) {
                JOptionPane.showMessageDialog(null, "Las Caracteristicas de la Clase "+v.t10.getText()+" Fueron Actualizados Exitosamente");
                limpiarClases();
            }
        }if(e.getSource()==v.btnCancelar){
        limpiarClases();
        }if(e.getSource()==v.btnVer1){
        v.cb5.removeAllItems();
        mostrarInstructores();
        }if(e.getSource()==v.btnVer2){
        v.cb6.removeAllItems();
        mostrarHorarios();
        }if(e.getSource()==v.btnAsignar){      
        if (v.jCliente.getText().length() == 0) {
            JOptionPane.showConfirmDialog(null, "Debes ingresar la Cedula del Cliente");
            v.jCliente.requestFocus();
            return;
        }
        ClienteVO clienteVO = new ClienteVO();
        ClienteDAO clienteDAO = new ClienteDAO();
        if(clienteDAO.buscar(clienteVO, v.jCliente.getText())==false){
        JOptionPane.showMessageDialog(null, "Ojo, Este Cliente no se Encuentra Registrado");
        }else{
        
        AsignacionVO dts = new AsignacionVO();
        AsignacionDAO func = new AsignacionDAO();
        
        dts.setCliente(v.jCliente.getText());
        int seleccionado = v.jClase.getSelectedIndex();
        dts.setClase((String) v.jClase.getItemAt(seleccionado));
        Calendar cal;
        int d,m,a;
        cal=v.jDateChooser1.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        dts.setFecha_inicio(new java.sql.Date(a,m,d));
        
        cal=v.jDateChooser2.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        dts.setFecha_fin(new java.sql.Date(a,m,d));
        if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(null, "La Asignación de la Clase, fue Registrada Exitosamente");
                limpiarAsignacion();      
                mostrarClases();
        }
        }
        }if(e.getSource()==v.jButton5){
        limpiarAsignacion();
        mostrarClases();
        
        }
        }catch(Exception ev){
        ev.getMessage();
        }
}
}
