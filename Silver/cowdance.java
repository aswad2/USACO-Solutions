/*
  ID: ashay.s1
  LANG: JAVA
  TASK: cowdance
 */
import java.io.*;
import java.util.*;

public class cowdance {
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("cowdance.out"));
		int times = file.nextInt(), tmax = file.nextInt();
		int[] stageTime = new int[times];
		for (int i = 0; i < times; i++) stageTime[i] = file.nextInt();
		int low = 0, high = times - 1;
		int min = times;
		while (low < high) {
			int mid= (low + high) / 2;
			if (works(mid, stageTime, tmax)) {
				min = mid + 1;
				high = mid;
			}
			else low = mid + 1;
		}
		System.out.println(min);
		out.println(min);
		out.close();
	}
	public static boolean works(int mid, int[] stage, int tmax) {
		PriorityQueue<Integer> p = new PriorityQueue();
		for (int i = 0; i <= mid; i++) p.add(stage[i]);
		for (int i = mid + 1; i < stage.length; i++) {
			int w= p.poll();
			w += stage[i];
			if (w > tmax) return false;
			p.add(w);
		}
		return true;
	}
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("cowdance.in"));
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
