/*
  ID: ashay.s1
  LANG: JAVA
  TASK: pails
 */
import java.io.*;
import java.util.*;

public class pails {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("pails.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
		StringTokenizer st = new StringTokenizer(file.readLine());
		int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), a = m, b = m;
		int p = m / x;
		int count = Integer.MIN_VALUE;
		for (int i = 0; i * x <= m; i++) {
			for (int j = 0; j * y <= m; j++) {
				if (i * x + j * y > count && i * x + j * y <= m) count = i * x + j * y; 
			}
		}
		System.out.println(count);
		out.println(count);
		out.close();
		file.close();
	}
}
