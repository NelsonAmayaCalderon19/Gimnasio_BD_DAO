/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelVO;

/**
 *
 * @author Claudia
 */
public class ClaseVO {
    private String codigo;
    private String tipo;
    private String horario;
    private String instructor;

    public ClaseVO() {
    }

    public ClaseVO(String codigo, String tipo, String horario, String instructor) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.horario = horario;
        this.instructor = instructor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    
    
    
}
