/*
  ID: ashay.s1
  LANG: JAVA
  TASK: backforth
 */
import java.io.*;
import java.util.*;

public class backforth {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("backforth.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
		int[] first = Arrays.stream(file.readLine().split(" ")).mapToInt(n -> Integer.parseInt(n)).toArray();
		int[] second = Arrays.stream(file.readLine().split(" ")).mapToInt(n -> Integer.parseInt(n)).toArray();
		ArrayList<Integer> t = new ArrayList();
		for (int a : first) t.add(a);
		for (int a : second) t.add(a);
		TreeSet<Integer> sols = new TreeSet();
		for (int i = 0; i < t.size(); i++) {
			for (int j = 0; j < t.size(); j++) {
				for (int k = 0; k < t.size(); k++) {
					for (int l = 0; l < t.size(); l++) {
						boolean b = false;
						if (i < t.size() / 2) {
							if (j >= t.size() / 2) {
								if (k != i && (k < t.size() / 2 || k == j)) {
									if (k < t.size() / 2) {
										if ( l != j && (l == i || l == k || l >= t.size() / 2)) {
											b = true;
										}
									}
									else if (k == j) {
										if (l == k || l == i || l >= t.size() / 2) b = true;
									}
								}
							}
							else if (j == i) {
								if (k == i || k == j || k < t.size() / 2) {
									if (l >= t.size() / 2 || l == k) b = true;
								}
							}
						}
						if (b) {
							int temp = 1000 - t.get(i) + t.get(j) - t.get(k) + t.get(l);
							sols.add(temp);
						}
					}
				}
			}
		}
		System.out.println(sols.size());
		out.println(sols.size());
		out.close();
		file.close();
	}
}
