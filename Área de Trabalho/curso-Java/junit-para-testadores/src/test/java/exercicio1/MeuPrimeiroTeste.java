package exercicio1;


import org.junit.Test;

public class MeuPrimeiroTeste {
	
	@Test
	public void teste1(){
		System.out.println("Teste1 executado."); 
	}
	

	@Test
	public void teste2(){
		System.out.println("Teste2 executado");
	}
	
	public void naoEUmTeste() {
		System.out.println("Esta mensagem não deve aparecer");
	}
	
	//@Test
	//public void testeValidacaoVerdadeiro() {
	//	boolean campoEstaPresente = true;
	//	assertTrue(campoEstaPresente); verifica se é true ou false
	//}
	
	//@Test
	//public void testeValidacaoFalse() {
	//	boolean campoEstaPresente = true;
	//	assertFalse("Campo não está presente", campoEstaPresente); //O teste compara e falha
	//}
}
