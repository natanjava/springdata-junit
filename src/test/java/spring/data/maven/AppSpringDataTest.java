package spring.data.maven;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.data.maven.dao.InterfaceSpringDataUser;
import spring.data.maven.model.Telefone;
import spring.data.maven.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTest {
	
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser; // login, senha, nome, email, idade
	

	
	@Test
	public void testInsert() {
		//System.out.println("iniciou Spring com sucesso \n");
		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setLogin("jdev");
		usuarioSpringData.setSenha("xxxyyy");
		usuarioSpringData.setNome("Fabiano");
		usuarioSpringData.setEmail("alex@email.com");
		usuarioSpringData.setIdade("47");
		
		interfaceSpringDataUser.save(usuarioSpringData);
		
		System.out.println("Ultim registro salvo: "+usuarioSpringData.getNome());
		
		System.out.println("Numero de registros: " +interfaceSpringDataUser.count());
	}
	
	
	@Test
	public void testeconsulta() {
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);
		System.out.println(usuarioSpringData.get().getNome());
		System.out.println(usuarioSpringData.get().getEmail());
		System.out.println(usuarioSpringData.get().getIdade());
		System.out.println(usuarioSpringData.get().getLogin());
		
		for (Telefone telefone : usuarioSpringData.get().getTelefones()) {
			System.out.println(telefone.getNumero());
			System.out.println(telefone.getTipo());
		}
	}
	
	
	@Test
	public void testeConsultaTodos() {
		Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();
		
		for (UsuarioSpringData usuarioSpringData : lista) {
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println("---------------------------");
		}
	}
	
	@Test 
	public void testUpdate(){
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(3L);
		// faz um novo objeto do tipo UsuarioSpringData receber usuarioSpringData.get() pra economizar depois linha de codigo
		UsuarioSpringData data = usuarioSpringData.get();
		data.setNome("Vitor");
		interfaceSpringDataUser.save(data);
	}
	
	@Test
	public void testeDelete() {
		interfaceSpringDataUser.deleteById(4L);
		
		/* // outra maneira
		 Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(3L);
		interfaceSpringDataUser.delete(usuarioSpringData.get());
		*/
	}
	
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
	public void testeConsultaNomeParam() {
		UsuarioSpringData usuarioSpringData = interfaceSpringDataUser.buscaPorNomeParam("Ronaldo");
		
		System.out.println(usuarioSpringData.getNome());
		System.out.println(usuarioSpringData.getEmail());
		System.out.println(usuarioSpringData.getIdade());
		System.out.println(usuarioSpringData.getLogin());
	 	System.out.println("---------------------------");
	}
	
	
	@Test
	public void testeDeletePorNome() {
		interfaceSpringDataUser.deletePorNome("Pedro Luiz");
		System.out.println("Numero de registros: " +interfaceSpringDataUser.count());
	}
	
	@Test
	public void testeUpdateEmailPorNome() {
		interfaceSpringDataUser.updateEmailPorNome("ricardo1o@email.com","Ricardo");	
	}
	
	
	
	
}
