/*
  ID: ashay.s1
  LANG: JAVA
  TASK: diamond
 */
import java.io.*;
import java.util.*;

public class diamond {
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("diamond.out"));
		int times = file.nextInt(), k = file.nextInt();
		ArrayList<Integer> sizes = new ArrayList();
		HashMap<Integer, Integer> occ = new HashMap(), index = new HashMap();
		for (int i = 0; i < times; i++) {
			int tmp = file.nextInt();
			sizes.add(tmp);
			occ.putIfAbsent(tmp, 0);
			occ.put(tmp, occ.get(tmp) + 1);
		}
		Collections.sort(sizes);
		for (int i = 0; i < times; i++) index.put(sizes.get(i), i);
		ArrayList<Integer> maxSize = new ArrayList();
		for (int i = 0; i < times; i++) {
			int ind = Collections.binarySearch(sizes, sizes.get(i) + k);
			boolean b = false;
			if (ind < 0) {
				b = true;
				ind = ~ind;
			}
			else {
				if (occ.get(sizes.get(i) + k) > 1) {
					ind = index.get(sizes.get(i) + k);
				}
			}
			if (b) maxSize.add(ind - i);
			else maxSize.add(ind - i + 1);
		}
		int[] fromEnd = new int[times];
		for (int i = times - 1; i >= 0; i--) {
			if (i == times - 1) fromEnd[i] = maxSize.get(i);
			else fromEnd[i] = Math.max(maxSize.get(i), fromEnd[i + 1]);
		}
		int maxDiamonds = 0;
		for (int i = 0; i < times; i++) {
			int cur = maxSize.get(i);
			int ind = cur + i;
			if (ind < times) {
				cur += fromEnd[ind];
			}
			maxDiamonds = Math.max(maxDiamonds, cur);
		}
		System.out.println(maxDiamonds);
		out.println(maxDiamonds);
		out.close();
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("diamond.in"));
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
