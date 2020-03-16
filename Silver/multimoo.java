
/*
  ID: ashay.s1
  LANG: JAVA
  TASK: multimoo
 */
import java.io.*;
import java.util.*;

public class multimoo {
	static int[][] dp;
	static boolean[][] visited, visited2;
	static int max, max2;

	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("multimoo.out"));
		int times = file.nextInt();
		dp = new int[times][times];
		max = 0;
		for (int i = 0; i < times; i++) {
			for (int j = 0; j < times; j++) {
				dp[i][j] = file.nextInt();
				Queue<Integer> x = new LinkedList(), y = new LinkedList();
				visited = new boolean[times][times];
				x.add(i);
				y.add(j);
				bfs(dp[i][j], x, y);
			}
		}
		System.out.println(max);
		out.println(max);
		max2 = 0;
		for (int i = 0; i < times; i++) {
			for (int j = 0; j < times; j++) {
				int cur = dp[i][j];
				visited2 = new boolean[times][times];
				if (i + 1 >= 0 && i + 1 < dp.length && j >= 0 && j < dp.length) {
					Queue<Integer> x = new LinkedList<>(), y = new LinkedList();
					x.add(i); y.add(j);
					bfs2(cur, dp[i+1][j], x, y);
				}
				if (i - 1 >= 0 && i - 1 < dp.length && j >= 0 && j < dp.length) {
					Queue<Integer> x = new LinkedList<>(), y = new LinkedList();
					x.add(i); y.add(j);
					bfs2(cur, dp[i-1][j], x, y);
				}
				if (i >= 0 && i < dp.length && j + 1 >= 0 && j + 1 < dp.length) {
					Queue<Integer> x = new LinkedList<>(), y = new LinkedList();
					x.add(i); y.add(j);
					bfs2(cur, dp[i][j+1], x, y);
				}
				if (i >= 0 && i < dp.length && j - 1 >= 0 && j - 1 < dp.length) {
					Queue<Integer> x = new LinkedList<>(), y = new LinkedList();
					x.add(i); y.add(j);
					bfs2(cur, dp[i][j-1], x, y);
				}
			}
		}
		System.out.println(max2);
		out.println(max2);
		out.close();
	}

	static void bfs(int cur, Queue<Integer> x, Queue<Integer> y) {
		int count = 0;
		while (!x.isEmpty()) {
			int a = x.poll(), b = y.poll();
			if (a >= 0 && a < dp.length && b >= 0 && b < dp.length && dp[a][b] == cur && !visited[a][b]) {
				x.add(a + 1);
				y.add(b);
				x.add(a - 1);
				y.add(b);
				x.add(a);
				y.add(b + 1);
				x.add(a);
				y.add(b - 1);
				visited[a][b] = true;
				count++;
			}
		}
		max = Math.max(count, max);
	}

	static void bfs2(int cur, int cur2, Queue<Integer> x, Queue<Integer> y) {
		int count = 0;
		while (!x.isEmpty()) {
			int a = x.poll(), b = y.poll();
			if (a >= 0 && a < dp.length && b >= 0 && b < dp.length && (dp[a][b] == cur || dp[a][b] == cur2)
					&& !visited2[a][b]) {
				x.add(a + 1);
				y.add(b);
				x.add(a - 1);
				y.add(b);
				x.add(a);
				y.add(b + 1);
				x.add(a);
				y.add(b - 1);
				visited2[a][b] = true;
				count++;
			}
		}
		max2 = Math.max(count, max2);
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("multimoo.in"));
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
