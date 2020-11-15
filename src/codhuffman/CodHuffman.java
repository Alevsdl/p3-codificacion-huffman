/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codhuffman;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALEJANDRA
 */
public class CodHuffman {

    /**
     * @param args the command line arguments
     */
    private String mensaje;
    private String resultado;
    private Lista camino;
    static String mandar;
    
    public String getMensaje() {
        return mensaje;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public CodHuffman(String msg) {
        mensaje = msg;
        camino = new Lista();
        resultado = "";
    }

    public CodHuffman() {
        
    }
    
    public Lista ToNodos() {
        Lista l = new Lista();
        for (int i = 0; i < mensaje.length(); i++) {
            l.insertarFinal((mensaje.charAt(i)));
        }
        return l;
        
    }
    
    public ListaArboles cuentaLetras(Lista l) {
        ListaArboles la = new ListaArboles();
        Nodo aux = l.getInicio();
        while (aux != null) {
            Integer x = l.eliminarValor(aux.getDato());
            NodoArbolB nuevo = new NodoArbolB(aux.getDato(), x);
            ArbolBinario a = new ArbolBinario(nuevo);
            la.insertarOrdenado(a);
            aux = l.getInicio();
        }
        return la;
    }
    
    public NodoArbolB uneNodos(NodoListaArbolB a, NodoListaArbolB b) {
        NodoArbolB c = new NodoArbolB('\u0000',
                ((a.getDato().getRaiz().getDato()) + (b.getDato().getRaiz()
                .getDato())));
        c.setIzq(a.getDato().getRaiz());
        c.setDer(b.getDato().getRaiz());
        return c;
    }
    
    public ListaArboles juntaNodo(ListaArboles l) {
        NodoListaArbolB aux = l.getInicio();
        NodoListaArbolB aux2 = null;
        while ((aux != null) && (aux.getSiguiente() != null)) {
            l.setInicio(aux.getSiguiente());
            aux.setSiguiente(null);
            aux2 = l.getInicio();
            l.setInicio(aux2.getSiguiente());
            aux2.setSiguiente(null);
            NodoArbolB nuevo = uneNodos(aux, aux2);
            ArbolBinario a = new ArbolBinario(nuevo);
            l.insertarOrdenado(a);
            aux = l.getInicio();
        }
        // Arbol a=l.getInicio().getDato();
        // a.enOrder(a.getRaiz());
        // a.encuentraCamino(a.getRaiz(), "");
        // System.out.println("dato: "+l.getInicio().getDato().getRaiz().getDato());
        // System.out.println("letra: "+l.getInicio().getDato().getRaiz().getLetra());
        return l;
    }
    
    public void recorrer2(Lista l) {
        Nodo n = l.getInicio();
        while (n != null) {
            System.out.print(n.getDato() + n.getCamino() + "->");
            n = n.getSiguiente();
        }
    }
    
    public String eliminarUltimo(String re) {
        String cadena = "";
        for (int i = 0; i < re.length() - 1; i++) {
            cadena += re.charAt(i);
        }
        return cadena;
    }
    
    public void encuentraCamino(NodoArbolB r, String c) {
        // Lista camino = new Lista();
        resultado += c;
        if (r != null) {
            if (r.getLetra() != '\u0000') { // si es una letra
                camino.insertarFinal(r.getLetra(), resultado);
            }
            encuentraCamino(r.getIzq(), "0");
            if (r.getIzq() != null) {
                resultado = eliminarUltimo(resultado);
            }
            encuentraCamino(r.getDer(), "1");
            if (r.getDer() != null) { // si no es un nodo hoja
                resultado = eliminarUltimo(resultado);
            }
        } else {
            resultado = eliminarUltimo(resultado);
        }
    }
    
    public Lista regresaCaminos() { // retornamos la lista que contiene los
        // caminos de cada caracter
        return camino;
    }
    
    public String busca(char s, Lista l) {
        String camino = "";
        Nodo aux = l.getInicio();
        while (aux != null) {
            if (aux.getDato() == s) {
                camino = aux.getCamino();
            }
            aux = aux.getSiguiente();
        }
        return camino;
    }
    
    public String convierte(Lista camino) {
        String c = "";
        for (int i = 0; i < mensaje.length(); i++) {
            c = c + busca(mensaje.charAt(i), camino);
        }
        return c;
    }
    
    public char toAscii(String s) {// obtiene un codigo de 8 o menor
        String ascii = "";
        int numero = 0;
        int contador = 0;
        for (int i = 0; i < s.length(); i++) {// binario es string
            if (contador <= 8) {
                ascii = ascii + s.charAt(i);
                numero = Integer.parseInt(ascii, 2);
                if (contador == 8) {
                    ascii = "";
                    contador = 0;
                }
            }
        }
        return (char) numero;
    }
    
    public String encripta(String codigoHuffman) {
        String bites = "";
        String codigo = "";
        char c;
        int contador = 0;
        if (codigoHuffman.length() >= 8) {
            for (int i = 0; i < codigoHuffman.length(); i++) {
                if (contador <= 8) {
                    bites = bites + codigoHuffman.charAt(i);
                    contador++;
                    if (contador == 8) {
                        c = toAscii(bites);
                        codigo = codigo + c;
                        contador = 0;
                        bites = "";
                    }
                }
            }
        } else {
            c = toAscii(codigoHuffman);
            codigo = codigo + c;
        }
        mandar = codigo;
        //System.out.println("Codigo Encriptado " + codigo);
        return codigo;
    }
   public  String convertBinaryStringToString(String string){
    char[] chars = string.toCharArray();
    char[] transcoded = new char[(chars.length / 9)+1];

    //for each character (plus one for spacing)
    for (int j = 0; j < chars.length; j+=9) {
        int idx = 0;
        int sum = 0;

        //for each bit in reverse
        for (int i = 7; i>= 0; i--) {
            if (chars[i+j] == '1') {
                sum += 1 << idx;
            }
            idx++;
        }
        transcoded[j/9] = (char) sum;
    }
    return new String(transcoded);
}
    
    public void encripta2(String codigoHuffman) {
        String bites = "";
        String codigo = "";
        char c;
        int contador = 0;
        for (int i = 0; i < codigoHuffman.length(); i++) {
            bites = bites + codigoHuffman.charAt(i);
            contador++;
            if (contador == 8) {
                c = toAscii(bites);
                codigo = codigo + c;
                contador = 0;
                bites = "";
            }
        }
        System.out.println("Codigo Encriptado2 " + codigo);
    }
 //-----------------------------------------------------------------------------   
    public String desencripta() {

        //leer archivos
        String cadenaEncriptada = leertxtCADENA();
        String diccionarioo = leertxtDICCIONARIO();
        //crear LISTA con diccionario para desencriptar
        Lista listaDic = new Lista();
        listaDic = crearDiccionarioDesencriptar(diccionarioo);
        //pasar a binario cadena
//        String c = "";//cadena de binario
//         System.out.println("tamanio:" + mandar.length());
//        for (int i = 0; i < candenaEncriptada.length(); i++) {
//            int aux = (int) candenaEncriptada.charAt(i);//pasar a ascii
//            c = c + toBinaryString(aux);
//        }
//        System.out.println(candenaEnc"riptada);
//        System.out.println("BINARIO OTRA VEZ:" + c);
        //
        System.out.println("Descomprimir");
        System.out.println("Cadena encripatada archivo: "+cadenaEncriptada);
        System.out.println("diccionario archivo: "+diccionarioo);
        //compara binario de cadena con diccionario
        char auxChar=cadenaEncriptada.charAt(0);
        String aux="";//auxiliar guarda bit
        String aux2="";
        String cadena="";
        int cont=0;
        for (int i = 0; i <cadenaEncriptada.length(); i++) {
            cont=i;
            //char a string
            aux2=Character.toString(cadenaEncriptada.charAt(i));
            //System.out.println("------------------char de i:"+i+ " "+aux2);
            //System.out.println(aux);
            //
            if (listaDic.comparar(aux)==false) {
                aux=aux+Character.toString(cadenaEncriptada.charAt(i));
              //  System.out.println("es false y aux:"+aux);
            }
            else   {
            cadena=cadena+listaDic.guardar(aux);
            aux=Character.toString(cadenaEncriptada.charAt(i));
                //System.out.println("AHORA LA CADENA ES:"+cadena);
            }
        }//debe hacer la ultima comparacion que quedo del ciclo 
        if (listaDic.comparar(aux)==true) {
            
                cadena=cadena+listaDic.guardar(aux);
            }
        System.out.println("Cadena desencriptada:"+cadena);
        return cadena; 
    }
    
    public String leertxtDICCIONARIO() {
        String textoD = "";
        try {
            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\ALEJANDRA\\Documents\\NetBeansProjects\\codHuffman\\diccionario.txt"));//cambiar segun pc
            String aux = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                aux = aux + bfRead;
            }
            textoD = aux;
        } catch (Exception e) {
            System.err.println("No se encontro archivo.");
        }
        return textoD;

//        System.out.println("LEIDDDO:" + textoD);
//        crearDiccionarioDesencriptar(textoD);
    }
    
    public String leertxtCADENA() {
        String textoD = "";
        try {
            RandomAccessFile archivo1 = new RandomAccessFile("cadena.data", "rw");
            
            int longitud2 = archivo1.readByte();
            System.out.println(longitud2);
            byte[] lecturaByte = new byte[longitud2];
            archivo1.read(lecturaByte);
            textoD = new String(lecturaByte);

//            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\ALEJANDRA\\Documents\\NetBeansProjects\\Algoritmo-de-Huffman-master\\cadena.txt"));
//            String aux = "";
//            String bfRead;
//            while ((bfRead = bf.readLine()) != null) {
//                aux = aux + bfRead;
//            }
//            textoD = aux;
        } catch (Exception e) {
            System.err.println("No se encontro archivo.");
        }

        //System.out.println("LEIDDDO:" + textoD);
        return textoD;
    }
    
    public void crearTxtCadena(String b) {
        
        String nombreArchivo = "cadena.data";
        try {
            FileOutputStream archivo;
            
            archivo = new FileOutputStream(nombreArchivo);
            archivo.close();
            RandomAccessFile archivo1 = new RandomAccessFile("cadena.data", "rw");
            archivo1.writeByte(b.length());
            archivo1.write(b.getBytes());
//            //dicionario
//            FileOutputStream diccionario;
//            diccionario = new FileOutputStream(nombreArchivo2);
//            DataOutputStream escritor2 = new DataOutputStream(diccionario);
//            //String dic=listaCaminos.mandarCadenaDiccionario();
//            escritor.write(mandar.getBytes(StandardCharsets.US_ASCII));
//            diccionario.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CodHuffman.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CodHuffman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearTxtDic(String dic) {
        String nombreArchivo2 = "diccionario.txt";
        
        try {
            FileOutputStream diccionario;
            
            diccionario = new FileOutputStream(nombreArchivo2);
            DataOutputStream escritor = new DataOutputStream(diccionario);
            escritor.write(dic.getBytes());
            diccionario.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CodHuffman.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CodHuffman.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Lista crearDiccionarioDesencriptar(String d) {
        char auxLetra = ' ';
        String auxB = "";
        Lista listaDic = new Lista();
        for (int i = 0; i < d.length(); i++) {
            if (d.charAt(i) == ';') {
                break;
            } else {
                if (d.charAt(i) != ':') {//: division entre diccionarios
                    int ascii = (int) d.charAt(i);
                    if ((ascii >= 97) && (ascii <= 122) || (ascii == 32)) {// si es una letra segun cod ascii
                        //auxLetra=auxLetra+Character.toString(d.charAt(i));//guardar en auxiliar
                        auxLetra = d.charAt(i);
                    } else {
                        auxB = auxB + Character.toString(d.charAt(i));
                        
                    }
                } else {
                    listaDic.insertarD(auxLetra, auxB);
                    auxB = "";
                }
                
            }
        }
        //System.out.println("letras:"+auxLetra+" Binario:"+auxB);
        //listaDic.recorrer2();
        return listaDic;
        
    }
    
    public static void main(String args[]) throws IOException {
        CodHuffman h = new CodHuffman("papa pelada");
        Lista l = h.ToNodos();
        ListaArboles la = h.cuentaLetras(l);
        ListaArboles l2 = h.juntaNodo(la);
        System.out.println("Lista l2:");
        h.encuentraCamino(l2.getInicio().getDato().getRaiz(), "");
        Lista listaCaminos = h.regresaCaminos();
        System.out.println("DICCIONARIO: ");
        listaCaminos.recorrer2();///dicionario
        String x = h.convierte(listaCaminos);
        System.out.println("Binario" + x);
        
        h.encripta(x);
        String dic = listaCaminos.mandarCadenaDiccionario();
        System.out.println("diccionario guardado:" + dic + "fin");
//////////////////////////////////// crear archivos
        h.crearTxtCadena(x);
        h.crearTxtDic(dic);
        
        System.out.println("Cadena desencriptada: "+h.desencripta());
        //System.out.println("jj:" + h.convertBinaryStringToString(x));
        //char a = h.toAscii("10111011000100010101101111");
    }

}
