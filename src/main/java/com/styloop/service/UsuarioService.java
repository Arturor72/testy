package com.styloop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.styloop.common.TestYException;
import com.styloop.model.Usuario;
import com.styloop.persistence.dao.UsuarioDao;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioDao usuarioDao;
	
	public Usuario getUsuario(Integer id){
		Usuario usuario=new Usuario();
		List<Usuario> listUsuarios=usuarioDao.getUser(id);
		if(listUsuarios!=null&&!listUsuarios.isEmpty()&&listUsuarios.size()>0){
			usuario=listUsuarios.get(0);
		}else{
			usuario=null;
		}
		return usuario;
	}
	public Usuario getUsuarioByUserAndPassword(String user, String password){
		Usuario usuario=new Usuario();
		List<Usuario> listUsuarios=usuarioDao.getUserByUserAndPassword(user, password);
		if(listUsuarios!=null&&!listUsuarios.isEmpty()&&listUsuarios.size()>0){
			usuario=listUsuarios.get(0);
		}else{
			usuario=null;
		}
		return usuario;
	}
	public void insertUsuario(Usuario usuario) throws TestYException{
		usuarioDao.registerUser(usuario);
	}
	public Usuario getUsuario(String username, String email){
		Usuario usuario=null;
		if(username!=null){
			usuario=getUsuarioByUsername(username);
		}else if(email!=null){
			usuario=getUsuarioByEmail(email);
		}
		return usuario;
	}
	
	public Usuario getUsuarioByUsername(String username){
		Usuario usuario=new Usuario();
		List<Usuario> listUsuarios=usuarioDao.getUserByUsername(username);
		if(listUsuarios!=null&&!listUsuarios.isEmpty()&&listUsuarios.size()>0){
			usuario=listUsuarios.get(0);
		}else{
			usuario=null;
		}
		return usuario;
	}
	public Usuario getUsuarioByEmail(String email){
		Usuario usuario=new Usuario();
		List<Usuario> listUsuarios=usuarioDao.getUserByMail(email);
		if(listUsuarios!=null&&!listUsuarios.isEmpty()&&listUsuarios.size()>0){
			usuario=listUsuarios.get(0);
		}else{
			usuario=null;
		}
		return usuario;
		
	}
}
