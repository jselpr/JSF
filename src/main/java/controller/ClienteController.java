/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;



import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Cliente;
import modelo.DAO;

/**
 *
 * @author usuario
 */
@ManagedBean(name = "clienteController")
@ViewScoped
public class ClienteController {
    
    @ManagedProperty(value = "#{dao}")
    private DAO dao;

   
    /**
     * Creates a new instance of ClienteController
     */
    public ClienteController() {
    }

    private Boolean creando = false;
    
    private Cliente actual,nuevo;

    
    
    
    public String inicioEdicion(Cliente actual){
        actual.setEnEdicion(true);
        this.actual = actual;
        return "";
    }

    public Cliente getActual() {
        return actual;
    }

    public void setActual(Cliente actual) {
        this.actual = actual;
    }
    
    

    public DAO getDao() {
        return dao;
    }

    public void setDao(DAO dao) {
        this.dao = dao;
    }
    
    public String borrar(Cliente c){
        FacesContext fc = FacesContext.getCurrentInstance(); //Punto de entrada al api JSF
        String mensaje;
        try {
            dao.borrar(c);
            
            mensaje="Eliminaodo correctamente "+c.getNombre();
        } catch (Exception e) {
            e.printStackTrace();
            mensaje="Problemas al  eliminar "+c.getNombre()+ " "+e.getMessage();
        }
        fc.addMessage("elFormulario",new FacesMessage(mensaje));
        return "";
    }
    
    public String guardarEdicion(){
        FacesContext fc = FacesContext.getCurrentInstance(); //Punto de entrada al api JSF
        String mensaje;
        try {
            dao.actualizar(actual);
            actual.setEnEdicion(false);
            
            mensaje="Editado correctamente "+actual.getNombre();
        } catch (Exception e) {
            e.printStackTrace();
            mensaje="Problemas al  editar "+actual.getNombre()+ " "+e.getMessage();
        }
        fc.addMessage("elFormulario",new FacesMessage(mensaje));
        return "";
    }

    public Boolean getCreando() {
        return creando;
    }

    public void setCreando(Boolean creando) {
        this.creando = creando;
    }
     public String crear(){
         setCreando(true);
         nuevo = new Cliente();
         return "";
     }

    public Cliente getNuevo() {
        return nuevo;
    }

    public void setNuevo(Cliente nuevo) {
        this.nuevo = nuevo;
    }
    
     public String guardarNuevo(){
        FacesContext fc = FacesContext.getCurrentInstance(); //Punto de entrada al api JSF
        String mensaje;
        try {
            dao.insertar(nuevo);
            setCreando(false);
            
            mensaje="Insertado correctamente "+nuevo.getNombre();
        } catch (Exception e) {
            e.printStackTrace();
            mensaje="Problemas al  editar "+nuevo.getNombre()+ " "+e.getMessage();
        }
        fc.addMessage("elFormulario",new FacesMessage(mensaje));
        return "";
    }
     
     public String cancelarNuevo(){
         setCreando(false);
         return "";
     }
}
