/*
  ID: ashay.s1
  LANG: JAVA
  TASK: hps
 */
import java.io.*;
import java.util.*;

public class hps {
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("hps.out"));
		int times = file.nextInt();
		String[] a = new String[times];
		for (int i = 0; i < times; i++) {
			a[i] = file.next();
		}
		String[] temp = {"H", "P", "S"};
		int[][] mat = new int[3][times];
		for (int i = 0; i < 3; i++)  {
			for (int j = 0; j < times; j++) {
				if (j == 0) mat[i][j] = (a[j].equals(temp[i]) ? 1 : 0);
				else mat[i][j] = mat[i][j - 1] + (a[j].equals(temp[i]) ? 1 : 0);
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < times; j++) {
				int cur = mat[i][j];
				max = Math.max(Math.max(mat[0][times - 1] - mat[0][j] + cur, mat[1][times - 1] - mat[1][j] + cur), Math.max(mat[2][times - 1] - mat[2][j] + cur, max));
			}
		}
		System.out.println(max);
		out.println(max);
		out.close();
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("hps.in"));
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
