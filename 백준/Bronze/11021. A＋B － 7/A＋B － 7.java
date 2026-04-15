import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int i=1;
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            sb.append("Case #").append(i++).append(": ").append(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())).append("\n");
        }
        System.out.print(sb);
    }
}