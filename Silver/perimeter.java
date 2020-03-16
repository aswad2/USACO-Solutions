
/*
  ID: ashay.s1
  LANG: JAVA
  TASK: perimeter
 */
import java.io.*;
import java.util.*;

public class perimeter {
	static char[][] mat;
	static boolean[][] visited;
	static long maxArea, maxPerim, a, p;

	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("perimeter.out"));
		int times = file.nextInt();
		mat = new char[times][times];
		for (int i = 0; i < times; i++) {
			mat[i] = file.next().toCharArray();
		}
		maxArea = 0;
		maxPerim = Integer.MAX_VALUE;
		visited = new boolean[times][times];
		for (int i = 0; i < times; i++) {
			for (int j = 0; j < times; j++) {
				if (mat[i][j] == '#' && !visited[i][j]) {
					a = 0;
					p = 0;
					Queue<Integer> x = new LinkedList(), y = new LinkedList();
					x.add(i);
					y.add(j);
					bfs(i, j, x, y);
				}
			}
		}
		System.out.println(maxArea + " " + maxPerim);
		out.println(maxArea + " " + maxPerim);
		out.close();
	}

	public static void bfs(int i, int j, Queue<Integer> x, Queue<Integer> y) {
		while (!x.isEmpty()) {
			int curX = x.poll(), curY = y.poll();
			if (curX >= 0 && curX < mat.length && curY >= 0 && curY < mat[curX].length && mat[curX][curY] == '#' && !visited[curX][curY]) {
				x.add(curX+1); y.add(curY);
				x.add(curX-1); y.add(curY);
				x.add(curX); y.add(curY+1);
				x.add(curX); y.add(curY-1);
				a++;
				p += 4 - numofneighbour(curX, curY);
				visited[curX][curY] = true;
			}
		}
		if (a > maxArea) {
			 maxArea = a;
			 maxPerim = p;
		}
		else if (a == maxArea) {
			maxArea = a;
			maxPerim = Math.min(maxPerim, p);
		}
	}

	static int numofneighbour(int i, int j) {
		int count = 0;
		if (i > 0 && mat[i - 1][j] == '#')
			count++;
		if (j > 0 && mat[i][j - 1] == '#')
			count++;
		if (i < mat.length - 1 && mat[i + 1][j] == '#')
			count++;
		if (j < mat[i].length - 1 && mat[i][j + 1] == '#')
			count++;
		return count;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new FileReader("perimeter.in"));
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

}
