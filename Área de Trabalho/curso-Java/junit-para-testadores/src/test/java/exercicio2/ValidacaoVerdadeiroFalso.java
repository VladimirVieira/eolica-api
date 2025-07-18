package exercicio2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidacaoVerdadeiroFalso {
	@Test
	public void valicadacaoVerdadeiro_Sucesso() {
		boolean campoEstaPresente = true;
		assertTrue(campoEstaPresente);
	}
	
	@Test
	public void validacaoVerdadeiro_Falha() {
		boolean campoEstaPresente = true;
		assertFalse("O campo não está presente presente", campoEstaPresente);
	}
	
	//@Test
	//public void validacaoIgualdade_Falha() {
	//	String resultadoObtido = "Registro Salvo com sucesso!";
	//	assertEquals("Registro excluido com sucesso", resultadoObtido);
	//}
	

}
