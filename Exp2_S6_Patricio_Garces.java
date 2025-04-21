/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exp2_s6_patricio_garces;

import java.util.Scanner;

/**
 *
 * @author pgarc
 */
public class Exp2_S6_Patricio_Garces {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Variables de usuario
        Scanner scanner = new Scanner(System.in);
        String funcion;         //Selección de obra  
        String sala;            //Sala de la función
        String fila1;           //Selección de fila
        String numero1;         //Selección de número
        String confirm;         //Confirma reserva
        String plus;            //Pago o reserva adicional
        boolean another=false;  //Lógica de asiento adicional
        boolean boleta=false;   //Generación de boleta
        String asiento1;        //Primer asiento reservado
        String asiento2;        //Asiento adicional reservado
        int total=0;            //Total a pagar
            
        
        
        //Información inicial
        System.out.println("Hola! Bienvenido a Teatro Moro");
        System.out.println("Por favor seleccione su funcion:");
        System.out.println("------------------------------------");
        System.out.println("1) Mr. Robot's Final Code");
        System.out.println("2) Avengers Doomsday");
        System.out.println("3) Mortal Kombat Armageddon");
        funcion=scanner.next();
        
        
        //Valida entrada
        while(!("1".equals(funcion)||"2".equals(funcion)||"3".equals(funcion))){
             System.out.println("Error. Seleccione un caracter valido");
             funcion=scanner.next();
        }
        
        //Homologación de selección para función y sala
        sala="";
        switch(funcion){
            case "1": funcion="Mr. Robot's Final Code";
                      sala="6"; break;
            case "2": funcion="Avengers Doomsday";
                      sala="5"; break;
            case "3": funcion="Mortal Kombat Armageddon"; 
                      sala="4"; break;
        }
        
        
        
        //Continuación de Información inicial
        System.out.println("------------------------------------");
        System.out.println("Ingrese la fila del asiento que desea reservar:");
        System.out.println("('a' a la 'h' en minusculas)");
        System.out.println("------------------------------------");
        
        //Valida y registra la selección de fila del usuario
        fila1 = scanner.next();
        while(!("a".equals(fila1) || "b".equals(fila1) ||"c".equals(fila1) || 
                "d".equals(fila1) || "e".equals(fila1) || "f".equals(fila1)||
                "g".equals(fila1) || "h".equals(fila1))) {
            System.out.println("Error. Seleccione una fila valida");
            fila1 = scanner.next();
        }
        
        System.out.println("------------------------------------");
        System.out.println("Ingrese el numero del asiento que desea reservar:");
        System.out.println("(1 al 8)");
        System.out.println("------------------------------------");
        
        //Valida y registra la selección de número del usuario
        numero1 = scanner.next();
        while(!("1".equals(numero1) || "2".equals(numero1) || "3".equals(numero1) ||
                "4".equals(numero1) || "5".equals(numero1) ||"6".equals(numero1) || 
                "7".equals(numero1) || "8".equals(numero1))) {
            System.out.println("Error. Seleccione un numero valido");
            numero1 = scanner.next();
        }
        
        System.out.println("------------------------------------");
        System.out.println("Ha seleccionado el asiento: "+numero1+fila1);
        System.out.println("Desea reservar (S/N)?");
        confirm = scanner.next();
        
        //Valida confirmación de reserva
        while (!("S".equals(confirm) || "s".equals(confirm) || "N".equals(confirm)
                || "n".equals(confirm))){
            System.out.println("Error. Seleccione un caracter valido");
            confirm=scanner.next();
        }
        
        
        //Confirmación de reserva
        if ("S".equals(confirm) || "s".equals(confirm)){
            System.out.println("------------------------------------");
            System.out.println("Se ha reservado exitosamente su asiento");
            asiento1=numero1+fila1;
            total=15000;
        }
        else{
            System.out.println("------------------------------------");
            System.out.println("Se ha cancelado la reserva");
            asiento1="";
        }
        
        
        //Compra o reserva adicional
        System.out.println("------------------------------------");
        System.out.println("Desea reservar otro asiento o pagar?");
        System.out.println("1)Reservar adicional");
        System.out.println("2)Pagar");
            plus=scanner.next();
        
            
        //Validación compra o reserva adicional 
        while(!("1".equals(plus)||"2".equals(plus))){
             System.out.println("Error. Seleccione un caracter valido");
             plus=scanner.next();
        }
        
        switch (plus){
            case "1": another=true;    //activa panel de reserva adicional
            break;
            case "2": boleta=true;     //activa generación de boleta
            break;
        }    
            
            
        //Reserva adicional
        if(another==true){
        System.out.println("------------------------------------");
        System.out.println("Ingrese la fila del asiento que desea reservar:");
        System.out.println("('a' a la 'h' en minusculas)");
        System.out.println("------------------------------------");
        
        fila1 = scanner.next();
        while(!("a".equals(fila1) || "b".equals(fila1) ||"c".equals(fila1) || 
                "d".equals(fila1) || "e".equals(fila1) || "f".equals(fila1)||
                "g".equals(fila1) || "h".equals(fila1))) {
            System.out.println("Error. Seleccione una fila valida");
            fila1 = scanner.next();
        }
        
        System.out.println("------------------------------------");
        System.out.println("Ingrese el numero del asiento que desea reservar:");
        System.out.println("(1 al 8)");
        System.out.println("------------------------------------");
        
        numero1 = scanner.next();
        while(!("1".equals(numero1) || "2".equals(numero1) || "3".equals(numero1) ||
                "4".equals(numero1) || "5".equals(numero1) ||"6".equals(numero1) || 
                "7".equals(numero1) || "8".equals(numero1))) {
            System.out.println("Error. Seleccione un numero valido");
            numero1 = scanner.next();
        }
        
        //Comprobación de disponibilidad de asientos
        asiento2=numero1+fila1;
        if(asiento2.equals(asiento1)){
            System.out.println("------------------------------------");
            System.out.println("Este asiento ya esta reservado");
            System.out.println("------------------------------------");
            asiento2="";
        }
  
        else{
        System.out.println("------------------------------------");
        System.out.println("Ha seleccionado el asiento: "+numero1+fila1);
        System.out.println("Desea reservar (S/N)?");
        confirm = scanner.next();
        
        //Valida confirmación de reserva adicional
        while (!("S".equals(confirm) || "s".equals(confirm) || "N".equals(confirm)
                || "n".equals(confirm))){
            System.out.println("Error. Seleccione un caracter valido");
            confirm=scanner.next();
        }
        
        //Confirmación de reserva adicional
        if ("S".equals(confirm) || "s".equals(confirm)){
            System.out.println("------------------------------------");
            System.out.println("Se ha reservado exitosamente su asiento");
            total=total+15000;
            asiento1=asiento1+ ", "+asiento2;
        }
        else{
            System.out.println("------------------------------------");
            System.out.println("Se ha cancelado la reserva adicional");
            asiento2="";
        }
        
        }
        
        //Compra o cancelación
        System.out.println("------------------------------------");
        System.out.println("Para continuar seleccione pagar o cancelar la operacion:");
        System.out.println("1)Pagar");
        System.out.println("2)Cancelar");
            plus=scanner.next();
        
            
        //Validación 
        while(!("1".equals(plus)||"2".equals(plus))){
             System.out.println("Error. Seleccione un caracter valido");
             plus=scanner.next();
        }
        
        //Boleta o cancelación
        switch (plus){
            case "1": boleta=true;
            break;
            case "2": boleta=false;
            System.out.println("------------------------------------");
            System.out.println("Se ha cancelado su reserva, hasta pronto");
            break;
        }  
        }
        
        
        
        
        
        
        //Generación de boleta
        if (boleta==true){
           System.out.println("------------------------------------");
           System.out.println("Asientos: "+asiento1);
           System.out.println("Total a pagar: $"+total);
           System.out.println("Funcion: "+funcion);
           System.out.println("Sala: "+sala);
           System.out.println("Que disfrute su eleccion, hasta pronto");
        
        }
        
    }
    
}
