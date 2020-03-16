/*
  ID: ashay.s1
  LANG: JAVA
  TASK: balancing
 */
import java.io.*;
import java.util.*;

public class balancing {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("balancing.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
		StringTokenizer st = new StringTokenizer(file.readLine());
		int times = Integer.parseInt(st.nextToken()), maximum = Integer.parseInt(st.nextToken());
		ArrayList<Integer> xpoints = new ArrayList(), ypoints = new ArrayList();
		for (int i = 0; i < times; i++) {
			StringTokenizer st2 = new StringTokenizer(file.readLine());
			xpoints.add(Integer.parseInt(st2.nextToken())); ypoints.add(Integer.parseInt(st2.nextToken()));
		}
		int min = Integer.MAX_VALUE, section = Integer.MIN_VALUE;
		for (int i = 2; i <= maximum; i+=2) {
			for (int j = 2; j <= maximum; j+=2) {
				int topleft = 0, topright = 0, botleft = 0, botright = 0;
				for (int k = 0; k < xpoints.size(); k++) {
					if (xpoints.get(k) < i && ypoints.get(k) < j) botleft++;
					else if (xpoints.get(k) < i && ypoints.get(k) > j) topleft++;
					else if (xpoints.get(k) > i && ypoints.get(k) < j) botright++;
					else topright++;
				}
				int maxdiff = Math.max(Math.max(botright, botleft), Math.max(topright, topleft)) - Math.min(Math.min(botright, botleft), Math.min(topright,topleft));
				if (maxdiff < min) {
					min = maxdiff;
					section = Math.max(Math.max(botright, botleft), Math.max(topright, topleft));
				}
			}
		}
		System.out.println(section);
		out.println(section);
		out.close();
		file.close();
	}
}
