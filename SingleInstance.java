
class Singleton{
    private static Singleton single=null;
    public String s;

    private Singleton(){
        s="Hello i'm here";
    }

    public static Singleton getInstance(){
        if(single==null)
            single = new Singleton();
        return single;
    }
}

class SingleInstance{
    public static void main(String[] args) {
        Singleton x = Singleton.getInstance();
        Singleton y = Singleton.getInstance();
        x.s = (x.s).toUpperCase();
        System.out.println("X instance"+x.s);
        System.out.println("y instance"+y.s);
        //System.out.println("Z instance"+z.s);
    }
}