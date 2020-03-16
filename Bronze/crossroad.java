/*
  ID: ashay.s1
  LANG: JAVA
  TASK: crossroad
 */
import java.io.*;
import java.util.*;

public class crossroad {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("crossroad.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crossroad.out")));
		int times = Integer.parseInt(file.readLine());
		HashMap<Integer, Integer> map = new HashMap();
		int count = 0;
		for (int i = 0; i < times; i++) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			int one = Integer.parseInt(st.nextToken()), two = Integer.parseInt(st.nextToken());
			if (map.containsKey(one)) {
				if (map.get(one) != two) {
					count++;
				}
			}
			map.put(one, two);
		}
		System.out.println(count);
		out.println(count);
		out.close();
		file.close();
	}
}

