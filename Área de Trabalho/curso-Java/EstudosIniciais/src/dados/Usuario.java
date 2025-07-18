package dados;

public class Usuario {
	String nome;
	String email;
	
	public boolean equals(Object objeto) {
		
		if(objeto instanceof Usuario) {
			Usuario outro = (Usuario) objeto;
			
			boolean nomeIgual = outro.nome.equals(this.nome);
			boolean emailIgual = outro.email.equals(this.email);
			
			return nomeIgual && emailIgual;
			
			
		}else {
			return false;
		}
		
		
		//Usuario outro = (Usuario) objeto;
		
		//		boolean nomeIgual = outro.nome == this.nome;
		//		boolean emailIgual = outro.email == this.email;
		
		//		boolean nomeIgual = outro.nome.equals(this.nome);
		//		boolean emailIgual = outro.email.equals(this.email);
		
		//		return nomeIgual && emailIgual; 
		
		//		if(objeto instanceof Usuario) {
		//			Usuario outro = (Usuario) objeto;
		//			
		//			return super.equals(objeto);
		//		}
		//		
		//		return false;
	}

}
