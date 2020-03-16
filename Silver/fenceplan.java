/*
  ID: ashay.s1
  LANG: JAVA
  TASK: fenceplan
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class fenceplan {
	public static void main(String[] args) throws Exception {
		FastReader file = new FastReader();
		PrintWriter out = new PrintWriter(new File("fenceplan.out"));
		int times = file.nextInt(), sets = file.nextInt();
		int[] coordx = new int[times], coordy = new int[times];
		for (int i = 0; i < times; i++) {
			coordx[i] = file.nextInt();
			coordy[i] = file.nextInt();
		}
		DSU dsu = new DSU(times);
		for (int i = 0; i < sets; i++) {
			int one = file.nextInt()-1, two = file.nextInt()-1;
			dsu.union(one, two);
		}
	//	System.out.println(Arrays.toString(dsu.parent));
		HashMap<Integer, Integer> minx = new HashMap(), maxx = new HashMap(), miny = new HashMap(), maxy = new HashMap();
		int min = Integer.MAX_VALUE;
		for (int i= 0; i < times; i++) {
			int t = dsu.parent[i], x = dsu.find(t);
			int a = coordx[i], b = coordy[i];
			if (minx.containsKey(x)) {
				minx.put(x, Math.min(minx.get(x), a));
				maxx.put(x, Math.max(maxx.get(x), a));
				miny.put(x, Math.min(miny.get(x), b));
				maxy.put(x, Math.max(maxy.get(x), b));
			}
			else {
				minx.put(x, a);
				maxx.put(x, a);
				miny.put(x, b);
				maxy.put(x, b);
			}
		}
		for (int c : minx.keySet()) {
			int perim = maxx.get(c) - minx.get(c), perim2 = maxy.get(c) - miny.get(c);
			int t = (perim + perim2) * 2;
			min = Math.min(min, t);
		}
		System.out.println(min);
		out.println(min);
		out.close();
	}
}

 class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() throws Exception {
		br = new BufferedReader(new FileReader("fenceplan.in"));
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
 class DSU {
	int[] rank, parent;
	int data;
	
	public DSU(int data) {
		rank = new int[data];
		parent = new int[data];
		this.data = data;
		makeSet();
	}
	
	public void makeSet() {
		for (int i = 0; i < data; i++) 
			parent[i] = i;
	}
	public int find(int x) {
		if (parent[x] == x) return x;
		else {
			int a = find(parent[x]);
			parent[x] = a;
			return a;
		}
	}
	public void union(int x, int y) {
		int findx = find(x), findy = find(y);
		if (findx == findy) return;
		int xrank = rank[findx], yrank = rank[findy];
		if (xrank < yrank) {
			parent[findx] = findy;
		}
		else if (yrank < xrank) {
			parent[findy] = findx;
		}
		else {
			parent[findx] = findy;
			rank[findy]++; 
		}
	}
	
}

