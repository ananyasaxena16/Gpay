package Services;

import DB.WalletDao;
import Entities.Account;
import Entities.Transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

public class GpayService {

    private WalletDao dao;
    public GpayService()
    {
        dao = new WalletDao();
    }
    public void CreateWallet(String name, BigDecimal balance)
    {
       Account account = new Account(name, balance);
       dao.getWalletInfo().put(account.getAccountNumber(), account);
       System.out.println("Account created for "+ name + ". \n Congrats!");
    }
    public void TransferAmount(int fromAccNum, int toAccNum, BigDecimal transferAmount)
    {
        if(!validate(fromAccNum, toAccNum, transferAmount)) {
            return;
        }

        Transaction tran = new Transaction(fromAccNum, toAccNum, transferAmount, new Date());
        Account fromAccount = dao.getWalletInfo().get(fromAccNum);
        Account toAccount = dao.getWalletInfo().get(toAccNum);
        if(fromAccount.getBalance().compareTo(transferAmount) < 0) {
            System.out.println("Insufficient Balance");
            return;
        }

        fromAccount.setBalance(fromAccount.getBalance().subtract(transferAmount));
        toAccount.setBalance(toAccount.getBalance().add(transferAmount));
        fromAccount.getTransactionSet().add(tran);
        toAccount.getTransactionSet().add(tran);
        System.out.println("Transfer Successful");
    }

    private boolean validate(int fromAccNum, int toAccNum, BigDecimal transferAmount) {
        if(fromAccNum == toAccNum) {
            System.out.println("Sender and Receiver cannot be same.");
            return false;
        }
        if (transferAmount.compareTo(new BigDecimal(0.0001)) < 0) {
            System.out.println("Amount too low");
            return false;
        }
        if (!dao.getWalletInfo().containsKey(fromAccNum)) {
            System.out.println("Invalid Sender account number");
            return false;
        }
        if (!dao.getWalletInfo().containsKey(toAccNum)) {
            System.out.println("Invalid Receiver account number");
            return false;
        }
        return true;
    }

    public void statement(int accountNum) {
        Account account = dao.getWalletInfo().get(accountNum);
        if(account == null) {
            System.out.println("Invalid Account Number");
            return;
        }
        System.out.println("Summary for account number: " + accountNum);
        System.out.println("Current Balance: " + account.getBalance());
        System.out.println("Your Transaction History");
        System.out.println(account.getTransactionSet());
    }
    public void overview() {
        for (int accNum : dao.getWalletInfo().keySet()) {
            System.out.print("Balance for account number " + accNum + ": ");
            System.out.println(dao.getWalletInfo().get(accNum).getBalance());
        }
    }
}
