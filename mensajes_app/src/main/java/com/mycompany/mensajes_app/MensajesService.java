/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author byron
 */
public class MensajesService {
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa un mensaje");
        String msg = sc.nextLine();
        
        System.out.println("Autor del mensaje?");
        String autor = sc.nextLine();
        
        Mensajes mensaje = new Mensajes();
        mensaje.setMensaje(msg);
        mensaje.setAutorMensaje(autor);
        
        MensajesDAO.crearMensajeDB(mensaje);
    }
    
    public static void listarMensajes(){
        MensajesDAO.leerMensajesDB();
    }
    
    public static void borrarMensaje(){
        Scanner sc  = new Scanner(System.in);
        System.out.println("Ingresa el id del mensaje a borrar");
        int idMensaje = sc.nextInt();
        MensajesDAO.borrarMensajeDB(idMensaje);
    }
    
    public static void editarMensaje(){
        Scanner sc  = new Scanner(System.in);
        
        System.out.println("Ingresa el nuevo mensaje");
        String msg = sc.nextLine();
        
        System.out.println("Ingresa el id del mensaje a modificar");
        int idMensaje = sc.nextInt();
        
        Mensajes update = new Mensajes();
        update.setIdMensaje(idMensaje);
        update.setMensaje(msg);
        
        MensajesDAO.actualizarMensaje(update, idMensaje);
        
    }
}
