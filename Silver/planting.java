/*
  ID: ashay.s1
  LANG: JAVA
  TASK: planting
 */
import java.io.*;
import java.util.*;

public class planting {
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("planting.out"));
		int times = file.nextInt();
		ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
		for (int i = 0; i <times; i++) {
			alist.add(new ArrayList<>());
		}
		for (int i = 0; i < times - 1; i++) {
			int a = file.nextInt(), b = file.nextInt();
			alist.get(a-1).add(b-1);
			alist.get(b-1).add(a-1);
		}
		int max = 0;
		for (int i =0; i < times; i++) {
			max = Math.max(max, alist.get(i).size() + 1);
		}
		System.out.println(max);
		out.println(max);
		out.close();
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("planting.in"));
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
