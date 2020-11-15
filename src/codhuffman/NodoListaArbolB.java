/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codhuffman;

/**
 *
 * @author ALEJANDRA
 */
public class NodoListaArbolB{
    private ArbolBinario dato;
    private NodoListaArbolB siguiente;

    public NodoListaArbolB(ArbolBinario dato) {
        this.dato = dato;
        this.siguiente=null;
    }
    
    @Override
    public String toString()
    {return dato.toString();}

    public ArbolBinario getDato() {
        return dato;
    }

    public NodoListaArbolB getSiguiente() {
        return siguiente;
    }

    public void setDato(ArbolBinario dato) {
        this.dato = dato;
    }

    public void setSiguiente(NodoListaArbolB siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
