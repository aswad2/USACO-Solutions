/*
  ID: ashay.s1
  LANG: JAVA
  TASK: tttt
 */
import java.io.*;
import java.util.*;

public class tttt {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("tttt.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));
		char[][] order = new char[3][3];
		for (int i = 0; i < order.length; i++) {
			order[i] = file.readLine().toCharArray();
		}
		TreeSet<String> ta = new TreeSet(), tb = new TreeSet();
		for (int i = 0; i < order.length; i++) {
			TreeSet<Character> t = new TreeSet();
			for (int j = 0; j < order.length; j++) {
				t.add(order[j][i]);
			}
			String temp = "";
			for (char c : t) temp += "" + c;
			if (t.size() == 1) ta.add(temp);
			else if (t.size() == 2) tb.add(temp);
		}
		for (int i = 0; i < order.length; i++) {
			TreeSet<Character> t = new TreeSet();
			for (int j = 0; j < order.length; j++) {
				t.add(order[i][j]);
			}
			String temp = "";
			for (char c : t) temp += "" + c;
			if (t.size() == 1) ta.add(temp);
			else if (t.size() == 2) tb.add(temp);
		}
		TreeSet<Character> c = new TreeSet(), d = new TreeSet();
		for (int i = 0; i < 3; i++) {
			c.add(order[i][i]);
		}
		d.add(order[0][2]); d.add(order[1][1]); d.add(order[2][0]);
		String temp = "";
		for (char ca : c) temp += "" + ca;
		if (c.size() == 1) ta.add(temp);
		else if (c.size() == 2) tb.add(temp);
		String temp2 = "";
		for (char ca : d) temp2 += "" + ca;
		if (d.size() == 1) ta.add(temp2);
		if (d.size() == 2) tb.add(temp2);
		System.out.println(ta.size());
		System.out.println(tb.size());
		out.println(ta.size());
		out.println(tb.size());
		out.close();
		file.close();
	}
}
