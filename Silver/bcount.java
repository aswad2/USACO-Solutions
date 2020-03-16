/*
  ID: ashay.s1
  LANG: JAVA
  TASK: bcount
 */
import java.io.*;
import java.util.*;

public class bcount {
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("bcount.out"));
		int times = file.nextInt(), m = file.nextInt();
		int[] a = new int[times];
		int[] x =new int[m], y = new int[m];
		for (int i = 0; i < times; i++) a[i] = file.nextInt();
		for (int i = 0; i < m; i++) {
			x[i] = file.nextInt();
			y[i] = file.nextInt();
		}
		boolean[][] visited = new boolean[3][times];
		int[][] dp = new int[3][times];
		for (int i  = 0; i < times; i++) {
			if (i == 0) {
				if (a[i] == 1) {dp[0][i] = 1; visited[0][i] = true;}
				else if (a[i] == 2) {dp[1][i] = 1; visited[1][i] = true;}
				else {dp[2][i] = 1; visited[2][i] = true;}
			}
			else {
				if (a[i] == 1) {dp[0][i] = dp[0][i-1] + 1; visited[0][i] = true;}
				else dp[0][i] = dp[0][i-1];
				if (a[i] == 2) {dp[1][i] = dp[1][i-1] + 1; visited[1][i] = true;}
				else dp[1][i] = dp[1][i-1];
				if (a[i] == 3) {dp[2][i] = dp[2][i-1] + 1; visited[2][i] = true;}
				else dp[2][i] = dp[2][i-1];
			}
		}
		for (int i = 0; i < m; i++) {
			int curX = x[i] - 1, curY = y[i] - 1;
			int count1 = dp[0][curY] - dp[0][curX] + (visited[0][curX] ? 1 : 0);
			int count2 = dp[1][curY] - dp[1][curX] + (visited[1][curX] ? 1 : 0);
			int count3 = dp[2][curY] - dp[2][curX] + (visited[2][curX] ? 1 : 0);
			System.out.println(count1 + " " +  count2 + " " + count3);
			out.println(count1 + " " +  count2 + " " + count3);
		}
		out.close();
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("bcount.in"));
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
