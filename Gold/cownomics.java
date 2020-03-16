/*
  ID: ashay.s1
  LANG: JAVA
  TASK: cownomics
 */
import java.io.*;
import java.util.*;

public class cownomics {
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("cownomics.out"));
		int times = file.nextInt();
		int m = file.nextInt();
		ArrayList<String> a = new ArrayList(), b = new ArrayList();
		for (int i = 0; i < times; i++) a.add(file.next());
		for (int i = 0; i < times; i++) b.add(file.next());
		int lo = 1, hi = m;
		int target = Integer.MAX_VALUE;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (works(a, b, mid)) {
				target = Math.min(mid, target);
				hi = mid - 1;
			}
			else {
				lo = mid + 1;
			}
		}
		System.out.println(target);
		out.println(target);
		out.close();
	}
	static boolean works(ArrayList<String> a, ArrayList<String> b, int m) {
		
		for (int i = 0; i < a.get(0).length() - m + 1; i++) {
			boolean c = true;
			HashSet<String> x = new HashSet(), y = new HashSet();
			for (int j = 0; j < a.size(); j++) {
				x.add(a.get(j).substring(i, i + m));
				y.add(b.get(j).substring(i, i + m));
			}
			for (String s : x) {
				if (y.contains(s)) c = false;
			}
			if (c) return true;
		}
		return false;
	}
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("cownomics.in"));
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
