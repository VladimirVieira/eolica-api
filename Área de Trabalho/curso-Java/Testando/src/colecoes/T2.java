package colecoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int somatorio = 0;
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        
        
        int val = 0;
        int val2 = 0;
        
        while(true){
            val = Integer.parseInt(br.readLine());
            
            if(val>0){
                break;
            }
        }
        
        while(true){
            val2 = Integer.parseInt(br.readLine());
            
            if(val2>0){
                break;
            }
        }
        
        for(int i=0;i<val2;i++){
            somatorio+=(val+i);
        }
        
        System.out.println(somatorio);
	}

}
