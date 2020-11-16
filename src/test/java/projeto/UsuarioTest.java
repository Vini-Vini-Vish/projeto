package projeto;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.projeto.model.models.Usuario;
import com.projeto.model.service.UsuarioService;

public class UsuarioTest {
	
	@Test
	public void salvarUsuarioBancoTest() {
		
		Usuario usuario = new Usuario();
		
		//usuario.setId(1);
		usuario.setUsername("Vini Vini Vish");
		usuario.setPassword("123456");
		usuario.setEmail("vini@hotmail.com");
		usuario.setAtivo(false);
		usuario.setAdmin(false);
		
		UsuarioService usuarioService = new UsuarioService();
		
		usuarioService.save(usuario);

		System.out.println("Gravando Registro do Usuario no Banco de dados");
		assertTrue(true);
	}
}
