package exercicio3;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ValidacaoIgualdade {
	@Test
	public void validacaoIgualdade_Sucesso(){
		String resultadoObtido = "Registro salvo com sucesso!";
		assertEquals("Registro salvo com sucesso!", resultadoObtido);
	}
	
	@Test
	public void validacaoIgualdade_Falha(){
		String resultadoObtido = "Registro excluido com sucesso!";
		assertEquals("Registro salvo com sucesso", resultadoObtido);
	}
	
	
//		@Before
//		public void preCondicao(){
//			System.out.println("Executou a pre condicao");
//		}
//		@Test
//		public void exibicaoPrePosCondicao(){
//			System.out.println("Executou o teste");
//		}
//		
//		@After
//		public void posCondicao(){
//			System.out.println("Executou a pos condicao");
//		}
	
}
