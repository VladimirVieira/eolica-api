package br.com.ufrn.pds1.projetopds1.exception;

public class DadosInvalidosException extends RuntimeException {
	
	public DadosInvalidosException (String mensagem) {
        super(mensagem);
    }

    public DadosInvalidosException (String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
