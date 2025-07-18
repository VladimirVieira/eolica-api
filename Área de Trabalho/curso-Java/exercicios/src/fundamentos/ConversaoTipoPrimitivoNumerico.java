package fundamentos;

public class ConversaoTipoPrimitivoNumerico {
	public static void main(String[] args) {
		double a = 1; //conversão de implicita do tipo int para double
		System.out.println(a);
		
		float b = (float) 1.0; //conversão explicita, de double para float
		System.out.println(b);
		
		int c = 340;
		byte d = (byte) c; //explícita (cast)
		System.out.println(d);
		
		double e = 1.9999999;
		int f = (int) e; //explícita (cast)
		System.out.println(f);
	}

}
