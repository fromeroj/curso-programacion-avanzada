// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package mx.unam.mcc.pa;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import mx.unam.mcc.pa.Estado;
import mx.unam.mcc.pa.Usuario;

privileged aspect Usuario_Roo_DbManaged {
    
    @ManyToOne
    @JoinColumn(name = "id_est", referencedColumnName = "id")
    private Estado Usuario.idEst;
    
    @Column(name = "nombre", length = 100)
    private String Usuario.nombre;
    
    @Column(name = "apellidos", length = 200)
    private String Usuario.apellidos;
    
    public Estado Usuario.getIdEst() {
        return idEst;
    }
    
    public void Usuario.setIdEst(Estado idEst) {
        this.idEst = idEst;
    }
    
    public String Usuario.getNombre() {
        return nombre;
    }
    
    public void Usuario.setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String Usuario.getApellidos() {
        return apellidos;
    }
    
    public void Usuario.setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
}
