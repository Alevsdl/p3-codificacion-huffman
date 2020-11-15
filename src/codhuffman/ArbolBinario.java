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
public class ArbolBinario {
      private NodoArbolB raiz;

    public NodoArbolB getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbolB raiz) {
        this.raiz = raiz;
    }

    public ArbolBinario() {
        raiz = null;
    }

    public ArbolBinario(NodoArbolB raizArbol) {
        raiz = raizArbol;
    }

    public void insertar(char letra, Integer d) {
        NodoArbolB nuevo = new NodoArbolB(letra, d);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            NodoArbolB aux = raiz;
            NodoArbolB ant = null;
            while (aux != null) {
                ant = aux;
                if (d <= aux.getDato()) {
                    aux = aux.getIzq();
                } else {
                    aux.getDer();
                }
            }
            if (d <= ant.getDato()) {
                ant.setIzq(nuevo);
            } else {
                ant.setDer(nuevo);
            }
        }
    }

    public String toString() {
        return raiz.toString();
    }

    public void enOrder(NodoArbolB r) {
        if (r != null) {
            enOrder(r.getIzq());
            System.out.println(r.toString());
            enOrder(r.getDer());
        }
    }

}
