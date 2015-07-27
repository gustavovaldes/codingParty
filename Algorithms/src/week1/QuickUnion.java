package week1;

import java.util.Arrays;

public class QuickUnion {

	private int[] elements;

	public static void main(String[] args) {
		QuickUnion qu = new QuickUnion(10);
		/*4-8 3-5 9-7 2-4 4-6 0-4 7-3 4-3 3-1*/
		qu.union(4,8);
		qu.union(3,5);
		qu.union(9,7);
		qu.union(2,4);
		qu.union(4,6);
		qu.union(0,4);
		qu.union(7,3);
		qu.union(4,3);
		qu.union(3,1);
		System.out.println(Arrays.toString(qu.elements));
	}
	
	public QuickUnion(int N) {
		elements = new int[N];
		for (int i = 0; i < N; i++) {
			elements[i] = i;
		}
	}

	private int root(int i) {
		while (i != elements[i])
			i = elements[i];
		return i;
	}

	public boolean isConnected(int p, int q) {
		return root(p) == root(q);
	}

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		elements[i] = j;
	}
}
