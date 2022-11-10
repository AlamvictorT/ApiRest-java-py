/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rest.dao;

import com.rest.domain.Usuario;
import com.rest.interfaces.ImplUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALAM
 */
public class CrudUsuario implements ImplUsuario {

    String base = "cursojava";
    Conexion con = null;
    Connection cone = null;
    ResultSet rs = null;
    java.sql.Statement st = null;

    public CrudUsuario() {
         con = new Conexion();
    }
    
    
    @Override
    public String create(Usuario obj) {
        var msg = "";
        try {
            var sql = "insert into usuarios(usuario, password, nombres, "
                    + "apellidos, correo,estado)"
                    + "values(?,?,?,?,?,?)";
            cone = con.conectar(base);
            PreparedStatement smt = cone.prepareStatement(sql);
            smt.setString(1, obj.getUsuario());
            smt.setString(2, obj.getPassword());
            smt.setString(3, obj.getNombre());
            smt.setString(4, obj.getApellido());
            smt.setString(5, obj.getCorreo());
            smt.setString(6, obj.getEstado());
            var filas = smt.executeUpdate();
            cone.close();
            if (filas > 0) {
                msg = "Sus datos han sido guardados con exito!";
            }
        } catch (SQLException ex) {
            msg = "" + ex;
            // Logger.getLogger(CrudDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;

    }

    @Override
    public String update(Usuario obj) {
            var msg = "";
        try {
            var script = "update usuarios set password =?, nombres=?, apellidos=?, correo=? "
                    + " where usuario = ? ";
            cone = con.conectar(base);
            PreparedStatement prd = cone.prepareStatement(script);
            prd.setString(1, obj.getPassword());
            prd.setString(2, obj.getNombre());
            prd.setString(3, obj.getApellido());
            prd.setString(4, obj.getCorreo());
            prd.setString(5, obj.getUsuario());
            var rows = prd.executeUpdate();
            cone.close();
            if (rows > 0) {
                msg = "Los datos han sido actualizados!";
            } else {
                msg = "Los datos no han sido actualizados!";
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;}

    @Override
    public String delete(String user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario getOne(String user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuario> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario getLogin(String user, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
