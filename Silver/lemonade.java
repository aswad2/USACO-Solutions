/*
  ID: ashay.s1
  LANG: JAVA
  TASK: lemonade
 */
import java.io.*;
import java.util.*;

public class lemonade {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("lemonade.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
		int times = Integer.parseInt(file.readLine());
		int[] a = Arrays.stream(file.readLine().split(" ")).mapToInt(n -> Integer.parseInt(n)).toArray();
		ArrayList<Integer> t = new ArrayList();
		for (int i : a) t.add(i);
		Collections.sort(t); Collections.reverse(t);
		int count = 0;
		for (int i = 0; i < t.size(); i++) {
			if (i <= t.get(i)) count++;
			else break;
		}
		System.out.println(count);
		out.println(count);
		out.close();
		file.close();
	}
}
