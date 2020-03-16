/*
  ID: ashay.s1
  LANG: JAVA
  TASK: snowboots
 */
import java.io.*;
import java.util.*;

public class snowboots {
	static int[] x, y, z;
	static int min;
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("snowboots.out"));
		int tiles = file.nextInt(), boots = file.nextInt();
		x = new int[tiles];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < x.length; i++) x[i] = file.nextInt();
		y = new int[boots]; z = new int[boots];
		for (int i = 0; i < boots; i++) {
			int depth = file.nextInt(), steps = file.nextInt();
			y[i] = depth;
			z[i] = steps;
		}
		int[] dp = new int[x.length];
		for (int i = 1;i < x.length; i++) dp[i] = Integer.MAX_VALUE;
		
		for (int i = 0; i < y.length; i++) {
			for (int k = 0; k < x.length; k++) {
				if (dp[k] < Integer.MAX_VALUE && y[i] >= x[k]) {
					for (int j = 1; j <= z[i] && k + j < x.length; j++) {
						if (x[k + j] <= y[i]) {
							dp[k + j] = Math.min(dp[k+j], i);
						}
					}
				}
				//System.out.println(Arrays.toString(dp));
			}
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[dp.length - 1]);
		out.println(dp[dp.length - 1]);
//		dfs(0, 0, 0);
//		System.out.println(min);
//		out.println(min);
		out.close();
	}
	static void dfs(int pos, int index, int discarded) {
		if (pos < x.length && index < y.length) {
			if (pos == x.length - 1) {
				min = Math.min(discarded, min);
				return;
			}
			if (y[index] >= x[pos]) {
				for (int i = 1; i <= z[index]; i++) {
					dfs(pos + i, index, discarded);
				}
				dfs(pos, index + 1, discarded + 1);
			}
		}
	}
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("snowboots.in"));
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
