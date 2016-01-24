package algs1princ.week1;


import org.junit.Assert;

/**
 * Created by guga
 *
 * initialize : N
 * find(connected): N (worst, tall tree)
 * union:  N
 */
public class QuickUnion {

    private int[] id;
    private int N;
    public QuickUnion(int N){
        id = new int[N];
        this.N = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q){
        return(root(p) == root(q));
    }

    public void union(int p, int q){ //change root of p to point root of q
        int pRoot = root(p);
        int qRoot = root(q);
        id[pRoot] = qRoot;
    }

    public int root(int i){
        while(i!=id[i]){
            i= id[i];//chase parent until reach the root
        }
        return i;
    }


    public static void main(String args[]){
        QuickUnion qu = new QuickUnion(10);
        qu.union(0,2);
        qu.union(3,5);
        qu.union(6,7);
        qu.union(6,5);

        Assert.assertTrue(qu.connected(0,2));
        Assert.assertTrue(qu.connected(3,5));
        Assert.assertTrue(qu.connected(6,7));
        Assert.assertTrue(qu.connected(5,6));
        Assert.assertTrue(qu.connected(6,3));
        Assert.assertFalse(qu.connected(0,3));
        Assert.assertFalse(qu.connected(1,7));
        Assert.assertFalse(qu.connected(8,9));
    }
}
