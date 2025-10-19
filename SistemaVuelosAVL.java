package com.sebastian;

import java.util.Scanner;

// Clase que representa un Vuelo
class Vuelo {
    int numeroVuelo;
    String origen;
    String destino;
    String hora;
    String aerolinea;

    public Vuelo(int numeroVuelo, String origen, String destino, String hora, String aerolinea) {
        this.numeroVuelo = numeroVuelo;
        this.origen = origen;
        this.destino = destino;
        this.hora = hora;
        this.aerolinea = aerolinea;
    }

    @Override
    public String toString() {
        return "Vuelo " + numeroVuelo + " | " + origen + " -> " + destino + " | " + aerolinea + " | " + hora;
    }
}

// Nodo del árbol AVL
class Nodo {
    Vuelo vuelo;
    int altura;
    Nodo izq, der;

    public Nodo(Vuelo vuelo) {
        this.vuelo = vuelo;
        this.altura = 1;
    }
}

// Árbol AVL
class ArbolAVL {
    Nodo raiz;

    int altura(Nodo n) {
        return (n == null) ? 0 : n.altura;
    }

    int obtenerBalance(Nodo n) {
        return (n == null) ? 0 : altura(n.izq) - altura(n.der);
    }

    Nodo rotacionDerecha(Nodo y) {
        Nodo x = y.izq;
        Nodo T2 = x.der;
        x.der = y;
        y.izq = T2;
        y.altura = Math.max(altura(y.izq), altura(y.der)) + 1;
        x.altura = Math.max(altura(x.izq), altura(x.der)) + 1;
        return x;
    }

    Nodo rotacionIzquierda(Nodo x) {
        Nodo y = x.der;
        Nodo T2 = y.izq;
        y.izq = x;
        x.der = T2;
        x.altura = Math.max(altura(x.izq), altura(x.der)) + 1;
        y.altura = Math.max(altura(y.izq), altura(y.der)) + 1;
        return y;
    }

    Nodo insertar(Nodo nodo, Vuelo vuelo) {
        if (nodo == null)
            return new Nodo(vuelo);

        if (vuelo.numeroVuelo < nodo.vuelo.numeroVuelo)
            nodo.izq = insertar(nodo.izq, vuelo);
        else if (vuelo.numeroVuelo > nodo.vuelo.numeroVuelo)
            nodo.der = insertar(nodo.der, vuelo);
        else
            return nodo; // Ignorar duplicados

        nodo.altura = 1 + Math.max(altura(nodo.izq), altura(nodo.der));

        int balance = obtenerBalance(nodo);

        // Casos de rotación
        if (balance > 1 && vuelo.numeroVuelo < nodo.izq.vuelo.numeroVuelo)
            return rotacionDerecha(nodo);

        if (balance < -1 && vuelo.numeroVuelo > nodo.der.vuelo.numeroVuelo)
            return rotacionIzquierda(nodo);

        if (balance > 1 && vuelo.numeroVuelo > nodo.izq.vuelo.numeroVuelo) {
            nodo.izq = rotacionIzquierda(nodo.izq);
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && vuelo.numeroVuelo < nodo.der.vuelo.numeroVuelo) {
            nodo.der = rotacionDerecha(nodo.der);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    Nodo minValorNodo(Nodo nodo) {
        Nodo actual = nodo;
        while (actual.izq != null)
            actual = actual.izq;
        return actual;
    }

    Nodo eliminar(Nodo raiz, int numeroVuelo) {
        if (raiz == null)
            return raiz;

        if (numeroVuelo < raiz.vuelo.numeroVuelo)
            raiz.izq = eliminar(raiz.izq, numeroVuelo);
        else if (numeroVuelo > raiz.vuelo.numeroVuelo)
            raiz.der = eliminar(raiz.der, numeroVuelo);
        else {
            if ((raiz.izq == null) || (raiz.der == null)) {
                Nodo temp = (raiz.izq != null) ? raiz.izq : raiz.der;
                if (temp == null)
                    raiz = null;
                else
                    raiz = temp;
            } else {
                Nodo temp = minValorNodo(raiz.der);
                raiz.vuelo = temp.vuelo;
                raiz.der = eliminar(raiz.der, temp.vuelo.numeroVuelo);
            }
        }

        if (raiz == null)
            return raiz;

        raiz.altura = Math.max(altura(raiz.izq), altura(raiz.der)) + 1;

        int balance = obtenerBalance(raiz);

        if (balance > 1 && obtenerBalance(raiz.izq) >= 0)
            return rotacionDerecha(raiz);

        if (balance > 1 && obtenerBalance(raiz.izq) < 0) {
            raiz.izq = rotacionIzquierda(raiz.izq);
            return rotacionDerecha(raiz);
        }

        if (balance < -1 && obtenerBalance(raiz.der) <= 0)
            return rotacionIzquierda(raiz);

        if (balance < -1 && obtenerBalance(raiz.der) > 0) {
            raiz.der = rotacionDerecha(raiz.der);
            return rotacionIzquierda(raiz);
        }

        return raiz;
    }

    Nodo buscar(Nodo nodo, int numeroVuelo) {
        if (nodo == null || nodo.vuelo.numeroVuelo == numeroVuelo)
            return nodo;
        if (numeroVuelo < nodo.vuelo.numeroVuelo)
            return buscar(nodo.izq, numeroVuelo);
        return buscar(nodo.der, numeroVuelo);
    }

    void inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.izq);
            System.out.println(nodo.vuelo);
            inOrden(nodo.der);
        }
    }

    void preOrden(Nodo nodo) {
        if (nodo != null) {
            System.out.println(nodo.vuelo);
            preOrden(nodo.izq);
            preOrden(nodo.der);
        }
    }

    void postOrden(Nodo nodo) {
        if (nodo != null) {
            postOrden(nodo.izq);
            postOrden(nodo.der);
            System.out.println(nodo.vuelo);
        }
    }
}

// Programa principal
public class SistemaVuelosAVL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolAVL arbol = new ArbolAVL();
        int opcion;

        do {
            System.out.println("\n====== SISTEMA DE GESTIÓN DE VUELOS AVL ======");
            System.out.println("1. Registrar nuevo vuelo");
            System.out.println("2. Buscar vuelo");
            System.out.println("3. Eliminar vuelo");
            System.out.println("4. Mostrar vuelos (InOrden, PreOrden y PostOrden)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese número de vuelo: ");
                    int num = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese origen: ");
                    String origen = sc.nextLine();
                    System.out.print("Ingrese destino: ");
                    String destino = sc.nextLine();
                    System.out.print("Ingrese hora: ");
                    String hora = sc.nextLine();
                    System.out.print("Ingrese aerolínea: ");
                    String aerolinea = sc.nextLine();

                    Vuelo v = new Vuelo(num, origen, destino, hora, aerolinea);
                    arbol.raiz = arbol.insertar(arbol.raiz, v);
                    System.out.println(" Vuelo agregado correctamente.");
                    break;

                case 2:
                    System.out.print("Ingrese número de vuelo a buscar: ");
                    int buscar = sc.nextInt();
                    Nodo resultado = arbol.buscar(arbol.raiz, buscar);
                    if (resultado != null)
                        System.out.println(" Vuelo encontrado: " + resultado.vuelo);
                    else
                        System.out.println(" Vuelo no encontrado.");
                    break;

                case 3:
                    System.out.print("Ingrese número de vuelo a eliminar: ");
                    int eliminar = sc.nextInt();
                    arbol.raiz = arbol.eliminar(arbol.raiz, eliminar);
                    System.out.println("Vuelo eliminado correctamente (si existía).");
                    break;

                case 4:
                    System.out.println("\n=== RECORRIDOS DEL ÁRBOL AVL ===");
                    System.out.println("\n- InOrden (Ascendente):");
                    arbol.inOrden(arbol.raiz);
                    System.out.println("\n- PreOrden (Estructura del árbol):");
                    arbol.preOrden(arbol.raiz);
                    System.out.println("\n- PostOrden (Raíces al final):");
                    arbol.postOrden(arbol.raiz);
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
