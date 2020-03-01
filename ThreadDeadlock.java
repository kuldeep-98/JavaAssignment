
class resource{
    public static String resource1 = "Resource1";
    public static String resource2 = "Resource2";
}

class Thread1 extends Thread{
    public void run(){
        synchronized (resource.resource1){
            System.out.println("Thread1 holds resource 1");
            try{
                Thread.sleep(10);
            }catch(Exception e){}
            System.out.println("Thread 1 waiting for resource 2");
            synchronized (resource.resource2){
                System.out.println("Thread1 holds Resource 2");
            }
        }
	for(int i=0;i<20;i++){
		System.out.println("thread 1 is printing");
	}
    }
}

class Thread2 extends Thread{
    public void run(){
        synchronized (resource.resource2){
            System.out.println("Thread2 holds resource 2");
            try{
                Thread.sleep(10);
            }catch(Exception e){}
            System.out.println("Thread2 waiting for resource 1");
            synchronized (resource.resource1){
            System.out.println("Thread2 holds resource 1");
            }

        }
	for(int i=0;i<20;i++){
		System.out.println("thread 2 is printing");
	}
    }
}

public class ThreadDeadlock{
    // public static String resource1 = "Resource1";
    // public static String resource2 = "Resource2";
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start();
        t2.start();
    }
}
