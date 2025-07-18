package exercicio6;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import exercicio1.MeuPrimeiroTeste;
import exercicio2.ValidacaoVerdadeiroFalso;
import exercicio3.ValidacaoIgualdade;
import exercicio4.PreEPosCondicoes;
import exercicio5.PreEPosCondicaoDaClasse;

@RunWith(Suite.class)
@SuiteClasses({
	MeuPrimeiroTeste.class,
	ValidacaoVerdadeiroFalso.class,
	ValidacaoIgualdade.class,
	PreEPosCondicoes.class,
	PreEPosCondicaoDaClasse.class
	
	
})
public class SuiteDeTeste {

}
