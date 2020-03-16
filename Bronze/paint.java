/*
  ID: ashay.s1
  LANG: JAVA
  TASK: paint
 */
import java.io.*;
import java.util.*;

public class paint {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("paint.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
		StringTokenizer st = new StringTokenizer(file.readLine());
		StringTokenizer st2 = new StringTokenizer(file.readLine());
		int one = Integer.parseInt(st.nextToken()), two = Integer.parseInt(st.nextToken());
		int three = Integer.parseInt(st2.nextToken()), four = Integer.parseInt(st2.nextToken());
		ArrayList<Integer> t = new ArrayList<>();
		for (int i = one; i < two; i++) t.add(i);
		for (int i = three; i < four; i++) if (!t.contains(i)) t.add(i);
		out.println(t.size());
		out.close();
		file.close();
	}
}
