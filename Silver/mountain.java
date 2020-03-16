/*
  ID: ashay.s1
  LANG: JAVA
  TASK: mountain
 */
import java.io.*;
import java.util.*;

public class mountain {
	static class Pair implements Comparable<Pair> {
		long x1, x2;
		public Pair(long a, long b) {
			x1 = a; x2 = b;
		}
		public int compareTo(Pair o) {
			return Long.compare((o.x2 - o.x1), (x2 - x1));
		}
	}
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("mountains.out"));
		int times = file.nextInt();
		ArrayList<Pair> x = new ArrayList<>();
		for (int asdf = 0; asdf < times; asdf++) {
			long one = file.nextLong(), two = file.nextLong();
			x.add(new Pair(one - two, one + two));
		}
		Collections.sort(x);
		//long maxx = x.get(0).x2, minx = x.get(0).x1;
		int obs = 0;
		for (int i = 0; i < x.size(); i++) {
			long a = x.get(i).x1, b = x.get(i).x2;
			//System.out.println(a + " " + b);
			int c = 0;
			while (c < i && (a < x.get(c).x1 || b > x.get(c).x2)) {
				c++;
			}
			if (c != i) obs++;
		}
		System.out.println(times - obs);
		out.println(times - obs);
		out.close();
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("mountains.in"));
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
