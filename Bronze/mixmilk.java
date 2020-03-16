/*
  ID: ashay.s1
  LANG: JAVA
  TASK: mixmilk
 */
import java.io.*;
import java.util.*;

public class mixmilk {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("mixmilk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
		StringTokenizer st = new StringTokenizer(file.readLine());
		StringTokenizer st2 = new StringTokenizer(file.readLine());
		StringTokenizer st3 = new StringTokenizer(file.readLine());
		int maxone = Integer.parseInt(st.nextToken()), initialone = Integer.parseInt(st.nextToken());
		int maxtwo = Integer.parseInt(st2.nextToken()), initialtwo = Integer.parseInt(st2.nextToken());
		int maxthree = Integer.parseInt(st3.nextToken()), initialthree = Integer.parseInt(st3.nextToken());
		for (int i = 0; i < 100; i++) {
			if (i % 3 == 0) {
				while (initialone > 0 && initialtwo < maxtwo) {
					initialone--;
					initialtwo++;
				}
			}
			else if (i % 3 == 1) {
				while (initialtwo > 0 && initialthree < maxthree) {
					initialtwo--;
					initialthree++;
				}
			}
			else {
				while (initialthree > 0 && initialone < maxone) {
					initialthree--;
					initialone++;
				}
			}
		}
		out.println(initialone);
		out.println(initialtwo);
		out.println(initialthree);
		out.close();
		file.close();
	}
}
