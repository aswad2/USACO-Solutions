/*
  ID: ashay.s1
  LANG: JAVA
  TASK: shell
 */
import java.io.*;
import java.util.*;

public class shell {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("shell.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
		int guess = Integer.parseInt(file.readLine());
		ArrayList<int[]> a = new ArrayList();
		for (int i = 0; i < guess; i++) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			int[] temp = new int[3];
			temp[0] = Integer.parseInt(st.nextToken());
			temp[1] = Integer.parseInt(st.nextToken());
			temp[2] = Integer.parseInt(st.nextToken());
			a.add(temp);
		}
		int max = Integer.MIN_VALUE;
		ArrayList<Integer> start = new ArrayList();
		start.add(1); start.add(0); start.add(0);
		for (int i = 0; i < start.size(); i++) {
			ArrayList<Integer> copy = (ArrayList<Integer>)start.clone();
			int count = 0;
			for (int j = 0; j < a.size(); j++) {
				int temp = copy.get(a.get(j)[0] - 1);
				copy.set(a.get(j)[0] - 1, copy.get(a.get(j)[1] - 1));
				copy.set(a.get(j)[1] - 1, temp);
				if (copy.get(a.get(j)[2] - 1) == 1) count++;
			}
			if (count > max) max = count;
			Collections.rotate(start, -1);
//			System.out.println(count);
		}
		System.out.println(max);
		out.println(max);
		out.close();
		file.close();
	}
}
