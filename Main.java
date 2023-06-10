public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();

        EvenThread evenThread = new EvenThread(printer);
        OddThread oddThread = new OddThread(printer);

        evenThread.start();
        oddThread.start();
    }
}

class Printer {
    static int count = 1;
    public  synchronized int getCount()
    {
        return count;
    }

    public synchronized void printEven() {
        try {
            while (count % 2 != 0) {
                wait();
            }
            System.out.println(count);
            count++;
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printOdd() {
        try {
            while (count % 2 == 0 ) {
                wait();
            }
            System.out.println(count);
            count++;
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class EvenThread extends Thread {
    private Printer printer;

    public EvenThread(Printer printer) {
        this.printer = printer;
    }

    public void run() {
        while (true) {
            
            if (printer.getCount() >= 8) {
                break;
            }
            printer.printEven();
        }
    }
}

class OddThread extends Thread {
    private Printer printer;

    public OddThread(Printer printer) {
        this.printer = printer;
    }

    public void run() {
        while (true) {
            
            if (printer.getCount() >= 8) {
                break;
            }
            printer.printOdd();
        }
    }
}
