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
		String cows = file.next();
		for (int i = 0; i < times - 1; i++) {
			int x = file.nextInt() - 1, y = file.nextInt() - 1;
			a.get(x).add(y);
			parents[y] = x;
			if (cows.charAt(x) != cows.charAt(y)) works.add(y);
		}
		int[] workingparent = new int[times];
		HashSet<Integer> work = new HashSet();
		for (int i= 0; i < works.size(); i++) {
			Queue<Integer> c = new LinkedList();
			c.add(works.get(i));
			workingparent[works.get(i)] = works.get(i);
			while (!c.isEmpty()) {
				int cur = c.poll();
				work.add(cur);
				for (int j = 0; j < a.get(cur).size(); j++) {
					c.add(a.get(cur).get(j));
					workingparent[a.get(cur).get(j)] = works.get(i);
				}
			}
		}
		System.out.println(Arrays.toString(workingparent));
		String res = "";
		for (int i = 0; i < m; i++) {
			int start = file.nextInt() - 1, end = file.nextInt() - 1;
			char pref = file.next().charAt(0);
			if (start == end) {out.print(cows.charAt(start) == pref ? 1 : 0); System.out.print(cows.charAt(start) == pref ? 1 : 0);}
			else if (cows.charAt(start) != cows.charAt(end)) {out.print(1);System.out.print(1);}
			else if (cows.charAt(start) == pref) {out.print(1);System.out.print(1);}
			else {
				if ((work.contains(start) || work.contains(end)) && workingparent[end] != workingparent[start]) {out.print(1);System.out.print(1);}
				else {out.print(0);System.out.print(0);}
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
