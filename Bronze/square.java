/*
  ID: ashay.s1
  LANG: JAVA
  TASK: square
 */
import java.io.*;
import java.util.*;

public class square {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("square.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
		StringTokenizer st = new StringTokenizer(file.readLine());
		StringTokenizer st2 = new StringTokenizer(file.readLine());
		int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()), x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());
		int x3 = Integer.parseInt(st2.nextToken()), y3 = Integer.parseInt(st2.nextToken()), x4 = Integer.parseInt(st2.nextToken()), y4 = Integer.parseInt(st2.nextToken());
		int ab = Math.min(Math.min(x1, x2), Math.min(x3,  x4));
		int ab2 = Math.max(Math.max(x1,  x2), Math.max(x3,  x4));
		int ab3 = Math.min(Math.min(y1, y2), Math.min(y3,  y4));
		int ab4 = Math.max(Math.max(y1,  y2), Math.max(y3,  y4));
		int one = Math.max(ab2 - ab, ab4 - ab3);
		out.println(one * one);
		out.close();
		file.close();
	}
}
