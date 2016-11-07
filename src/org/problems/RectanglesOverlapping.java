package org.problems;

import java.util.LinkedList;

public class RectanglesOverlapping {
	public boolean checkRectanglesOverlapping(String s) {
		String[] input = s.split(" ");
		Integer[] num = new Integer[8];
		for (int i = 0; i < 8; i++) {
			// System.out.println(input[i]);
			num[i] = Integer.parseInt(input[i]);
		}

		LinkedList<Point> rec1 = new LinkedList<Point>();
		rec1.add(new Point(num[0], num[1]));
		rec1.add(new Point(num[0] + num[2], num[1]));
		rec1.add(new Point(num[0], num[1] + num[3]));
		rec1.add(new Point(num[0] + num[2], num[1] + num[3]));

		LinkedList<Point> rec2 = new LinkedList<Point>();
		rec2.add(new Point(num[4], num[5]));
		rec2.add(new Point(num[4] + num[6], num[5]));
		rec2.add(new Point(num[4], num[5] + num[7]));
		rec2.add(new Point(num[4] + num[6], num[5] + num[7]));

		if ((rec1.get(0).x <= rec2.get(0).x && rec2.get(0).x <= rec1.get(1).x)
				&& (rec1.get(0).y <= rec2.get(0).y && rec2.get(0).y <= rec2.get(2).y))
			return true;

		if ((rec1.get(0).x <= rec2.get(1).x && rec2.get(1).x <= rec1.get(1).x)
				&& (rec1.get(0).y <= rec2.get(1).y && rec2.get(1).y <= rec2.get(2).y))
			return true;

		if ((rec1.get(0).x <= rec2.get(2).x && rec2.get(2).x <= rec1.get(1).x)
				&& (rec1.get(0).y <= rec2.get(2).y && rec2.get(2).y <= rec2.get(2).y))
			return true;

		if ((rec1.get(0).x <= rec2.get(3).x && rec2.get(3).x <= rec1.get(1).x)
				&& (rec1.get(0).y <= rec2.get(3).y && rec2.get(3).y <= rec2.get(2).y))
			return true;

		return false;

	}
}

class Point {
	public int x;
	public int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
