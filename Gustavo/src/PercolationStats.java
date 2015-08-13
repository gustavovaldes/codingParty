public class PercolationStats {

    public PercolationStats(int N, int T) {// perform T independent experiments on an N-by-N grid
        if(N<=0 || T<=0) throw  new IllegalArgumentException();
    }
    public double mean(){// sample mean of percolation threshold
        return 0d;
    }
    public double stddev(){// sample standard deviation of percolation threshold
        return 0d;
    }
    public double confidenceLo(){  // low  endpoint of 95% confidence interval
        return 0d;
    }
    public double confidenceHi(){// high endpoint of 95% confidence interval
        return 0d;
    }

    public static void main(String[] args){// test client (described below)

    }
}