/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eft_s9_patricio_garces;

/**
 *
 * @author pgarc
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EFT_S9_Patricio_Garces {

  //Datos del cliente
    static class Cliente {    
           int id;
           String nombre;
           String tipo; //Según descuento: estudiante, 3ra edad, niño o mujer
           
           Cliente (int id, String nombre, String tipo){
               this.id=id;
               this.nombre=nombre;
               this.tipo=tipo;
           
           }
           
    }

    static List<Cliente> clientes = new ArrayList<>();
    
    
    //Datos del asiento a comprar
    static class Asiento {    
           int numero;
           String fila;
           boolean disponible;
           
           Asiento (int numero, String fila){
              this.numero=numero;
              this.fila=fila;
              this.disponible=true;
           }
    }    
    
    static List<Asiento> asientos = new ArrayList<>();
    
    public static void main(String[] args) {
        
        
        Scanner scan = new Scanner(System.in);
        inicializarAsientos();
        
        //Pantalla de inicio
        int seleccion;
            System.out.println("Bienvenido a Teatro Moro");
        do {
            System.out.println("------------------------------");
            System.out.println("Por favor seleccione:");
            System.out.println("------------------------------");
            System.out.println("1. Mostrar asientos disponibles");
            System.out.println("2. Agregar cliente");
            System.out.println("3. Vender entrada");
            System.out.println("0. Salir");
            System.out.println("------------------------------");
            seleccion = scan.nextInt();
        
            
        //Lógica de selección y validación    
        switch (seleccion){
            case 1: mostrarAsientos(); break;
            case 2: agregarCliente(scan); break;
            case 3: venderEntrada(scan); break;
            case 0: System.out.println("Hasta pronto"); break;
            default: 
                System.out.println("------------------------------");
                System.out.println("Seleccion invalida");            
                System.out.println("------------------------------");
            }
         }      
        while (seleccion != 0);
        scan.close();
    }
    
    
    //Inicializa sala
    static void inicializarAsientos() {
        String[] filas = {"A","B","C","D","E","F","G","H"};
        for (String fila : filas) {
            for (int i = 1; i <= 20; i++) {
                asientos.add(new Asiento(i, fila));
            }
        }
    }
    
    
    //Registro de datos del cliente
    static void agregarCliente(Scanner scan) {
        System.out.print("ID (rut sin guion): ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.print("Nombre: ");
        String nombre = scan.nextLine();
        System.out.print("Tipo de entrada:");
        System.out.print("Estudiante / Tercera edad / Nino / Mujer\n");
        String tipo = scan.nextLine();
        clientes.add(new Cliente(id, nombre, tipo));
        System.out.println("------------------------------");
        System.out.println("Cliente agregado exitosamente");
        System.out.println("------------------------------");
    }
    
    
    //Muestra los asientos disponibles
    static void mostrarAsientos() {
        System.out.println("Asientos disponibles:");
        for (Asiento a : asientos) {
            if (a.disponible) {
                System.out.println(a.numero +a.fila);
            }
        }
        System.out.println("------------------------------");
        System.out.println("Segun la fila su asiento se ubica en:");
        System.out.println("VIP: A");
        System.out.println("Palco: B y C");
        System.out.println("Platea baja: D y E");
        System.out.println("Platea alta: F y G");
        System.out.println("Galeria: H");
        System.out.println("------------------------------");
    }
    
    //Lógica de venta y validación de datos
    static void venderEntrada(Scanner scan) {
        System.out.print("ID cliente: ");
        int idCliente = scan.nextInt();
        Cliente cli = buscarCliente(idCliente);
        if (cli == null) {
            System.out.println("------------------------------");
            System.out.println("Cliente no encontrado");
            System.out.println("------------------------------");
            return;
        }
    
        
    //Muestra asientos disponibles y solicita ingreso de asiento a comprar
    mostrarAsientos();
        System.out.print("Numero de asiento: ");
        int numero = scan.nextInt();
        System.out.print("Fila: ");
        String fila = scan.next();
        
        //Disponibilidad y validación
        Asiento asiento = buscarAsiento(numero, fila);
        if (asiento == null || !asiento.disponible) {
            System.out.println("------------------------------");
            System.out.println("Asiento no disponible");
            System.out.println("------------------------------");
            return;
        }
        
        
        // Valor de la entrada general
        int precio = 20000; 
        //Descuentos
        if (cli.tipo.equalsIgnoreCase("Estudiante")) {
            precio *= 0.85; // 15% dcto
        } else if (cli.tipo.equalsIgnoreCase("Tercera edad")) {
            precio *= 0.75; // 25% dcto
        } 
          else if (cli.tipo.equalsIgnoreCase("Nino")) {
            precio *= 0.9; // 10% dcto
        } 
          else if (cli.tipo.equalsIgnoreCase("Mujer")) {
            precio *= 0.8; // 20% dcto
        } 
        
        asiento.disponible = false;
        
        
        //Ubicación según asiento comprado
        String ubi;
        ubi="";
        if(asiento.fila=="A"){
            ubi="(VIP)";
        }
        else if (asiento.fila=="B" || asiento.fila=="C"){
            ubi="(Palco)";
        }
        else if (asiento.fila=="C" || asiento.fila=="D"){
            ubi="(Platea baja)";
        }
        else if (asiento.fila=="D" || asiento.fila=="E"){
            ubi="(Platea alta)";
        }
        else if (asiento.fila=="H"){
            ubi="(Galeria)";
        }
        
        //Boleta
        System.out.println("----- BOLETA DE VENTA -----");
        System.out.println("Cliente: " + cli.nombre);
        System.out.println("Entrada: " + cli.tipo);
        System.out.println("Asiento: " + asiento.numero + asiento.fila +" "+ubi);
        System.out.println("Total: $" + precio);
        System.out.println("Disfrute su funcion, hasta pronto.");
        System.out.println("---------------------------");
    }
        
    
        //Busca cliente en BD
        static Cliente buscarCliente(int id) {
        for (Cliente c : clientes) {
            if (c.id == id) return c;
        }
        return null;
    }

        //Busca asiento en BD
        static Asiento buscarAsiento(int numero, String fila) {
        for (Asiento a : asientos) {
            if (a.fila.equalsIgnoreCase(fila) && a.numero == numero) {
                return a;
            }
        }
        return null;
    }
        
}