import java.io.*;
import java.util.*;

public class outofplace {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("outofplace.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));
		int size = Integer.parseInt(file.readLine());
		int[] t = new int[size], r = new int[size];
		for (int i = 0; i < t.length; i++) {
			int one = Integer.parseInt(file.readLine());
			t[i] = one;
			r[i] = one;
		}
		Arrays.sort(r);
		int count = 0;
		for (int i = 0; i < t.length; i++) {
			if (t[i] != r[i]) count++;
		}
		System.out.println(count - 1);
		out.println(count - 1);
		out.close();
		file.close();
	}
}
