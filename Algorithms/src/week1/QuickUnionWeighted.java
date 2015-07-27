package week1;

import java.util.Arrays;

public class QuickUnionWeighted {

	private int[] elements;
	private int[] size;

	public static void main(String[] args) {
		QuickUnionWeighted qu = new QuickUnionWeighted(10);
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
	
	public QuickUnionWeighted(int N) {
		elements = new int[N];
		size = new int[N];
		for (int i = 0; i < N; i++) {
			elements[i] = i;
			size[i]=1;
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
		int pId = root(p);
		int qId = root(q);
		if (pId == qId)
			return;
		if (size[pId] < size[qId]) {
			elements[pId] = qId;
			size[qId] += size[pId];
		} else {
			elements[qId] = pId;
			size[pId] += size[qId];
		}
	}
}
