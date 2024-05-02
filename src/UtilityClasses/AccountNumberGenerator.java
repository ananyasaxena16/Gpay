package UtilityClasses;

public class AccountNumberGenerator {
    private static int accountNo=10001;
    public static int setAccountNo()
    {
        return accountNo++;
    }
}
