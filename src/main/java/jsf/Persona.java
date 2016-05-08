/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 *
 * @author usuario
 */
@Named(value = "persona")
@RequestScoped
public class Persona {
    
    private String fechaNacimiento;

    /**
     * Get the value of fechaNacimiento
     *
     * @return the value of fechaNacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Set the value of fechaNacimiento
     *
     * @param fechaNacimiento new value of fechaNacimiento
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @NotNull
    private String nombre="Anonimo";
    @Max(120)
    private int edad=-1;
    /**
     * Creates a new instance of Persona
     */
    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String ejecutar(int valor){
        System.out.println(valor);
        System.out.println(nombre);
        System.out.println(edad);
        return "";
    }
}
