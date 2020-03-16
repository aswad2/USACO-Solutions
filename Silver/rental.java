/*
  ID: ashay.s1
  LANG: JAVA
  TASK: rental
 */
import java.io.*;
import java.util.*;

public class rental {
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("rental.out"));
		int times = file.nextInt();
		int milk = file.nextInt();
		int rent = file.nextInt();
		ArrayList<Pair> milks = new ArrayList<>();
		ArrayList<Long> options = new ArrayList<>(), renting = new ArrayList<>();
		for (int i = 0; i < times; i++) {
			options.add(file.nextLong());
		}
		for (int i = 0; i < milk; i++) {
			milks.add(new Pair(file.nextLong(), file.nextLong()));
		}
		for (int i = 0; i < rent; i++) {
			renting.add(file.nextLong());
		}
		Collections.sort(renting); Collections.reverse(renting); Collections.sort(milks); Collections.sort(options);
		int indexMilks = 0, indexRenting = 0;
		long total = 0l;
		for (int i = 0; i < options.size(); i++) {
			long cur = options.get(i);
			int temp = indexMilks;
			long curTot = 0;
			long amt = 0;
			while (cur > 0 && temp < milks.size()) {
				if (milks.get(temp).a <= cur) {
					curTot += milks.get(temp).b * milks.get(temp).a;
					cur -= milks.get(temp).a;
					temp++;
				}
				else {
					curTot += milks.get(temp).b * cur;
					amt = milks.get(temp).a - cur;
					cur = 0;
				}
			}
			System.out.println(curTot);
			System.out.println(renting.get(indexRenting));
			// may have to change to >=
			if (indexRenting < renting.size() && renting.get(indexRenting) >= curTot) {
				total += renting.get(indexRenting);
				indexRenting++;
			}
			else {
				total += curTot;
				indexMilks = temp;
				milks.get(temp).a = amt;
			}
			System.out.println(total);
			System.out.println();
		}
		System.out.println(total);
		out.close();
	}
	static class Pair implements Comparable<Pair> {
		long a, b;
		public Pair(long a, long b) {
			this.a = a;
			this.b = b;
		}
		public int compareTo(Pair o) {
			if (o.b == b) return Long.compare(o.a, a);
			return Long.compare(o.b, b);
		}
	}
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("rental.in"));
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
