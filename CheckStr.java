import java.util.Scanner;

class LessThan extends Exception{
    LessThan(String s){
        super(s);
    }
}

class ContainDig extends Exception{
    ContainDig(String s){
        super(s);
    }
}

class CheckStr{
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
	    System.out.println("Enter a string:");
        String name = read.nextLine();
        try{
            if(name.length()<5)
                throw new LessThan("Name sould be more than 5 char");
            if(!name.matches("[a-zA-Z]+")) {
                throw new ContainDig("String contains digit");
            }
        } catch(LessThan | ContainDig ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Your String is: "+ name);
    }
}
