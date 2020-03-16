/*
  ID: ashay.s1
  LANG: JAVA
  TASK: citystate
 */
import java.io.*;
import java.util.*;

public class citystate {
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("citystate.out"));
		int times = file.nextInt();
		LinkedHashMap<String, Long> cs = new LinkedHashMap();
		for (int i = 0; i < times; i++) {
			String s = file.next().substring(0, 2), r = file.next();
			if (!s.equals(r)) {
			cs.putIfAbsent(s + r, 0l);
			cs.putIfAbsent(r + s, 0l);
			cs.put(s + r, cs.get(s + r) + 1l);
			}
		}
		//System.out.println(cs);
		int count = 0;
		long prod = 1, tot = 0;
		for (String s : cs.keySet()) {
			prod *= cs.get(s);
			count++;
			if (count == 2) {
				count = 0;
				tot += prod;
				prod = 1;
			}
		}
		System.out.println(tot);
		out.println(tot);
		out.close();
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("citystate.in"));
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
