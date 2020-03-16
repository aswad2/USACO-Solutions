
/*
  ID: ashay.s1
  LANG: JAVA
  TASK: badmilk
 */
import java.io.*;
import java.util.*;

public class badmilk {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("badmilk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));
		StringTokenizer st = new StringTokenizer(file.readLine());
		int people = Integer.parseInt(st.nextToken()), milk = Integer.parseInt(st.nextToken()),
				events = Integer.parseInt(st.nextToken()), si = Integer.parseInt(st.nextToken());
		int[] p = new int[events], milks = new int[events], time = new int[events], sick = new int[si], sicktime = new int[si];
		for (int i = 0; i < events; i++) {
			StringTokenizer t = new StringTokenizer(file.readLine());
			p[i] = Integer.parseInt(t.nextToken());
			milks[i] = Integer.parseInt(t.nextToken());
			time[i] = Integer.parseInt(t.nextToken());
		}
		for (int i = 0; i < si; i++) {
			StringTokenizer t = new StringTokenizer(file.readLine());
			sick[i] = Integer.parseInt(t.nextToken());
			sicktime[i] = Integer.parseInt(t.nextToken());
		}
		int maxcount = Integer.MIN_VALUE;
		ArrayList<Integer> start = new ArrayList();
		ArrayList<ArrayList<Integer>> t = new ArrayList();
		for (int i = 0; i < sick.length; i++) {
			ArrayList<Integer> drank = new ArrayList();
			for (int j = 0; j < time.length; j++) {
				if (p[j] == sick[i] && time[j] < sicktime[i]) {
					if (i == 0)
						start.add(milks[j]);
					else drank.add(milks[j]);
				}
			}
			if (i != 0)
			t.add(drank);
		}
		ArrayList<Integer> common = new ArrayList();
		for (int i = 0; i < start.size(); i++) {
			boolean hi = true;
			for (int j = 0; j < t.size(); j++) {
				if (!t.get(j).contains(start.get(i))) hi = false;
			}
			if (hi) common.add(start.get(i));
		}
		for (int i = 0; i < common.size(); i++) {
			TreeSet<Integer> r = new TreeSet();
			for (int j = 0; j < milks.length; j++) {
				if (milks[j] == common.get(i)) r.add(p[j]); 
			}
			if (r.size() > maxcount) maxcount = r.size();
		}
		System.out.println(maxcount);
		out.println(maxcount);
		out.close();
		file.close();
	}
}
