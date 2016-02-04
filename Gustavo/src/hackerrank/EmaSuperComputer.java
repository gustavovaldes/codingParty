package hackerrank;

/**
 * Created by guga
 */

import org.junit.Test;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class EmaSuperComputer {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.nextLine();
        char[][] map = new char[x][y];
        for(int i=0; i<x; i++){
            String word = sc.nextLine();
            map[i]=word.toCharArray();
        }
        /*for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println(find(map,1,1,x,y)); //assert 0
        System.out.println(find(map,3,2,x,y)); //assert 0
        System.out.println(find(map,0,1,x,y)); //assert 1
        System.out.println(find(map,2,4,x,y)); //assert 5*/
        int a1 = 0;
        int a2 = 0;
        int x1=-1;
        int y1=-1;
        int x2=-1;
        int y2=-1;
        TreeSet<Result> results = new TreeSet<>();
        for(int i=1; i<x;i++){
            for(int j=1; j<y; j++){
                int s = find(map, i,j,x,y);
                //results.add(new Result(i,j,s));
            }
        }

        for(Result r: results){
            if(a1==0){
                a1 = r.result;
                x1 = r.x;
                y1 = r.y;
            }else{
                if(isValid(x1,y1,r.x,r.y,(a1-1)/4,(r.result-1)/4) && r.result>a2){
                    a2 = r.result;
                    x2 = r.x;
                    y2 = r.y;
                }
            }
        }

        System.out.println(a1*a2);

    }

    public static boolean isValid(int x1, int y1, int x2, int y2, int level1, int level2){
        if( x2>x1){
            if(x1+level1>x2-level2) return false;
        }else{
            if(x2+level2>x1-level1) return false;
        }

        if( y2>y1){
            if(y1+level1>y2-level2) return false;
        }else{
            if(y2+level2>y1-level1) return false;
        }
        return true;
    }

    public static int find(char[][] map, int x, int y, int xBorder, int yBorder) {
        if (map[x][y] == 'B') return 0;
        int level = 1;
        while (true) {
            if (((x - level) >= 0 && map[x - level][y] == 'G') && //left
                    ((x + level) < xBorder && map[x + level][y] == 'G') && //rigth
                    ((y - level) >= 0 && map[x][y - level] == 'G') &&  //bottom
                    ((y + level) < yBorder && map[x][y + level] == 'G')) {//top
                level++;
            } else {
                break;
            }
        }
        return (level - 1) * 4 + 1;
    }

    @Test
    public void test() {
        char[][] map = new char[][]{
                {'G', 'G', 'G', 'G', 'G', 'G'},
                {'G', 'B', 'B', 'B', 'G', 'B'},
                {'G', 'G', 'G', 'G', 'G', 'G'},
                {'G', 'G', 'B', 'B', 'G', 'B'},
                {'G', 'G', 'G', 'G', 'G', 'G'}
        };
        System.out.println(find(map, 2, 4, 5, 6));
        int a1 = 0;
        int a2 = 0;
        int x1, y1, x2, y2;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 6; j++) {
                int s = find(map, i, j, 5, 6);
                if (s >= a1) {
                    a1 = s;
                    x1 = i;
                    y1 = j;
                } else if (s >= a2 && a1 > 0) {
                    a2 = s;
                    x2 = i;
                    y2 = j;
                }
            }
        }
        System.out.println(a1 * a2);
    }

    @Test
    public void test2() {
        char[][] map = new char[][]{
                {'B', 'G', 'B', 'B', 'G', 'B'},
                {'G', 'G', 'G', 'G', 'G', 'G'},
                {'B', 'G', 'B', 'B', 'G', 'B'},
                {'G', 'G', 'G', 'G', 'G', 'G'},
                {'B', 'G', 'B', 'B', 'G', 'B'},
                {'B', 'G', 'B', 'B', 'G', 'B'},
        };
        System.out.println(find(map, 2, 4, 6, 6));
        int a1 = 0;
        int a2 = 0;
        int x1, y1, x2, y2;
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                int s = find(map, i, j, 6, 6);
                if (s > a1) {
                    a1 = s;
                    x1 = i;
                    y1 = j;
                } else if (s >= a2 && a1 > 0) {
                    a2 = s;
                    x2 = i;
                    y2 = j;
                }
            }
        }
        System.out.println(a1 * a2);
    }


    class Result implements Comparator<Result>{
        public int x;
        public int y;
        public int result;

        public Result(int x, int y, int n){
            this.x= x;
            this.y= y;
            this.result = n;

        }

        public int compare(Result x, Result y){
            return x.result - y.result;
        }
    }
}
