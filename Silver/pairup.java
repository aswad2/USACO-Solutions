/*
  ID: ashay.s1
  LANG: JAVA
  TASK: pairup
 */
import java.io.*;
import java.util.*;

public class pairup {
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("pairup.out"));
		int times = file.nextInt();
		ArrayList<Pair> x = new ArrayList();
		for (int i = 0; i < times; i++) {
			int t = file.nextInt(), q = file.nextInt();
			x.add(new Pair(q, t));
		}
		Collections.sort(x);
		int i = 0, j = times - 1;
		//for (Pair c : x) System.out.println(c.x + " " + c.y);
		int min = Integer.MIN_VALUE;
		while (i <= j) {
			min = Math.max(min, x.get(i).x + x.get(j).x);
			int temp = Math.min(x.get(i).y, x.get(j).y);
			x.set(i, new Pair(x.get(i).x, x.get(i).y - temp));
			x.set(j, new Pair(x.get(j).x, x.get(j).y - temp));
			if (x.get(i).y <= 0) i++;
			if (x.get(j).y <= 0) j--;
		}
		System.out.println(min);
		out.println(min);
		out.close();
	}
	static class Pair implements Comparable<Pair> {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int compareTo(Pair o) {
			return x - o.x;
		}
	}
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("pairup.in"));
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
