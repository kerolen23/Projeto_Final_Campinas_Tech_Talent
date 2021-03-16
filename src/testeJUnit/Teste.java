package testeJUnit;

import org.junit.Assert;
import org.junit.Test;

import application.Program;
import entities.Cadastro;

public class Teste {
	Cadastro ca = new Cadastro ("Kerolen", "kerolenkarina233@gmail.com", "123");
	Program pr = new Program();

		
	@Test 
	public void cadastro () {
		Assert.assertEquals("Kerolen",ca.getNome());
		Assert.assertEquals("kerolenkarina233@gmail.com",ca.getLogin());
		Assert.assertEquals("123",ca.getSenha());
		
	}
}
