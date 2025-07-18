package fundamentos;

public class NotacaoPonto {
	public static void main(String[] args) {
		String s = "Bom dia X";
		s = s.replace("X", "Senhora"); //substitui X por Senhora
		s = s.toUpperCase(); //Tudo fica maiusculo
		s = s.concat("!!!"); //concatena as !!!
		
		System.out.println(s);
		
		String x = "Leo".toLowerCase();//modifica o nome Leo para leo
		System.out.println(x);
		
		String y = "Bom dia X".replace("X","Gui").toUpperCase().concat("!!!");
		System.out.println(y);
				
			
	}

}
