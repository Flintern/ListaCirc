/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad000555;

import javax.swing.JOptionPane;

/**
 *
 * @author SARIC
 */
public class Nodo {

    String id;
    String nombre;
    String sexo;
    int edad;
    String grado;
    Nodo sig;

    public Nodo(String id, String nombre, String sexo, int edad, String grado) {
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.grado = grado;
        sig = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public void getMostrarNodo() {

        String info = "Información del nodo:\n";
        info += "ID: " + id + "\n";
        info += "Nombre: " + nombre + "\n";
        info += "Sexo: " + sexo + "\n";
        info += "Edad: " + edad + "\n";
        info += "Grado: " + grado + "\n";

        JOptionPane.showMessageDialog(null, info);
    }
}
