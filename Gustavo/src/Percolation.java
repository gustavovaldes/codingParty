public class Percolation {



    private WeightedQuickUnionUF matrix;

    private boolean[] records;
    private boolean[][] full;

    private int N;



    public Percolation(int N) {               // create N-by-N grid, with all

        // sites blocked

        this.N = N;

        if (N <= 0) throw new IllegalArgumentException();

        matrix = new WeightedQuickUnionUF(N * N);

        records = new boolean[N * N];
        full = new boolean[N][N];

    }



    public static void main(String[] args) { // test client (optional)



    }


    private boolean fillFull(int i, int j) {
        if (full[i][j]) return true;
        if (i == 1) {
            full[i][j] = true;
            return true;
        }
        /*arriba*/
        if (i > 1) {
            fillFull(i - 1, j);
        }
        /*izq*/
        if (j > 1) {
            fillFull(i, j - 1);
        }
        /*derecha*/
        if (j < N) {
            fillFull(i, j + 1);
        }
        return false;
    }



    public void open(int i, int j) {// open site (row i, column j) if it is

        // not open already

        validateRange(i, j);

        int pos = calculatePosition(i, j);

        if(records[pos]) return;

        records[pos] = true;
        //if(i==1) full[pos] =true;

        int next = 0;

        /*arriba*/

        if (i > 1) {

            next = pos - N;

            if (records[next])

                matrix.union(pos, next);

        }



        /*abajo*/

        if (i < N) {

            next = pos + N;

            if (records[next])

                matrix.union(pos, next);

        }



        /*izquierda*/

        if (j > 1) {

            next = pos - 1;

            if (records[next])

                matrix.union(pos, next);

        }



        /*derecha*/

        if (j < N) {

            next = pos + 1;

            if (records[next])

                matrix.union(pos, next);

        }

    }



    public boolean isOpen(int i, int j) { // is site (row i, column j) open?

        validateRange(i, j);

        return records[calculatePosition(i, j)];

    }



    public boolean isFull(int i, int j) {// is site (row i, column j) full?

        int pos = calculatePosition(i, j);
        if(!isOpen(i,j)) return false;

        for (int k = 0; k < N; k++) {

            if(records[k] && matrix.connected(pos, k)) {
                //full[pos]=true;
                //full[k]=true;
                return true;
            }

        }

        return false;

    }



    public boolean percolates() { // does the system percolate?

        if(N==1) return records[0];
        for (int i = 0; i < N; i++) {

            for (int j = 1; j <= N; j++) {

                if (records[i] && records[calculatePosition(N, j)] && matrix.connected(i, calculatePosition(N, j)))

                    return true;

            }

        }
        return false;

    }



    private void validateRange(int i, int j) {

        if (i < 1 || i > N || j < 1 || j > N)

            throw new IndexOutOfBoundsException();

    }



    private int calculatePosition(int i, int j) {

        return (N) * (i - 1) + j - 1;

    }

}