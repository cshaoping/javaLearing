package threads;

public class MyThreads extends Thread{
    private Thread t;
    private String threadName;

    MyThreads(String name)
    {
        threadName = name;
        System.out.println("Creating " + threadName);
    }
    public void run()
    {
        System.out.println("Running " + threadName);
        try{
            for(int i = 4; i > 0; i--){
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(5);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread " + threadName + "exiting.");
    }
    public void start()
    {
        System.out.println("Starting " + threadName);
        if(t == null){
            t = new Thread(this, threadName);
            t.start();
        }
    }

    public static void main(String[] args){
        MyThreads th1 = new MyThreads("thread-1");
        MyThreads th2 = new MyThreads("thread-2");
        th1.start();
        th2.start();
        System.out.println("run over.");
    }
}
