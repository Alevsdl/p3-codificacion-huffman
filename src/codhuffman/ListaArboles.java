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
public class ListaArboles {
     private NodoListaArbolB inicio;

    public NodoListaArbolB getInicio() {
        return inicio;
    }

    public void setInicio(NodoListaArbolB inicio) {
        this.inicio = inicio;
    }

    public void insertarInicio(ArbolBinario d) {
        NodoListaArbolB nuevo = new NodoListaArbolB(d);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
    }

    public void recorrer() {
        NodoListaArbolB aux = inicio;
        while (aux != null) {
            System.out.print(aux.getDato() + " -> ");
            aux = aux.getSiguiente();
        }
    }

    public void insertarFinal(ArbolBinario d) {
        NodoListaArbolB nuevo = new NodoListaArbolB(d);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            NodoListaArbolB aux = inicio;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
    }

    public void insertarOrdenado(ArbolBinario d) {
        NodoListaArbolB nuevo = new NodoListaArbolB(d);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            NodoListaArbolB aux = inicio;
            NodoListaArbolB ant = null;
            while (aux != (null) && (aux.getDato().getRaiz().getDato() <= nuevo.getDato().getRaiz().getDato())) {
                ant = aux;
                aux = aux.getSiguiente();
            }
            if (ant == null) {
                nuevo.setSiguiente(inicio);
                inicio = nuevo;
            } else if (aux == null) {
                ant.setSiguiente(nuevo);
            } else {
                ant.setSiguiente(nuevo);
                nuevo.setSiguiente(aux);
            }
        }
    }

    
}
