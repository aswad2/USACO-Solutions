/*
  ID: ashay.s1
  LANG: JAVA
  TASK: shuffle
 */
import java.io.*;
import java.util.*;

public class shuffle {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("shuffle.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
		int times = Integer.parseInt(file.readLine());
		int[] s = new int[times];
		int[] id = new int[times];
		StringTokenizer st = new StringTokenizer(file.readLine());
		StringTokenizer st2 = new StringTokenizer(file.readLine());
		for (int i = 0; i < s.length; i++) {
			s[i] = Integer.parseInt(st.nextToken());
			id[i] = Integer.parseInt(st2.nextToken());
		}
		for (int i = 0; i < 3; i++) {
			int[] t = new int[times];
			for (int j = 0; j < s.length; j++) {
				int te = 0;
				for (int k = 0; k < s.length; k++) {
					if (j == s[k] - 1) te = k;
				}
				t[te] = id[j];
			}
			id = t;
		}
		for (int b : id) {
			out.println(b);
		}
		out.close();
		file.close();
	}
}
