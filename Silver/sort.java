/*
  ID: ashay.s1
  LANG: JAVA
  TASK: outofsorts
 */
import java.io.*;
import java.util.*;

public class sort {
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("sort.out"));
		int times = file.nextInt();
		int[] x= new int[times];
		int[] y = new int[times];
		for (int i = 0; i < times;i ++) {
			x[i] = file.nextInt();
			y[i] = x[i];
		}
		Arrays.sort(y);
		int max = 1;
		for (int i = 0; i < x.length; i++) {
			int temp = x[i];
			int index = Arrays.binarySearch(y, temp);
			if (i >= index)
			max = Math.max(max, Math.abs(i - index) + 1);
			//System.out.println(temp + " " + index);
		}
		System.out.println(max);
		out.println(max);
		out.close();
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("sort.in"));
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
