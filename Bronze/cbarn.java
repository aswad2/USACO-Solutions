/*
  ID: ashay.s1
  LANG: JAVA
  TASK: cbarn
 */
import java.io.*;
import java.util.*;

public class cbarn {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("cbarn.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
		ArrayList<Integer> t = new ArrayList();
		int times = Integer.parseInt(file.readLine());
		for (int i = 0; i < times; i++) {
			t.add(Integer.parseInt(file.readLine()));
		}
		int min= Integer.MAX_VALUE;
		for (int i = 0; i < times; i++) {
			int temp = 0;
			for (int j = 0; j < t.size(); j++) {
				temp += t.get(j) * j;
			}
			if (temp < min) min = temp;
				Collections.rotate(t, -1);
		}
		System.out.println(min);
		out.println(min);
		out.close();
		file.close();
	}
}
