/*
  ID: ashay.s1
  LANG: JAVA
  TASK: speeding
 */
import java.io.*;
import java.util.*;

public class speeding {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("speeding.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
		int[] legal = new int[100];
		int[] speed = new int[100];
		int count1 = 0, count2 = 0;
		StringTokenizer st = new StringTokenizer(file.readLine());
		int one = Integer.parseInt(st.nextToken()), two = Integer.parseInt(st.nextToken());
		for (int i = 0; i < one; i++) {
			StringTokenizer s = new StringTokenizer(file.readLine());
			int t1 = Integer.parseInt(s.nextToken()), t2 = Integer.parseInt(s.nextToken());
			for (int j = 0; j < t1; j++) {
				legal[count1++]= t2;
			}
		}
		for (int i = 0; i < two; i++) {
			StringTokenizer s = new StringTokenizer(file.readLine());
			int t1 = Integer.parseInt(s.nextToken()), t2 = Integer.parseInt(s.nextToken());
			for (int j = 0; j < t1; j++) {
				speed[count2++]= t2;
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < legal.length; i++) {
			int diff = speed[i] - legal[i];
			if (diff > max) max = diff;
		}
		out.println(max < 0 ? 0 : max);
 		out.close();
		file.close();
	}
}
