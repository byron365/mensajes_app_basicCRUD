package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author byron
 */
public class Inicio {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int op = 0;
        
        do{
            //Menu para interactuar
            System.out.println("------My Chat-------");
            System.out.println("Ingresa una opción");
            System.out.println("1. Crear mensaje");
            System.out.println("2. Listar mensajes");
            System.out.println("3. Editar mensaje");
            System.out.println("4. Eliminar mensaje");
            System.out.println("5. Salir");
            
            //Leemos la opcion del usuario
            op = sc.nextInt();
            
            switch(op){
                case 1:{
                    MensajesService.crearMensaje();
                    break;
                }
                case 2:{
                    MensajesService.listarMensajes();
                    break;
                }
                case 3:{
                    MensajesService.editarMensaje();
                    break;
                }
                case 4:{
                    MensajesService.borrarMensaje();
                    break;
                }
                
            
            }  
        }while (op != 5);
    }
}