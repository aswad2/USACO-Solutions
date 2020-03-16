/*
  ID: ashay.s1
  LANG: JAVA
  TASK: notlast
 */
import java.io.*;
import java.util.*;

public class notlast {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("notlast.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
		int times = Integer.parseInt(file.readLine());
		Map<String, Integer> map = new TreeMap();
		for (int i = 0; i < times; i++) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			String s= st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			if (map.containsKey(s)) map.put(s, map.get(s) + n);
			else map.put(s, n);
		}
		if (times == 1) {
			for (String s : map.keySet()) out.println(s);
			out.close();
			file.close();
		}
		else {
		int min = Integer.MAX_VALUE;
		ArrayList<String> s = new ArrayList();
		for (String w : map.keySet()) {
			if (map.get(w) < min) {
				min = map.get(w);
			}
			s.add(w);
		}
		for (int i = s.size() - 1; i >= 0; i--) {
			if (map.get(s.get(i)) == min) {
				map.remove(s.get(i));
				s.remove(i);
			}
		}
		int min2 = Integer.MAX_VALUE;
		ArrayList<String> e = new ArrayList();
		String name = "";
		for (String w : map.keySet()) {
			if (map.get(w) < min2) {
				min2 = map.get(w);
				name = w;
			}
			e.add(w);
		}
		int count = 0;
		for (int i = e.size() - 1; i >= 0; i--) {
			if (map.get(e.get(i)) == min2) {
				count++;
			}
		}
		
		out.println(count != 0 ? count > 1 ? "Tie" : name : "Tie");
		out.close();
		file.close();
	}
	}
}
