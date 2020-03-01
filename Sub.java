
import java.util.Scanner;

public class Sub{
	public static void main(String[] args){
		String str,sub,tstr;
		StringBuilder nStr = new StringBuilder();
		Scanner read = new Scanner(System.in);
		System.out.println("Enter String");		
		str = read.nextLine();
		System.out.println("Your String Is ");
		System.out.println(str);	
		System.out.println("Enter the word you want to change");
		sub = read.nextLine();
		System.out.println("Enter word");
		tstr = read.nextLine();
		// String[] arrStr = str.split(" ");
		// for (int i = 0;i<arrStr.length;i++){
		// 	if(arrStr[i].equalsIgnoreCase(sub)){
		// 		arrStr[i]=tstr;
		// 	}
		// 	nStr.append(arrStr[i]);
		// 	nStr.append(" ");
		// }
		
		for(int j=0;j<str.length();j++){
			int i = 0;			
			if(str.indexOf(sub)<0)
				break;
			else
			  i = str.indexOf(sub);
			//System.out.println(i);
			str = str.substring(0,i) + tstr + str.substring(sub.length()+i,str.length());
			
		}
		System.out.println(str);
		//System.out.println(nStr);
	}
}
