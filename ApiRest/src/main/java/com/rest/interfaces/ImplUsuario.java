/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rest.interfaces;

import com.rest.domain.Usuario;
import java.util.List;

/**
 *
 * @author ALAM
 */
public interface ImplUsuario {
    public String create(Usuario obj);
    public String update(Usuario obj);
    public String delete(String user);
    public Usuario getOne(String user);
    public List<Usuario> getAll();
    public Usuario getLogin(String user, String password);
    
}
