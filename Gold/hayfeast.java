/*
  ID: ashay.s1
  LANG: JAVA
  TASK: hayfeast
 */
import java.io.*;
import java.util.*;

public class hayfeast {
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("hayfeast.out"));
		int times = file.nextInt();
		long m = file.nextLong();
		ArrayList<Trio> dishes = new ArrayList<>();
		for (int i = 0; i < times; i++) {
			dishes.add(new Trio(file.nextLong(), file.nextLong(), i + 1));
		}
		Collections.sort(dishes);
		fenwick ones = new fenwick(times), location = new fenwick(times);
		for (Trio t : dishes) {
			ones.update(t.index, 1);
			location.update(t.index, t.flavor);
			int lo = 1, hi = t.index;
			int maxLow = Integer.MAX_VALUE;
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				if (ones.sum(mid, t.index) == t.index - mid + 1) {
					maxLow = Math.min(maxLow, mid);
					hi = mid - 1;
				}
				else {
					lo = mid + 1;
				}
			}
			int high = t.index, higher = ones.size;
			int maxHigh = 0;
			while (high <= higher) {
				int mid = (high + higher) / 2;
				if (ones.sum(t.index, mid) == mid - t.index + 1) {
					maxHigh = Math.max(maxHigh, mid);
					high = mid + 1;
				}
				else {
					higher = mid - 1;
				}
			}
			if (location.sum(maxLow, maxHigh) >= m) {
				System.out.println(t.spice);
				out.println(t.spice);
				break;
			}
		}
		out.close();
	}
	static class Trio implements Comparable<Trio> {
		long flavor, spice;
		int index;
		public Trio(long f, long s, int i) {
			flavor = f;
			spice = s;
			index = i;
		}
		public int compareTo(Trio other) {
			if (spice == other.spice) return Long.compare(other.flavor, flavor);
			return Long.compare(spice, other.spice);
		}
	}
	static class fenwick {
		long[] bit;
		int size;

		public fenwick(int n) {
			size = n;
			bit = new long[n + 1];
		}

		long sum(int a) {
			long s = 0;
			while (a >= 1) {
				s += bit[a];
				a -= a & -a;
			}
			return s;
		}

		long sum(int a, int b) {
			return sum(b) - (a == 1 ? 0 : sum(a - 1));
		}

		void update(int k, long x) {
			while (k <= size) {
				bit[k] += x;
				k += k & -k;
			}
		}
	}
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("hayfeast.in"));
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
