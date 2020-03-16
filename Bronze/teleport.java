
/*
  ID: ashay.s1
  LANG: JAVA
  TASK: teleport
 */
import java.io.*;
import java.util.*;

public class teleport {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("teleport.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
		StringTokenizer st = new StringTokenizer(file.readLine());
		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()),
				x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
		int min = Math.min(x,y);
		int temp = (Math.abs(Math.min(a, b) - min) + Math.abs(Math.max(a, b) - Math.max(x, y)));
		if (Math.abs(a - b) > temp) out.println(temp);
		else out.println(Math.abs(a - b));
		out.close();
		file.close();
	}
}
