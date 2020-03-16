/*
  ID: ashay.s1
  LANG: JAVA
  TASK: mootube
 */
import java.io.*;
import java.util.*;

public class mootube {
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("mootube.out"));
		int times = file.nextInt(), q = file.nextInt();
		ArrayList<ArrayList<Pair>> x = new ArrayList();
		for (int i = 0; i < times; i++) x.add(new ArrayList());
		for (int i = 0; i < times - 1; i++) {
			int one = file.nextInt() - 1, two = file.nextInt() - 1, weight = file.nextInt();
			x.get(one).add(new Pair(two, weight));
			x.get(two).add(new Pair(one, weight));
		}
		for (int i = 0; i < q; i++) {
			int k = file.nextInt(), v = file.nextInt() - 1;
			boolean[] visited = new boolean[times];
			int count = 0;
			Queue<Integer> pairs = new LinkedList<>();
			pairs.add(v);
			visited[v] = true;
			while (!pairs.isEmpty()) {
				int cur = pairs.poll();
				ArrayList<Pair> c = x.get(cur);
				for (int asdf = 0; asdf < c.size(); asdf++) {
					int temp = c.get(asdf).other, w = c.get(asdf).weight;
					if (!visited[temp] && w >= k) {
						pairs.add(temp);
						count++;
					}
					visited[temp] = true;
				}
			}
			System.out.println(count);
			out.println(count);
		}
		out.close();
	}
	static class Pair {
		int other, weight;
		public Pair(int other, int weight) {
			this.other = other;
			this.weight = weight;
		}
	}
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("mootube.in"));
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
