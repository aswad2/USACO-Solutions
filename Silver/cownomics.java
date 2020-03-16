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
		int n = file.nextInt();
		int m = file.nextInt();
		int count = 0;
		ArrayList<String> t = new ArrayList(), s = new ArrayList();
		for (int i = 0; i < n; i++) t.add(file.next());
		for (int i = 0; i < n; i++) s.add(file.next());
		for (int i = 0; i < m; i++) {
			for (int j = i + 1; j < m; j++) {
				for (int k = j + 1; k < m; k++) {
					HashSet<String> spot = new HashSet<>(), plain = new HashSet<>();
					for (int l = 0; l < n; l++) {
						spot.add("" + t.get(l).charAt(i) + t.get(l).charAt(j) + t.get(l).charAt(k));
					}
					for (int l = 0; l < n; l++) {
						plain.add("" + s.get(l).charAt(i) + s.get(l).charAt(j) + s.get(l).charAt(k));
					}
					boolean c = true;
					for (String temp : spot) {
						if (plain.contains(temp)) {
							c = false;
							break;
						}
					}
					if (c) count++;
				}
			}
		}
		System.out.println(count);
		out.println(count);
		out.close();
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
