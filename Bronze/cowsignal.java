/*
  ID: ashay.s1
  LANG: JAVA
  TASK: cowsignal
 */
import java.io.*;
import java.util.*;

public class cowsignal {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("cowsignal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
		StringTokenizer st = new StringTokenizer(file.readLine());
		int row = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken()), times = Integer.parseInt(st.nextToken());
		char[][] mat = new char[row][col];
		for (int i = 0; i < row; i++) {
			mat[i] = file.readLine().toCharArray();
		}
		char[][] temp = new char[row * times][col * times];
		int count = 0, count2 = 0;
		for (int i = 0; i < temp.length; i++) {
			 int tempo = 0, tempo2 = 0;
			for (int j = 0; j < temp[i].length; j++) {
				temp[i][j] = mat[count][tempo];
				//System.out.print(temp[i][j]);
				tempo2++;
				if (tempo2 % times == 0) {
					tempo++;
				}
			}
			count2++;
			if (count2 % times == 0) count++;
		}
		for (char[] t : temp) {
			for (char c : t) out.print(c);
			out.println();
		}
		out.close();
		file.close();
	}
}
