package algs1princ.week1;

import org.junit.Assert;

/**
 * Created by guga
 *
 * initialize : N
 * find(connected): 1 constant
 * union:  N (for N unions is N^2)  (too expensive)
 */
public class QuickFind {

    private int[] id;
    private int N;
    public QuickFind(int N){
        id = new int[N];
        this.N = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q){
        return(id[p] == id[q]);
    }

    public void union(int p, int q){
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < N; i++) {
            if(id[i]==pid) id[i]=qid;
        }
    }

    public static void main(String args[]){
        QuickFind qf = new QuickFind(10);
        qf.union(0,2);
        qf.union(3,5);
        qf.union(6,7);
        qf.union(6,5);

        Assert.assertTrue(qf.connected(0,2));
        Assert.assertTrue(qf.connected(3,5));
        Assert.assertTrue(qf.connected(6,7));
        Assert.assertTrue(qf.connected(5,6));
        Assert.assertTrue(qf.connected(6,3));
        Assert.assertFalse(qf.connected(0,3));
        Assert.assertFalse(qf.connected(1,7));
        Assert.assertFalse(qf.connected(8,9));
    }
}