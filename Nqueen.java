import java.util.Scanner;

class Queens{
    private Boolean place(int x[],int k,int i){
        for(int j=1;j<k;j++)
            if((x[j-1]==i) || (Math.abs(x[j-1]-i)==Math.abs(j-k) ) )
                return false;
        return true;
    }
    public void NQueens(int x[],int k,int n){
        for(int col=1; col<=n; col++){
            if(place(x,k,col)){
                x[k-1]=col;
                if(k==n) {
                    for (int j : x) {
                        System.out.print(j+"\t");
                    }
                System.out.println();
                }
                else NQueens(x,k+1, n);
            }
        }
    }
}

public class Nqueen{
    public static void main(String[] argd) {
	System.out.println("Enter the number of queens");
        Scanner read = new Scanner(System.in);
        int num = read.nextInt();
        int[] x = new int[num];
        Queens a = new Queens();
        a.NQueens(x, 1, num);
    }
}
