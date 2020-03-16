/*
  ID: ashay.s1
  LANG: JAVA
  TASK: helpcross
 */
import java.io.*;
import java.util.*;


public class helpcross {
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("helpcross.out"));
		int c = file.nextInt(), n = file.nextInt();
		int[] a = new int[c]; ArrayList<Integer> g = new ArrayList();
		for (int i= 0; i< c; i++) {
			a[i]=  file.nextInt();
			g.add(a[i]);
		}
		Collections.sort(g);
		ArrayList<Pair> pairs = new ArrayList();
		for (int i = 0; i < n; i++) {
			int curX = file.nextInt(), curY = file.nextInt();
			pairs.add(new Pair(curX, curY));
		}
		boolean[] cur = new boolean[c];
		Collections.sort(pairs);
		int count = 0;
		for (int i = 0; i < c; i++) {
			int min = Integer.MAX_VALUE;
			int ind = -1;
			for (int j = 0; j < pairs.size(); j++) {
				if (g.get(i) >= pairs.get(j).x && g.get(i) <= pairs.get(j).y && g.get(i) - pairs.get(j).x < min && !cur[j]) {
					min = g.get(i) - pairs.get(j).x;
					ind = j;
				}
			}
			if (ind == -1) continue;
			count++;
			cur[ind] = true;
		}
		System.out.println(Math.max(count,count));
		out.println(Math.max(count,count));
		out.close();
	}
	static class Pair implements Comparable<Pair> {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int compareTo(Pair o) {
			if (o.x == x) return y - o.y;
			else return x - o.x;
		}
	}
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("helpcross.in"));
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
