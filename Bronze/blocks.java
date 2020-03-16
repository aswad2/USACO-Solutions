/*
  ID: ashay.s1
  LANG: JAVA
  TASK: blocks
 */
import java.io.*;
import java.util.*;

public class blocks {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("blocks.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
		int times = Integer.parseInt(file.readLine());
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c = 97; c <= 122; c++) {
			map.put(c, 0);
		}
		for (int i = 0; i < times; i++) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			String s = st.nextToken(), r = st.nextToken();
			HashMap<Character, Integer> a = new HashMap();
			HashMap<Character, Integer> asdf = new HashMap();
			for (char c = 97; c <= 122; c++) {
				a.put(c, 0);
				asdf.put(c, 0);
			}
			for (int j = 0; j < s.length(); j++) {
				map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
				asdf.put(s.charAt(j), asdf.get(s.charAt(j)) + 1);
			}
			boolean b = true;
			for (int j = 0; j < r.length(); j++) {
				if (!s.contains("" + r.charAt(j))) {
					map.put(r.charAt(j), map.get(r.charAt(j)) + 1);
				}
				else if (s.contains("" + r.charAt(j)) && a.get(r.charAt(j)) < asdf.get(r.charAt(j))) {
					a.put(r.charAt(j), a.get(r.charAt(j)) + 1);
				}
				else map.put(r.charAt(j), map.get(r.charAt(j)) + 1);
			}
		}
		for (char c : map.keySet()) {
			out.println(map.get(c));
		}
		out.close();
		file.close();
	}
}
