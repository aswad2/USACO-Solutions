/*
  ID: ashay.s1
  LANG: JAVA
  TASK: taming
 */
import java.io.*;
import java.util.*;

public class taming {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("taming.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
		int times = Integer.parseInt(file.readLine());
		int[] log = Arrays.stream(file.readLine().split(" ")).mapToInt(n -> Integer.parseInt(n)).toArray();
		int count = 0;
		log[0] = 0;
		boolean b = true;
		for (int i = 0; i < log.length; i++) {
			if (log[i] != -1 && log[i] <= i - 1) {
				int temp = 0;
				for (int j = i-log[i]; j < i; j++) {
					if (log[j] != -1) b = false;
					else log[j] = temp++;
				}
			}
		}
		if (!b) out.println(-1);
		else {
		for (int i = 0; i < log.length; i++) {
			if (log[i] == 0) count++;
		}
		System.out.print(count + " ");
		out.print(count + " ");
		for (int i = 0; i < log.length; i++) {
			if (log[i] == -1) count++;
		}
		System.out.println(count);
		out.println(count);
		}
		out.close();
		file.close();
	}
}
