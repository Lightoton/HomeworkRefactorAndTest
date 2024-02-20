package TestThreads;

/**
 * wait - free M  and wait
 * notify - wake up -> wait()
 * notifyAll()
 */
public class W1 {
    public static void main(String[] args) {
        Market market = new Market();

        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);
        Deliver deliver = new Deliver(market);

        Thread T1 = new Thread(producer);
        Thread T2 = new Thread(consumer);
        Thread T3 = new Thread(deliver);

        T1.start();
        T2.start();
        T3.start();
    }
}

class Market {
    private int item = 0;
    private int itemStorage = 5;
    private int itemDelivery = 0;
    public synchronized void deliverItem(){
        while (itemStorage < 1){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        itemDelivery++;
        itemStorage--;
        System.out.println("the delivery man delivered to the market and began unloading: "+ " || " + "item's count: " + itemDelivery);
        notify();

    }
    public synchronized void putItem() {
        while (itemDelivery < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        item++;
        itemDelivery--;
        System.out.println("a factory has put one item into the market" + " || " + "item's count: " + item + " -> " + itemDelivery);
        notify();
    }

    public synchronized void getItem() {
        while (item < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        item--;
        itemStorage++;
        System.out.println("a person has bought one item" + " || " + "item's count: " + item + " -> " + Thread.currentThread().getName());
        notify();
    }




}

class Producer implements Runnable {
    Market market;

    public Producer(Market market) {
        this.market =market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putItem();
        }
    }
}

class Consumer implements Runnable {
    Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getItem();
        }
    }
}
class Deliver implements Runnable{
    Market market;

    public Deliver(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.deliverItem();
        }
    }
}