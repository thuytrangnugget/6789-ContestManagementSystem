//create a Thread by Extending a Thread Class

class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;

    public ThreadDemo(String name) {
        threadName = name;
        System.out.println("Tạo " + threadName);
    }
    
    public void run() {
        System.out.println("Thread " + threadName + " đang chạy");
        try {
            for (int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", "+ i);
            //Let the thread sleep for a while
            Thread.sleep(50);
            }
        } catch (Exception e) {
            System.out.println("Thread " + threadName + "catches an exception.");
        }
        System.out.println("Thread " + threadName + " thoát ra ngoài.");
    }
    
    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread (this, threadName);
            t.start();
        }
    }
    
    
}
public class TestThread {
    public static void main(String args[]) {
        ThreadDemo T1 = new ThreadDemo("Thread của Trang");
        T1.start();
        ThreadDemo T2 = new ThreadDemo("Cũng là thread của Trang");
        T2.start();
    }
}
