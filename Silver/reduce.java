/*
  ID: ashay.s1
  LANG: JAVA
  TASK: reduce
 */
import java.io.*;
import java.util.*;

public class reduce {
	static Pairs temp;
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("reduce.out"));
		int times = file.nextInt();
		ArrayList<Coord> pairs = new ArrayList();
		for (int i = 0; i < times; i++) {
			pairs.add(new Coord(file.nextInt(), file.nextInt()));
		}
		Collections.sort(pairs);
		ArrayList<Pairs> p = new ArrayList();
		Coord cur = pairs.get(pairs.size() / 2);
		temp = new Pairs(cur.x, cur.y);
		for (Coord c : pairs) {
			p.add(new Pairs(c.x, c.y));
		}
		Collections.sort(p);
		int minx = Integer.MAX_VALUE, maxx = Integer.MIN_VALUE, maxy = Integer.MIN_VALUE, miny = Integer.MAX_VALUE;
		for (int i = 0; i< p.size() - 3; i++) {
			Pairs c = p.get(i);
			int xx = c.x; int yy = c.y;
			if (xx < minx) minx = xx;
			if (xx > maxx) maxx = xx;
			if (yy < miny) miny = yy;
			if (yy > maxy) maxy = yy;
		}
		System.out.println((maxx - minx) * (maxy - miny));
		out.println((maxx - minx) * (maxy - miny));
		out.close();
	}
	static class Coord implements Comparable<Coord> {
		int x, y;
		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int compareTo(Coord other) {
			if (other.x == x) return y - other.y;
			return x - other.x;
		}
		
	}
	static class Pairs implements Comparable<Pairs> {
		int x, y;
		public Pairs(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int compareTo(Pairs other) {
			return Double.compare(dist(x, y), dist(other.x, other.y)); 
		}
		public double dist( int a, int b) {
			return Math.sqrt(Math.pow(temp.x - a, 2) + Math.pow(temp.y - b, 2));
		}
	}
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("reduce.in"));
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
