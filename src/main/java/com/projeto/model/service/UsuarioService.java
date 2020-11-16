package com.projeto.model.service;

import javax.persistence.EntityTransaction;
import com.projeto.model.dao.UsuarioDao;
import com.projeto.model.models.Usuario;

public class UsuarioService extends ConexaoBancoService {
	
	private UsuarioDao usuarioDao;
	
	public UsuarioService() {
		this.usuarioDao = new UsuarioDao(this.getEntityManager());
	}

	public Integer save(Usuario usuario) {
		
		EntityTransaction trx = this.getTransaction();
		
		try {
			
			trx.begin();
			this.getUsuarioDao().save(usuario);
			trx.commit();
			
		} catch(Exception ex) {
			ex.printStackTrace();
			if(trx.isActive()) {
				trx.rollback();
			}
		} finally {
			this.close();
		}
		
		return 0;
	}	

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}
}
