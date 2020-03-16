/*
  ID: ashay.s1
  LANG: JAVA
  TASK: closing
 */
import java.io.*;
import java.util.*;

public class closing {
	static boolean[] visited;
	static boolean[] closed;
	static boolean works;
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("closing.out"));
		int times = file.nextInt();
		int conn = file.nextInt();
		ArrayList<ArrayList<Integer>> neighbors = new ArrayList<>();
		for (int i = 0; i < times; i++) neighbors.add(new ArrayList<>());
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < conn; i++) {
			int a = file.nextInt(), b = file.nextInt();
			neighbors.get(a-1).add(b-1); neighbors.get(b-1).add(a-1);
			min = Math.min(min, Math.min(a-1, b-1));
		}
		visited = new boolean[times];
		works = true;
		bfs(min, neighbors);
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				works = false;
				break;
			}
		}
		System.out.println(works ? "YES" : "NO");
		out.println(works ? "YES" : "NO");
		closed = new boolean[times];
		for (int i = 0; i < times - 1; i++) {
			int remove = file.nextInt();
			closed[remove - 1] = true;
			works = true;
			visited = new boolean[times];
			int m = 0;
			for (int j = 0; j < times; j++) {
				if (!closed[j]) {
					m = j;
					break;
				}
			}
			
			bfs2(m, neighbors);
			for (int ij = 0; ij < visited.length; ij++) {
				if (!visited[ij] && !closed[ij]) {
					works = false;
					break;
				}
			}
			System.out.println(works ? "YES" : "NO");
			out.println(works ? "YES" : "NO");
		}
		out.close();
		
	}
	public static void bfs(int n, ArrayList<ArrayList<Integer>> t) {
		Queue<Integer> x = new LinkedList();
		x.add(n);
		while (!x.isEmpty()) {
			int cur = x.poll();
			if (!visited[cur]) {
				for (int i = 0; i < t.get(cur).size(); i++) {
					x.add(t.get(cur).get(i));
				}
				visited[cur] = true;
			}
		}
	}
	public static void bfs2(int n, ArrayList<ArrayList<Integer>> t) {
		Queue<Integer> x = new LinkedList();
		x.add(n);
		while (!x.isEmpty()) {
			int cur = x.poll();
			if (!visited[cur]) {
				for (int i = 0; i < t.get(cur).size(); i++) {
					if (!closed[t.get(cur).get(i)]) x.add(t.get(cur).get(i));
				}
				visited[cur] = true;
			}
		}
	}
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("closing.in"));
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
