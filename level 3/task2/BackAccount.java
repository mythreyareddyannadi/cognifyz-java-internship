class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        System.out.println(Thread.currentThread().getName() + " is depositing $" + amount);
        balance += amount;
        System.out.println("New balance after deposit: $" + balance);
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is withdrawing $" + amount);
            balance -= amount;
            System.out.println("New balance after withdrawal: $" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " cannot withdraw $" + amount + " (Insufficient balance)");
        }
    }

    public double getBalance() {
        return balance;
    }
}