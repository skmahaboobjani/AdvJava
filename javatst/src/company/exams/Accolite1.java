package company.exams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Accolite1 {

	public Accolite1() {

	}

	public static void main(String args[]) {

		int n = 10; // no of nodes
		int m = 10; // length of x and y i.e Direct edge betwenn two nodes
		String s = "aeabadcxyz";
		int[] x = { 1, 1, 3, 3, 6, 4, 4, 7, 8, 9 };
		int[] y = { 2, 3, 6, 4, 7, 7, 5, 2, 9, 10 };
		System.out.println(" Result ---> " + beaty(n, m, s, x, y));

	}

	public static int beaty(int n, int m, String s, int[] x, int[] y) {

		HashMap<Integer, List<String>> hm = new HashMap<Integer, List<String>>(m*2);
		
		//System.out.println(hm.size());

		for (int i = 0; i < m; i++) {
			List<String> strings = preString(i, x, y, s, hm);

			if (!hm.containsKey(y[i])) {
				hm.put(y[i], strings);
			} else {
				for (int k = 0; k < strings.size(); k++) {
					String str = strings.get(k);
					hm.get(y[i]).add(str);
				}
			}
		}
		int max=-1;
		for(int i=m;i>0;i--)
		{
			if(hm.containsKey(i))
			{
				List<String> list= hm.get(i);
				for(String str:list)
				{
					System.out.println(str);
					if(max<s.length())
					{
						int val = dupcount(s);
						if (max < val) {
							max = val;
						}
					}
					
				}
			}
			
		}

		return max;
	}

	public static int dupcount(String s) {
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

	public static List<String> preString(int i, int[] x, int[] y, String s, HashMap<Integer, List<String>> hm) {

		List<String> list = new ArrayList<String>();
		if (i == 0 && x.length >= 1) {
			list.add(s.substring(x[i] - 1, x[i]) + s.substring(y[i] - 1, y[i]));
			//printList(list);
			return list;
		}

		if (hm.containsKey(x[i])) {
			for (int k = 0; k < hm.get(x[i]).size(); k++) {
				list.add(hm.get(x[i]).get(k) + s.substring(y[i]-1, y[i]));
			}
			//return hm.get(x[i]);
			return list;
		}

		list.add(s.substring(x[i] - 1, x[i]) + s.substring(y[i] - 1, y[i]));
		return list;

	}
	
	public static void printList(List<String> list)
	{
		for(String str:list)
		{
			System.out.println(str);
		}
	}

}
