package com.styloop.persistence.dao;

import java.util.List;

import com.styloop.common.TestYException;
import com.styloop.model.Usuario;

public interface UsuarioDao {
	public List<Usuario> getUser(Integer id);
	public List<Usuario> getUserByUserAndPassword(String user, String password);
	public void registerUser(Usuario usuario) throws TestYException;
	public List<Usuario> getUserByUsername(String username);
	public List<Usuario> getUserByMail(String email);
}
