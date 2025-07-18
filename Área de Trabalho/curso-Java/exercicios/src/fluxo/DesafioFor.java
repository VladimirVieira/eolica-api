package fluxo;

public class DesafioFor {
	public static void main(String[] args) {
		for(int i = 10; i>0; i-=2 ) {
			System.out.println(i);
		}
		
		for(String simbolo = "#";!simbolo.equals("######");simbolo+="#") {
			System.out.println(simbolo);
		}
		
	}

}
