package colecoes;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Mapa {
	public static void main(String[] args) {
		Map<Integer, String> usuario = new HashMap<Integer, String>();
		
		//adicionando elementos, se o código for o mesmo, ele substitui o elemento
		usuario.put(1, "Roberto");
		usuario.put(1, "Ricardo");
		usuario.put(2, "Rafaela");
		usuario.put(3, "Rebeca");
		
		System.out.println(usuario.size());
		System.out.println(usuario.isEmpty());
		
		//retornando as chaves dos elementos, não mantem de forma ordenada
		System.out.println(usuario.keySet());
		
		//retornando os valores
		System.out.println(usuario.values());
		
		//obtendo chave-valor
		System.out.println(usuario.entrySet());
		
		//verificando se um elemento existe
		System.out.println(usuario.containsKey(2));
		System.out.println(usuario.containsValue("Rebeca"));
		
		System.out.println(usuario.get(1));
		
		
		//percorre as chaves
		for(int chave: usuario.keySet()) {
			System.out.println(chave);
		}
		
		//percorre os valores 
		for(String valor: usuario.values()) {
			System.out.println(valor);
		}
		
		for(Entry<Integer, String> registro: usuario.entrySet()) {
			System.out.print(registro.getKey() + " >>>> ");
			System.out.println(registro.getValue());
		}
		
	}

}
