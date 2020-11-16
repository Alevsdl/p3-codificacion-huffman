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
public class Lista {

    private Nodo inicio;

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Lista() {
        this.setInicio(null);
    }

    public void insertarD(char letra, String camino) {
        if (inicio == null) {
            insertarInicio(letra, camino);
        } else {
            insertarFinal(letra, camino);
        }
    }

    public void insertarInicio(char d) {
        Nodo nuevo = new Nodo(d);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
    }

    public void recorrer() {
        Nodo aux = inicio;
        while (aux != null) {
            System.out.print(aux.getDato() + " -> ");
            aux = aux.getSiguiente();
        }
    }

    public String mandarCadenaDiccionario() {
        String dic = "";
        Nodo aux = inicio;
        while (aux != null) {
            dic = dic + aux.getDato() + aux.getCamino() + ":";
            aux = aux.getSiguiente();
        }
        dic = dic + ";";
        return dic;
    }
    public String cadenaVisualizar()
    {
        String dic = "";
        Nodo aux = inicio;
        while (aux != null) {
            dic = dic + aux.getDato() + ":"+aux.getCamino() + " ";
            aux = aux.getSiguiente();
        }
        dic = dic;
        return dic;
    }

    public void insertarFinal(char d) {
        Nodo nuevo = new Nodo(d);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo aux = inicio;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
    }

    public Integer eliminarValor(char valor) {
        Integer contador = 0;
        if (inicio != null) {
            Nodo aux = inicio;
            Nodo ant = null;
            while (aux != null) {
                if (aux.getDato() == valor) {
                    if (ant == null) {
                        inicio = inicio.getSiguiente();
                        aux.setSiguiente(null);
                        aux = inicio;
                    } else {
                        ant.setSiguiente(aux.getSiguiente());
                        aux.setSiguiente(null);
                        aux = ant.getSiguiente();
                    }
                    contador++;
                } else {
                    ant = aux;
                    aux = aux.getSiguiente();
                }
            }
        }
        return contador;
    }

    public void insertarInicio(char letra, String camino) {
        Nodo nuevo = new Nodo(letra, camino);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
    }

    public void recorrer2() {
        Nodo aux = inicio;
        while (aux != null) {
            System.out.print(aux.getDato() + ":" + aux.getCamino() + " -> ");
            aux = aux.getSiguiente();
        }
    }

    public void insertarFinal(char letra, String camino) {
        Nodo nuevo = new Nodo(letra, camino);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo aux = inicio;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
    }

    public boolean comparar(String b) {
        Nodo aux = inicio;
        boolean bb=false;
        while (aux != null) {
            
            if (b.equals(aux.getCamino())) {
               bb=true;
                

            }
            //System.out.print(aux.getDato() + ":" + aux.getCamino() + " -> ");
            aux = aux.getSiguiente();
        }
        return bb;

    }
    public String guardar(String b)
    {
        Nodo aux = inicio;
        String bb="";
        while (aux != null) {
            
            if (b.equals(aux.getCamino())) {
               bb=Character.toString(aux.getDato());
                

            }
            //System.out.print(aux.getDato() + ":" + aux.getCamino() + " -> ");
            aux = aux.getSiguiente();
        }
        return bb;
    }

}
