package br.com.ufrn.pds1.projetopds1.exception;

public class ComunicacaoApiException extends RuntimeException {
	
	public ComunicacaoApiException(String mensagem) {
        super(mensagem);
    }

    public ComunicacaoApiException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
