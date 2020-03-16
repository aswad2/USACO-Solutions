/*
  ID: ashay.s1
  LANG: JAVA
  TASK: moobuzz
 */
import java.io.*;
import java.util.*;

public class moobuzz {
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("moobuzz.out"));
		long x = file.nextLong();
		int[] add = {1, 1, 2, 3, 1, 3, 2, 1};
		long rem = x % 8, div = x / 8;
		long fifteen = div * 15;
		long count = 0; int ind = 0;
		if (rem == 0) fifteen--;
		while (count < rem) {
			fifteen += (long)add[ind];
			ind++;
			count++;
		}
		System.out.println(fifteen);
		out.println(fifteen);
		out.close(); 
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("moobuzz.in"));
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
