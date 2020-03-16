/*
  ID: ashay.s1
  LANG: JAVA
  TASK: hoofball
 */
import java.io.*;
import java.util.*;

public class hoofball {
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("hoofball.out"));
		int times = file.nextInt();
		int[] x = new int[times];
		for (int i = 0; i< times; i++) {
			x[i] = file.nextInt();
		}
		Arrays.sort(x);
		int count = 0;
		int i = 0, j = x.length - 1;
		boolean[] visited = new boolean[x.length];
		while (i <= j) {
			if (i == j) {
				count++;
					break;
			}
			int c1 = howmany(i, 1, x, new boolean[x.length], 0);
			int c2 = howmany(j, -1, x, new boolean[x.length], 0);
			if (c1 > c2 && i + c1 > j - c2) {
				i += c1; j = i+1;
			}
			else if (c1 > c2) {
				i += c1; j -= c2;
			}
			else if (c2 > c1 && j - c2 < i + c1) {
				j -= c2;
				i = j - 1;
			}
			else if (c2 > c1) {
				i += c1; j -= c2;
			}
			else if (c1 == c2 && i + c1 > j - c2){
				i += c1; j = i + 1;
			}
			else if (c1 == c2 && i + c1 < j - c2) {
				j -= c2; i = j - 1;
			}
			else {
				j -= c2; i += c1;
			}
			count++;
		}
		System.out.println(count);
		out.println(count);
		out.close();
	}
	static int howmany(int i, int dir, int[] x, boolean[] visited, int count) {
		if (i < 0 || i > x.length - 1) return count;
		if (dir == 1) {
			if (visited[i]) return count;
			if (i == 0) {
				visited[i] = true;
				return howmany(i + 1, dir, x, visited, count + 1);
			}
			if (i == x.length- 1) {
				visited[i] = true;
				return howmany(i - 1, dir, x, visited, count + 1);
			}
			visited[i] = true;
			if (Math.abs(x[i] - x[i-1]) <= Math.abs(x[i] - x[i + 1])) {
				return howmany(i + 1, dir, x, visited, count + 1);
			}
			else return count;
		}
		else {
			if (visited[i]) return count;
			if (i == 0) {
				visited[i] = true;
				return howmany(i + 1, dir, x, visited, count + 1);
			}
			if (i == x.length - 1) {
				visited[i] = true;
				return howmany(i - 1, dir, x, visited, count + 1);
			}
			visited[i] = true;
			if (Math.abs(x[i] - x[i+1]) < Math.abs(x[i] - x[i-1])) {
				return howmany(i - 1, dir, x, visited, count + 1);
			}
			else return count;
		}
	}
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("hoofball.in"));
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
