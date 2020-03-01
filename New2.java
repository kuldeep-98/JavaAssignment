import java.util.Scanner;

public class New2{
	public static void main(String[] agrs){
		Scanner read = new Scanner(System.in);
		int n;
		System.out.println("Enter number of rows");
		n=read.nextInt();
		for(int i=1;i<=n;i++){		
			for(int k=n-i;k>0;k--){
				System.out.print("  ");
					
			}	
			for(int j=1;j<=2*i-1;j++){
				System.out.print("* ");	
			}
		System.out.println();		
		}
		for(int i=n-1;i>=1;i--){		
			for(int k=i;k<n;k++){
				System.out.print("  ");
					
			}	
			for(int j=2*i-1;j>0;j--){
				System.out.print("* ");	
			}
		System.out.println();		
		}
	}
}
