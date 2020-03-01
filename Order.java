import java.util.Arrays;
import java.util.Scanner;

class Order{
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String str = read.nextLine();
        String[] s = str.split(" ");
        String t;
        for(int i=0;i<s.length;i++){
            for(int j=i;j<s.length;j++){
                if(s[i].compareTo(s[j])>0){
                   t = s[i];
                   s[i]= s[j];
                   s[j] =t;
                }
            }
        }
        //Arrays.sort(s);
        for(String a: s) System.out.print(a+" ");
        
    }
}
