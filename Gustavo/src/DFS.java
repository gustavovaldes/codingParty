import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DFS {
    public static List<List<Integer>> G = new ArrayList<List<Integer>>(875715);
    public static List<List<Integer>> G_rev = new ArrayList<List<Integer>>(875715);
    public static boolean[] explored = new boolean[875715];
    public static int[] F = new int[875715];
    public static int[] newLabel = new int[875715];
    public static int[] leader = new int[875715];
    public static Integer[] leader_size = new Integer[875715];
    public static int t=0;
    public static int S=0;

    public static void DFS(List<List<Integer>> G, int i) {
        explored[i]=true;
        leader[i]=S;
        for(int j : G.get(i)) {
            if(!explored[j]) {
                DFS(G,j);
            }
        }
        t++;
        F[i]=t;
    }

    public static void DFS_loop(List<List<Integer>> G) {
        t=S=0;
        for(int i=875714;i>=1;i--) {
            if(!explored[i]) {
                S=i;
                DFS(G,i);
                //System.out.println(i);
            }
        }
    }

    public static void DFS_loop2(List<List<Integer>> G) {
        t=S=0;
        for(int i=875714;i>=1;i--) {explored[i]=false;leader[i]=0;}
        for(int i=875714;i>=1;i--) {
            if(!explored[newLabel[i]]) {
                S=newLabel[i];
                DFS(G,newLabel[i]);
                //System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        int i,j;
        File inFile = new File("/Users/Gustavo/Cursos/AnalysisAlg1/SCC.txt");
        G.add(new ArrayList<Integer>());
        G_rev.add(new ArrayList<Integer>());
        Scanner in = new Scanner(inFile);
        for(i=1;i<=875714;i++) {
            G.add(new ArrayList<Integer>());
            G.get(i).add(i);
            G_rev.add(new ArrayList<Integer>());
            G_rev.get(i).add(i);
        }
        while(in.hasNextLine()) {
            String s = in.nextLine();
            String[] edge = s.split(" ");
            //System.out.println(edge[0]+" "+edge[1]);
            G.get(Integer.parseInt(edge[0])).add(Integer.parseInt(edge[1]));
            G_rev.get(Integer.parseInt(edge[1])).add(Integer.parseInt(edge[0]));
        }
        System.out.println("Successfully loaded G and G_rev");
        DFS_loop(G_rev);
        System.out.println("DFS Loop of G_rev complete");
        for(int k=0;k<875715;k++) {
            newLabel[F[k]] = k;
            leader_size[k] = 0;
            //System.out.println(k+" "+F[k]);
        }
        DFS_loop2(G);
        for(int k=1;k<875715;k++) {
            leader_size[leader[k]]++;
        }
        Arrays.sort(leader_size, Collections.reverseOrder());
        for(int k=0;k<5;k++) System.out.println(leader_size[k]);
    }
}