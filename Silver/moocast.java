/*
  ID: ashay.s1
  LANG: JAVA
  TASK: moocast
 */
import java.io.*;
import java.util.*;

public class moocast {
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("moocast.out"));
		int times = file.nextInt();
		int[] x = new int[times], y = new int[times], dist = new int[times];
		for (int i = 0; i < times; i++) {
			x[i] = file.nextInt();
			y[i] = file.nextInt();
			dist[i] = file.nextInt();
		}
		ArrayList<ArrayList<Integer>> ind = new ArrayList<>();
		for (int i= 0; i < times; i++) {
			ind.add(new ArrayList());
			for (int j = 0; j < times; j++) {
				if (distance(x[i], y[i], x[j], y[j]) <= dist[i]) {
					ind.get(i).add(j);
				}
			}
		}
		//for (ArrayList<Integer> w : ind) System.out.println(w);
		int max = 0;
		for (int i = 0; i < times; i++) {
			boolean[] visited = new boolean[times];
			Queue<Integer> q = new LinkedList();
			visited[i] = true;
			q.add(i);
			int count = 0;
			while (!q.isEmpty()) {
				//System.out.println(q);
				int temp = q.poll();
				//System.out.println(ind.get(temp));
				//System.out.println(temp);
				for (int item : ind.get(temp)) {
					if (visited[item]) continue;
					//System.out.println(item);
					count++;
					visited[item] = true;
					q.add(item);
				}
			}
			max = Math.max(count, max);
		}
		System.out.println(max + 1);
		out.println(max + 1);
		out.close();
	}
	public static double distance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("moocast.in"));
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
