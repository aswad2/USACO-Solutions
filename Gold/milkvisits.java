/*
  ID: ashay.s1
  LANG: JAVA
  TASK: milkvisits
 */
import java.io.*;
import java.util.*;

public class milkvisits {
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("milkvisits.out"));
		int times = file.nextInt(), m = file.nextInt();
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		for (int i = 0; i < times; i++) a.add(new ArrayList());
		ArrayList<Integer> works = new ArrayList();
		int[] parents = new int[times];
		int[] cows = new int[times];
		HashSet<Integer>[] connections = new HashSet[times];
		for (int i = 0; i < times; i++) connections[i] = new HashSet<Integer>();
		for (int i = 0; i < times; i++) cows[i] = file.nextInt();
		for (int i = 0; i < times - 1; i++) {
			int x = file.nextInt() - 1, y = file.nextInt() - 1;
			a.get(x).add(y);
			if (cows[x] != cows[y]) {
				works.add(y);
				parents[y] = x;
			}
		}
		LinkedHashSet<Integer> x = new LinkedHashSet<>();
		HashSet<Integer>[] workingparent = new HashSet[times];
		HashSet<Integer> work = new HashSet<>();
		for (int i= 0; i < works.size(); i++) {
			Queue<Integer> c = new LinkedList<>();
			c.add(works.get(i));
			//somehow need to store the closest parent
//			workingparent[works.get(i)].add(works.get(i));
			while (!c.isEmpty()) {
				int cur = c.poll();
				work.add(cur);
				for (int j = 0; j < a.get(cur).size(); j++) {
					c.add(a.get(cur).get(j));
					//adding all the parents where a switch occurs for every child
//					workingparent[a.get(cur).get(j)].add(works.get(i));
					connections[a.get(cur).get(j)].add(cows[works.get(i)]);
					connections[a.get(cur).get(j)].add(cows[parents[works.get(i)]]);
				}
			}
		}
		System.out.println(Arrays.toString(connections));
//		System.out.println(works);
		//System.out.println(Arrays.toString(workingparent));
		String res = "";
		for (int i = 0; i < m; i++) {
			int start = file.nextInt() - 1, end = file.nextInt() - 1;
			int pref = file.nextInt();
			if (start == end) System.out.print(cows[start] == pref ? 1 : 0);
			else if (cows[start] == pref || cows[end] == pref) System.out.print(1);
			else {
				if (works.contains(start) && connections[start].contains(pref) || works.contains(end) && connections[end].contains(pref)) {
					System.out.print(1);
				}
				else System.out.print(0);
			}
		}
		out.close();
	}

//	static boolean findParent(int start, int end, char pref, int[] parent, String cows) {
//		LinkedHashSet<Integer> vis = new LinkedHashSet();
//		int cur = end;
//		while (cur != 0) {
//			vis.add(cur);
//			cur = parent[cur];
//		}
//		vis.add(0);
//		int temp = start;
//		int val = 0;
//		while (temp != 0) {
//			if (vis.contains(temp)) {
//				val = temp;
//				break;
//			}
//			temp = parent[temp];
//			if (temp == 0) val = 0;
//		}
//		while (end != val) {
//			if (cows.charAt(end) == pref) return true;
//			end = parent[end];
//		}
//		while (start != val) {
//			if (cows.charAt(start) == pref) return true;
//			start = parent[start];
//		}
//		return false;
//	}
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("milkvisits.in"));
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
