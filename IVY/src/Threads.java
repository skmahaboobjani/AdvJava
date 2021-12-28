public class Threads extends Thread {
    public static void main(String[] args)
    {
        Thread t = Thread.currentThread();   
        t.setPriority(MAX_PRIORITY);       
        for (int i = 0; i <40; i++) {
        	if(i%2==0)
            System.out.println(" Main thread "+i);
        }
        Thread ct = new Thread() {
            // run() method of a thread
            public void run()
            {
 
                for (int i = 1; i <=10; i++) {
                    System.out.println("5"+"*"+i+" = "+(5*i));
                }
            }
        };
        ct.setPriority(MAX_PRIORITY);
        ct.start();
    }
}