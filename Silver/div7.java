/*
  ID: ashay.s1
  LANG: JAVA
  TASK: div7
 */
import java.io.*;
import java.util.*;

public class div7 {
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("div7.out"));
		int times = file.nextInt();
		int[] w= new int[times];
		int[] a =new int[7], b = new int[7];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.MAX_VALUE; b[i] = Integer.MAX_VALUE;
		}
		int tot = 0;
		for (int i = 0; i < w.length; i++) {
			int temp= file.nextInt();
			tot = (temp + tot) % 7;
			a[tot] = Math.min(i, a[tot]);
			b[tot] = i;
		}
		int max = 0;
		for (int i = 0; i < a.length; i++) max = Math.max(b[i] - a[i], max);
		System.out.println(max);
		out.println(max);
		out.close();
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("div7.in"));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}
