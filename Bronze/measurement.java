/*
  ID: ashay.s1
  LANG: JAVA
  TASK: measurement
 */
import java.io.*;
import java.util.*;

public class measurement {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("measurement.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
		HashMap<String, Integer> map = new HashMap();
		map.put("Mildred", 7); map.put("Elsie", 7); map.put("Bessie", 7);
		int times = Integer.parseInt(file.readLine());
		int[] add = new int[100];
		String[] names = new String[100];
		for (int i = 0; i < times; i++) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			int b = Integer.parseInt(st.nextToken());
			names[b-1] = st.nextToken();
			add[b-1] = Integer.parseInt(st.nextToken());
		}
		int max = Integer.MIN_VALUE, tot = 3, changes = 0;
		String sr = "Mildred";
		for (int i= 0; i < names.length; i++) {
			if (names[i] != null) {
				map.put(names[i], map.get(names[i]) + add[i]);
//				System.out.println(map.get("Mildred") + " " + map.get("Elsie") + " " + map.get("Bessie"));
				int temp = Math.max(Math.max(map.get("Elsie"), map.get("Bessie")), map.get("Mildred")), count = 0;
				String s = "";
				if (map.get("Elsie") == temp) {
					count++;
					s = "Elsie";
				}
				if (map.get("Bessie") == temp) {
					count++;
					s = "Bessie";
				}
				if (map.get("Mildred") == temp) {
					count++;
					s = "Mildred";
				}
				if (count != tot) {
//					System.out.println("one");
					changes++;
					tot = count;
				}
				else if (!s.equals(sr)) {
//					System.out.println("two");
					changes++;
				}
				sr = s;
				max = temp;
			}
		}
		System.out.println(changes);
		out.println(changes);
		out.close();
		file.close();
	}
}
