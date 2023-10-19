package spring.data.maven;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.data.maven.dao.InterfaceSpringDataUser;
import spring.data.maven.dao.InterfaceTelefone;
import spring.data.maven.model.Telefone;
import spring.data.maven.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTest2 {
	
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser; // login, senha, nome, email, idade
	
	@Autowired
	private InterfaceTelefone interfaceTelefone;
	
	
	@Test
	public void testeConsultaNome() {
		List<UsuarioSpringData> list = interfaceSpringDataUser.buscaPorNome("naldo");
		
		for (UsuarioSpringData usuarioSpringData : list) {
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println("---------------------------");
		}
	}
	
	
	
	@Test
	public void testeInsertTelefone () {
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);
		
		Telefone telefone = new Telefone ();
		telefone.setTipo("Escritorio");
		telefone.setNumero("4554545");
		telefone.setUsuarioSpringData(usuarioSpringData.get());
		
		interfaceTelefone.save(telefone);
	}
	
	
	
	
	
	
}
