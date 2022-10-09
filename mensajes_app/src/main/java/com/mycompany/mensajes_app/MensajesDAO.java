/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author byron
 */
public class MensajesDAO {

    //DAO significa Data Access Object o objeto de acceso de datos
    public static void crearMensajeDB(Mensajes mensaje) {
        //Conectadose a la base de datos
        Conexion dbConnect = new Conexion();
        try ( Connection conexion = dbConnect.get_connection()) {
            //Insertando datos
            PreparedStatement ps = null;
            
            try{
                String query = "INSERT INTO mensajes(mensaje,autor_mensaje) VALUES(?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutorMensaje());
                
                ps.executeUpdate();
                System.out.println("Se creo exitosamente el mensaje");
            }catch(SQLException e){
                System.out.println("No se pudo crear el mensaje " + e);
            }
        } catch (SQLException e) {

        }
    }

    public static void leerMensajesDB() {
        Conexion dbConnect = new Conexion();
        try(Connection conexion = dbConnect.get_connection()){
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            //Solicitando datos
            String query = "SELECT * FROM mensajes;";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            
            //Imprimiendo mensaje
            while(rs.next()){
                System.out.println("---------------------------------------");
                System.out.println("Id: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                System.out.println("---------------------------------------");
            }
        }catch(SQLException e){
             System.out.println("No se pudo acceder a los mensajes " + e);
        }
    }

    public static void borrarMensajeDB(int idMensaje) {
        Conexion dbConnect = new Conexion();
        try(Connection conexion = dbConnect.get_connection()){
            PreparedStatement ps = null;
            
            try{
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, idMensaje);
                ps.executeUpdate();
                System.out.println("El mensaje fue borrado");
            }catch(SQLException e){
                System.out.println("No se pudo crear el mensaje " + e);
            }
            
        }catch(SQLException e){
             System.out.println("No se pudo borrar " + e);
        }
    }

    public static void actualizarMensaje(Mensajes mensaje, int IdMensaje) {
        Conexion dbConnect = new Conexion();
        try(Connection conexion = dbConnect.get_connection()){
            PreparedStatement ps = null;
            
            try{
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getIdMensaje());
                ps.executeUpdate();
                System.out.println("Se actualizo el mensaje");
            }catch(SQLException e){
                System.out.println("No se pudo modificar el mensaje " + e);
            }
        }catch(SQLException e){
            System.out.println("No se pudo modificar el mensaje " + e);
        }
    }
}
