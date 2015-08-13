package week1;

public class Node {
    public int value;
    public Node left;
    public Node right;

    Node(Node left, Node right, int value){
        this.value  = value;
        this.left = left;
        this.right = right;
    }

    private boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;

    }

    public void search (){
        if(isPrime(value)) System.out.println(value);
        if(right!=null) right.search();
        if(left!=null) left.search();
    }

    public static void main(String[] args){
        Node node_17=new Node(null,null,17);

        Node node_9= new Node(null,node_17,9);
        Node node_3= new Node(node_9,null,3);


        Node node_11= new Node(null,null,11);
        Node node_4= new Node(node_11,null,4);
        Node node_5= new Node(null,null,5);
        Node node_12= new Node(node_4,node_5, 12);

        Node node_root= new Node(node_3,node_12,5);
        node_root.search();
    }
}
