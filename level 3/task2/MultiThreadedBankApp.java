public class MultiThreadedBankApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread thread1 = new Thread(new TransactionRunnable(account, true, 200), "Thread-1");
        Thread thread2 = new Thread(new TransactionRunnable(account, false, 500), "Thread-2");
        Thread thread3 = new Thread(new TransactionRunnable(account, true, 300), "Thread-3");
        Thread thread4 = new Thread(new TransactionRunnable(account, false, 1000), "Thread-4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Final balance: $" + account.getBalance());
    }
}