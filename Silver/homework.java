/*
  ID: ashay.s1
  LANG: JAVA
  TASK: homework
 */
import java.io.*;
import java.util.*;

public class homework {
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("homework.out"));
		int times = file.nextInt();
		int[] x = new int[times];
		for (int i = 0; i < times; i++) x[i] = file.nextInt();
		int[] w = new int[times], y = new int[times];
		for (int i = 0; i < times; i++) {
			if (i == 0) w[0] = x[0];
			else w[i] = w[i-1] + x[i];
		}
		for (int i = times - 1; i >= 0; i--) {
			if (i == times - 1) y[i] = x[i];
			else y[i] = Math.min(y[i+1], x[i]);
		}
		TreeMap<Double, ArrayList<Integer>> occ = new TreeMap();
		double max = Integer.MIN_VALUE;
		for (int i = 0; i < times - 2; i++) {
			int sum = w[times - 1] - w[i];
			sum -= y[i];
			double avg = (double)sum / (double)(times - i - 1);
			occ.putIfAbsent(avg, new ArrayList());
			occ.get(avg).add(i + 1);
			max = Math.max(max, avg);
		}
		String res = "";
		for (int cur : occ.get(max)) {
			res += cur + " ";
		}
		System.out.println(res.trim());
		out.println(res.trim());
		out.close();
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("homework.in"));
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
