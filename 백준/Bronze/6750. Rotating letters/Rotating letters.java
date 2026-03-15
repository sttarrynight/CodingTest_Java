import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = br.readLine().toCharArray();
        
        HashSet<Character> set = new HashSet<>();
        set.add('I');
        set.add('O');
        set.add('S');
        set.add('H');
        set.add('Z');
        set.add('X');
        set.add('N');
        
        boolean isSign = true;
        
        for(int i=0; i<arr.length; i++){
            if(!set.contains(arr[i])){
                isSign = false;
            }
        }
        
        System.out.println(isSign?"YES":"NO");
	}
}
