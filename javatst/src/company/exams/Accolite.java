package company.exams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Accolite {

	public Accolite() {
	}

	public static void main(String[] args) {

		int n = 10;// no of nodes
		int m = 10; // length of x and y i.e Direct edge betwenn two nodes
		String s = "aeabadcxyz";
		int[] x = { 1, 1, 3, 3, 6, 4, 4, 7, 8, 9 };

		int[] y = { 2, 3, 6, 4, 7, 7, 5, 2, 9, 10 };

		/*
		 * 
		 * 
		 * 
		 * 
		 * 1------------->2 | \ | \ 3----->6--------* 7 \ * \ / \ / \ / \ / * / 4 | | |
		 * | * 5
		 */

		/*
		 * 
		 * 
		 * 
		 * a 1----->2 b | | | a .>3------>4------->5 c a
		 * 
		 */

		/*
		 * 
		 * int n = 5; int m = 4; String s = "abaca"; int[] x = { 1, 1, 3, 4 }; int[] y =
		 * { 2, 3, 4, 5 };
		 *
		  
		 */
		System.out.println(" Result ---> " + beaty(n, m, s, x, y));
	}

	private static int beaty(int n, int m, String s, int[] x, int[] y) {

		List<ArrayList<String>> xylist = new ArrayList<ArrayList<String>>(m);
		for (int i = 0; i < m; i++) {
			xylist.add(new ArrayList<String>());
		}
		for (int i = 0; i < m; i++) {
			List<String> strings = preString(i, x, y, s, xylist);
			for (int k = 0; k < strings.size(); k++) {
				String str = strings.get(k);
				xylist.get(i).add(str);
			}
		}

		for (int i = 0; i < xylist.size(); i++) {
			for (int j = 0; j < xylist.get(i).size(); j++) {
				System.out.println(xylist.get(i).get(j));
			}
		}

		int max = -1;
		for (int i = 0; i < xylist.size(); i++) {
			for (int j = 0; j < xylist.get(i).size(); j++) {
				int val = check(xylist.get(i).get(j));
				if (val > max) {
					max = val;
				}
			}
		}

		return max;
	}

	public static int check(String s) {
		int a[] = new int[26];
		int count = 0;
		boolean dup = false;
		Arrays.fill(a, 0);
		for (int i = 0; i < s.length(); i++) {
			a[s.charAt(i) - 97]++;
		}
		for (int i = 0; i < 26; i++) {
			if (a[i] > 1) {
				count += a[i];
				dup = true;
			}
		}
		if (dup)
			return count;
		else
			return -1;
	}

	public static List<String> preString(int i, int[] x, int[] y, String s, List<ArrayList<String>> xylist) {

		List<String> list = new ArrayList<String>();
		if (i == 0 && x.length >= 1) {
			list.add(s.substring(x[i] - 1, x[i]) + s.substring(y[i] - 1, y[i]));
			return list;
		}
		boolean found = false;
		for (int j = i - 1; j >= 0; j--) {
			if (y[j] == x[i]) {
				found = true;
				for (int k = 0; k < xylist.get(j).size(); k++) {
					list.add(xylist.get(j).get(k) + s.substring(y[i] - 1, y[i]));
				}
			}
		}
		if (found)
			return list;

		list.add(s.substring(x[i] - 1, x[i]) + s.substring(y[i] - 1, y[i]));
		return list;
	}
}
