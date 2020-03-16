/*
  ID: ashay.s1
  LANG: JAVA
  TASK: blist
 */
import java.io.*;
import java.util.*;

public class blist {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("blist.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
		int times = Integer.parseInt(file.readLine());
		int maxtime= Integer.MIN_VALUE;
		ArrayList<Integer> starting = new ArrayList();
		ArrayList<Integer> endings = new ArrayList();
		ArrayList<Integer> bucketslist = new ArrayList();
		for (int asdf = 0; asdf < times; asdf++) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken()), buckets = Integer.parseInt(st.nextToken());
			if (end > maxtime) maxtime = end;
			starting.add(start); endings.add(end); bucketslist.add(buckets);
		}
		int[] tot = new int[maxtime];
		for (int i = 0; i < starting.size(); i++) {
			for (int j = starting.get(i); j < endings.get(i); j++) {
				tot[j] += bucketslist.get(i);
			}
		}
		Arrays.sort(tot);
		out.println(tot[tot.length - 1]);
		out.close();
		file.close();
	}
}
