import java.util.Scanner;

class BankAccount {
    private double saldo;

    public BankAccount(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void deposit(double amount) {
        saldo += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > saldo) {
            System.out.println("Saldo tidak mencukupi.");
            return false;
        } else {
            saldo -= amount;
            return true;
        }
    }

    public void displaySaldo() {
        System.out.println("Saldo Anda sekarang: Rp" + String.format("%.2f", saldo));
    }
}

public class Atm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(0);

        while (true) {
            // Menu
            System.out.println("Menu:");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Deposit");
            System.out.println("3. Tarik Tunai");
            System.out.println("4. Transfer");
            System.out.println("5. Keluar");

            // Input pilihan
            System.out.print("Pilihan Anda: ");
            int choice = sc.nextInt();

            // Proses
            switch (choice) {
                case 1:
                    // Cek saldo
                    account.displaySaldo();
                    break;
                case 2:
                    // Deposit
                    System.out.print("Masukkan jumlah deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit sejumlah Rp" + String.format("%.2f", depositAmount) + " berhasil.");
                    account.displaySaldo();
                    break;
                case 3:
                    // Tarik tunai
                    System.out.print("Masukkan jumlah penarikan: ");
                    double withdrawAmount = sc.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Penarikan sejumlah Rp" + String.format("%.2f", withdrawAmount) + " berhasil.");
                        account.displaySaldo();
                    }
                    break;
                case 4:
                    // Transfer
                    System.out.print("Masukkan jumlah transfer: ");
                    double transferAmount = sc.nextDouble();
                    if (account.withdraw(transferAmount)) {
                        System.out.print("Masukkan nomor rekening tujuan: ");
                        String recipientAccount = sc.next();
                        // Proses transfer ke rekening lain
                        // ...
                        System.out.println("Transfer sejumlah Rp" + String.format("%.2f", transferAmount) +
                                " ke rekening " + recipientAccount + " berhasil.");
                        account.displaySaldo();
                    }
                    break;
                case 5:
                    // Keluar
                    System.out.println("Terima kasih telah menggunakan ATM. Sampai jumpa!");
                    System.exit(0);
                    break;
                default:
                    // Pilihan tidak valid
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}