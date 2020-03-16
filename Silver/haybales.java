/*
  ID: ashay.s1
  LANG: JAVA
  TASK: haybales
 */
import java.io.*;
import java.util.*;

public class haybales {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("haybales.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		StringTokenizer st = new StringTokenizer(file.readLine());
		int hay = Integer.parseInt(st.nextToken());
		int queries = Integer.parseInt(st.nextToken());
		int[] q = new int[hay];
		StringTokenizer st2 = new StringTokenizer(file.readLine());
		for (int i = 0; i < hay; i++)
			q[i] = Integer.parseInt(st2.nextToken());
		Arrays.sort(q);
		for (int i = 0; i < queries; i++) {
			StringTokenizer t = new StringTokenizer(file.readLine());
			int count = 0;
			int one = Integer.parseInt(t.nextToken()), two = Integer.parseInt(t.nextToken());
			int b = Arrays.binarySearch(q, one), c = Arrays.binarySearch(q, two);
			boolean d = b >= 0, e = c >= 0;
			if (!d) b = ~b; if (!e) c = ~c;
			if (!e) c--;
			System.out.println(c - b + 1);
			out.println(c - b + 1);
		}
		out.close();
		file.close();
	}
}