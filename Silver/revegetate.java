/*
  ID: ashay.s1
  LANG: JAVA
  TASK: revegetate
 */
import java.io.*;
import java.util.*;

public class revegetate {
	static boolean[] visited;
	static ArrayList<Integer> values;
	static boolean works;
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("revegetate.out"));
		int n = file.nextInt(), times = file.nextInt();
		ArrayList<ArrayList<Pair>> x = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			x.add(new ArrayList<>());
		}
		values = new ArrayList();
		for (int i = 0; i < n; i++) values.add(-1);
		visited = new boolean[n];
		works = true;
		HashSet<Integer> test =new HashSet();
		for (int i = 0; i < times; i++) {
			char c = file.next().charAt(0); int aa = file.nextInt(), bb = file.nextInt();
			test.add(aa); test.add(bb);
			x.get(aa-1).add(new Pair(bb-1, c));
			x.get(bb-1).add(new Pair(aa-1, c));
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (x.get(i).size() != 0 && !visited[i]) {
				Queue<Integer> a = new LinkedList();
				a.add(i);
				count++;
				values.set(i, 1);
				bfs(a, x);
			}
		}
		if (works) {
			String s = "1";
			for (int i = 0; i < count; i++) s += "0";
			for (int i = 0; i < n; i++) {
				if (x.get(i).size() == 0) s += "0";
			}
			System.out.println(s);
			out.println(s);
		}
		else {
			System.out.println(0);
			out.println(0);
		}
		out.close();
	}
	public static void bfs(Queue<Integer> a, ArrayList<ArrayList<Pair>> x) {
		while (!a.isEmpty()) {
			int p = a.poll();
			visited[p] = true;
			for (int i = 0; i< x.get(p).size(); i++) {
				Pair cur = x.get(p).get(i);
				if (visited[x.get(p).get(i).con]) continue;
				a.add(x.get(p).get(i).con);
				if (values.get(x.get(p).get(i).con) == -1) {
					if (x.get(p).get(i).comp == 'S') {
						values.set(x.get(p).get(i).con, values.get(p));
					}
					else {
						values.set(x.get(p).get(i).con, values.get(p) ^ 1);
					}
				}
				else {
					if (x.get(p).get(i).comp == 'S' && values.get(p) != values.get(x.get(p).get(i).con)) {
						works =false;
						break;
					}
					else if (x.get(p).get(i).comp == 'D' && values.get(p) == values.get(x.get(p).get(i).con)) {
						works = false;
						break;
					}
				}
			}
			if (!works) break;
		}
	}
	static class Pair {
		int con;
		char comp;
		public Pair(int con, char comp) {
			this.con = con;
			this.comp = comp;
		}
	}
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("revegetate.in"));
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
