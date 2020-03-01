import java.util.Scanner;

class change {
    public static int TWO_HUNDRED = 200;
    public static int HUNDRED = 100;
    public static int FIFTY = 50;
    public static int TWENTY = 20;
    public static int TEN = 10;
    public static int FIVE = 5;
    public static int TWO = 2;
    public static int ONE = 1;
}

public class ChangeReturn {
    private int itemPrice;
    private int amountPaid;
    private int balance;
    private int twoHundredCount = 0;
    private int hundredCount = 0;
    private int fiftyCount = 0;
    private int twentyCount = 0;
    private int tenCount = 0;
    private int fiveCount = 0;
    private int twoCount = 0;
    private int oneCount = 0;

    public ChangeReturn(int itemPrice, int amountPaid) {
        this.itemPrice = itemPrice;
        this.amountPaid = amountPaid;
    }

    public void calculate() {
        this.balance = amountPaid - itemPrice;
        if (balance<0){
            System.out.println("Plz Pay For The Item");
            return;
        }
        System.out.println("Balance Amount: "+balance);
        while (balance != 0) {
            if (balance >= change.TWO_HUNDRED) {
                twoHundredCount++;
                balance = balance - change.TWO_HUNDRED;
            }
            else if (balance >= change.HUNDRED) {
                hundredCount++;
                balance = balance - change.HUNDRED;
            }
            else if (balance >= change.FIFTY) {
                fiftyCount++;
                balance = balance - change.FIFTY;
            }
            else if (balance >= change.TWENTY) {
                twentyCount++;
                balance = balance - change.TWENTY;
            }
            else if (balance >= change.TEN) {
                tenCount++;
                balance = balance - change.TEN;
            }
            else if (balance >= change.FIVE) {
                fiveCount++;
                balance = balance % change.FIVE;
            }
            else if (balance >= change.TWO) {
                twoCount++;
                balance = balance - change.TWO;
            }
            else {
                oneCount++;
                balance = balance - change.ONE;
            }
        }

        System.out.println("---Your Change Is----");
        System.out.println(twoHundredCount +" coins of "+ change.TWO_HUNDRED);
        System.out.println(hundredCount +" coins of "+ change.HUNDRED);
        System.out.println(fiftyCount +" coins of "+ change.FIFTY);
        System.out.println(twentyCount +" coins of "+ change.TWENTY);
        System.out.println(tenCount +" coins of "+ change.TEN);
        System.out.println(fiveCount +" coins of "+ change.FIVE);
        System.out.println(twoCount +" coins of "+ change.TWO);
        System.out.println(oneCount +" coins of "+ change.ONE);
    }

    public static void main(String[] args) {
        int itemPrice;
        int amountPaid;
        Scanner read = new Scanner(System.in);
        System.out.print("Price of item: ");
        itemPrice = read.nextInt();
        System.out.print("Amount paid: ");
        amountPaid = read.nextInt();

        ChangeReturn ch = new ChangeReturn(itemPrice,amountPaid);
        ch.calculate();
    }
}
