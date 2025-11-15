class PrintNumbers {
    public synchronized void printOdd() throws InterruptedException{
        for(int i = 1 ;i <= 15; i++) {
        	if(i % 2 != 0) {
        		System.out.println("Odd: "+ i);
                Thread.sleep(500);
        	}
        } 
    }

    public synchronized void printEven() throws InterruptedException{
    	for(int i = 1 ;i <= 15; i++) {
        	if(i % 2 == 0) {
        		System.out.println("Even: "+ i);
                Thread.sleep(500);
        	}
        } 
    }
}

class OddThread extends Thread {
    public PrintNumbers oddNumbers;
    public OddThread(PrintNumbers oddNumbers) {
        this.oddNumbers = oddNumbers;
    }
    @Override
    public void run() {
    	try {
        oddNumbers.printOdd();
    	}catch(InterruptedException ie) {
    		ie.getMessage();
    	}
    }
}

class EvenThread extends Thread {
   public PrintNumbers evenNumbers;
    public EvenThread(PrintNumbers evenNumbers) {
        this.evenNumbers = evenNumbers;
    }
    @Override
    public void run() {
    	try {
        evenNumbers.printEven();
    	}catch(InterruptedException ie) {
    		ie.getMessage();
    	}
    }
}

public class MultiThreading {
    public static void main(String[] args) {
        PrintNumbers pn = new PrintNumbers();

        OddThread t1 = new OddThread(pn);
        EvenThread t2 = new EvenThread(pn);

        t1.start();
        t2.start();
    }
}
