package week1;

import java.util.Arrays;

public class QuickFind {

	private int[] elements;
	private int size;
	
	public static void main(String[] args) {
		QuickFind qf = new QuickFind(10);
		qf.union(4,8);
		qf.union(3,9);
		qf.union(7,3);
		qf.union(6,1);
		qf.union(0,2);
		qf.union(6,5);
		System.out.println(Arrays.toString(qf.elements));
	}
	
	public QuickFind(int N) {
		elements = new int[N];
		size = N;
		for (int i = 0; i < N; i++) {
			elements[i]=i;
		}
	}

	public void union(int p, int q){
		int pid = elements[p];
		int qid = elements[q];
		for (int i = 0; i < size; i++) {
			if(elements[i]==pid) elements[i]=qid;
		}
	}
	
	public boolean isConnected(int p, int q){
		return elements[p]==elements[q];
	}
}
