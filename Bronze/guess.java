/*
  ID: ashay.s1
  LANG: JAVA
  TASK: guess
 */
import java.io.*;
import java.util.*;

public class guess {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("guess.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));
		int an = Integer.parseInt(file.readLine());
		ArrayList<ArrayList<String>> thing = new ArrayList();
		for (int i = 0; i < an; i++) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			ArrayList<String> s = new ArrayList();
			st.nextToken();
			int w = Integer.parseInt(st.nextToken());
			for (int ij = 0; ij < w; ij++)  s.add(st.nextToken());
			thing.add(s);
		}
		int max = 0;
		for (int i = 0; i < thing.size(); i++) {
			for (int j = i+1; j < thing.size(); j++) {
				int count = 0;
				for (int k = 0; k < thing.get(i).size(); k++) {
					if (thing.get(j).contains(thing.get(i).get(k))) count++;
				}
				if (count > max) max= count;
			}
		}
		System.out.println(max + 1);
		out.println(max + 1);
		out.close();
		file.close();
	}
}
