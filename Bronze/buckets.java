/*
  ID: ashay.s1
  LANG: JAVA
  TASK: buckets
 */
import java.io.*;
import java.util.*;

public class buckets {
	static char[][] mat;
	static int min;
	public static void main(String[] args) throws Exception {
		fr file = new fr();
		PrintWriter out = new PrintWriter(new File("buckets.out"));
		mat = new char[10][10];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < 10; i++) mat[i] = file.next().toCharArray();
		int x = -1, y = -1;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (mat[i][j] == 'L') {
					x = i; y = j; break;
				}
			}
		}
		recur(x, y, 0);
		System.out.println(min - 1);
		out.println(min - 1);
		out.close();
	}
	
	public static void recur(int a, int b, int steps) {
		if ( steps < min && a >= 0 && a < mat.length && b >= 0 && b < mat[1].length && mat[a][b] != 'R' && mat[a][b] != '#') {
			if (mat[a][b] == 'B') {
				min = steps;
				return;
			}
			char save = mat[a][b];
			mat[a][b] = '#';
			recur(a+1, b, steps + 1);
			recur(a-1, b, steps + 1);
			recur(a, b+1, steps + 1);
			recur(a, b-1, steps + 1);
			mat[a][b] = save;
		}
	}
}


class fr {
	BufferedReader br;
	StringTokenizer st;

	public fr() throws Exception {
		br = new BufferedReader(new FileReader("buckets.in"));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}
