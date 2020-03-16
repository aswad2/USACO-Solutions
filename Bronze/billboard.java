
/*
  ID: ashay.s1
  LANG: JAVA
  TASK: billboard
 */
import java.io.*;
import java.util.*;
import java.awt.*;

public class billboard {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("billboard.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		StringTokenizer st = new StringTokenizer(file.readLine());
		int one = Integer.parseInt(st.nextToken()), two = Integer.parseInt(st.nextToken()),
				w1 = Integer.parseInt(st.nextToken()), h1 = Integer.parseInt(st.nextToken());
		StringTokenizer st2 = new StringTokenizer(file.readLine());
		int one2 = Integer.parseInt(st2.nextToken()), two2 = Integer.parseInt(st2.nextToken()),
				w2 = Integer.parseInt(st2.nextToken()), h2 = Integer.parseInt(st2.nextToken());
		StringTokenizer st3 = new StringTokenizer(file.readLine());
		int one3 = Integer.parseInt(st3.nextToken()), two3 = Integer.parseInt(st3.nextToken()),
				w3 = Integer.parseInt(st3.nextToken()), h3 = Integer.parseInt(st3.nextToken());
		Rectangle r = new Rectangle (one, two, w1 - one, h1 - two), s = new Rectangle(one2, two2, w2 - one2 ,h2 - two2), t = new Rectangle(one3, two3,w3 - one3, h3 - two3);
		int tot = r.width * r.height + s.width * s.height;
//		System.out.println(r.intersection(r).height * t.intersection(r).width);
//		System.out.println(t.intersection(s).height * t.intersection(s).width);
		if (r.intersects(s)) tot -= r.intersection(s).height * r.intersection(s).width;
		if (t.intersection(r).height > 0 && t.intersection(r).width > 0) tot -= t.intersection(r).height * t.intersection(r).width;
		if (t.intersection(s).height > 0 && t.intersection(s).width > 0) tot -= t.intersection(s).height * t.intersection(s).width;
		System.out.println(tot);
		out.println(tot);
		out.close();
		file.close();
	}
}
