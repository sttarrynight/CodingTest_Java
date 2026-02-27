import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new TreeSet<>();
        while(N-->0){
            set.add(Integer.parseInt(st.nextToken()));
        }
        StringBuilder sb = new StringBuilder();
        for(int i : set){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}