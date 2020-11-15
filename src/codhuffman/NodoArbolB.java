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
public class NodoArbolB {
    private Integer dato;
    private char letra;
    private NodoArbolB izq;
    private NodoArbolB der;

    public Integer getDato() {
        return dato;
    }

    public void setDato(Integer dato) {
        this.dato = dato;
    }

    public NodoArbolB getIzq() {
        return izq;
    }

    public void setIzq(NodoArbolB izq) {
        this.izq = izq;
    }

    public NodoArbolB getDer() {
        return der;
    }

    public void setDer(NodoArbolB der) {
        this.der = der;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public NodoArbolB(char l, Integer d) {
        letra = l;
        dato = d;
        izq = null;
        der = null;
    }

    @Override
    public String toString() {
        return letra + ":" + dato;
    }
    
    
}
