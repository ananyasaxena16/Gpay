package Entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import UtilityClasses.AccountNumberGenerator;

public class Account {
    private int accountNo;
    private User user;
    private BigDecimal totalBalance;

    private Set<Transaction> transactionSet;

    public Account(String username, BigDecimal balance) {
        this.accountNo = AccountNumberGenerator.setAccountNo();
        this.user = new User(username);
        this.totalBalance = balance;
        this.transactionSet = new TreeSet<>((a, b) -> a.getDate().compareTo(b.getDate()));
    }

    @Override
    public String toString() {
        return "Acc no" + accountNo + " name:" + user.getUserName() + " id: " + user.getUserID() + " total_balance: " + totalBalance + "\ntransactions: " + transactionSet;
    }

    public int getAccountNumber() {
        return accountNo;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNo = accountNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getBalance() {
        return totalBalance;
    }

    public void setBalance(BigDecimal balance) {
        this.totalBalance = balance;
    }

    public Set<Transaction> getTransactionSet() {
        return transactionSet;
    }

    public void setTransactionSet(Set<Transaction> tranactions) {
        this.transactionSet = tranactions;
    }

}