package testy;

import org.springframework.beans.factory.annotation.Autowired;

import com.styloop.persistence.dao.UsuarioDao;

public class TestUsuario {
	@Autowired
	static UsuarioDao usuarioDao;
	
	public static void main(String[] args) {
		
		usuarioDao.getUser(1);
	}
}
