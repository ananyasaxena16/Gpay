package Entities;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    private int user1ID;
    private int user2ID;
    private BigDecimal amt;
    private Date date;

    public Transaction(int userId1, int userId2, BigDecimal amt, Date date)
    {
        this.amt=amt;
        this.user1ID=userId1;
        this.user2ID=userId2;
        this.date=date;
    }

    private Integer getUser1ID()
    {
        return user1ID;
    }
    private Integer getUser2ID()
    {
        return user2ID;
    }

    private BigDecimal getAmt()
    {
        return amt;
    }
    Date getDate()
    {
        return date;
    }
    private void setUser1ID(Integer userId1)
    {
        this.user1ID=userId1;
    }
    private void setUser2ID(Integer userId2)
    {
        this.user2ID=userId2;
    }
    private void setAmt(BigDecimal amt)
    {
        this.amt=amt;
    }
    private void setDate(Date setDate)
    {
        this.date=date;
    }

    @Override
    public String toString()
    {
        return "User 1 account no: "+ user1ID+" to "+" User 2 account no: "+ user1ID+" amount-> "+amt+" Date: "+date;
    }



}

