package DB;

import Entities.Account;
import java.util.HashMap;

public class WalletDao {

    private HashMap<Integer, Account> walletInfo;

    public WalletDao()
    {
        this.walletInfo= new HashMap<>();
    }

    public void setWalletInfo(HashMap<Integer, Account> walletInfo) {
        this.walletInfo = walletInfo;
    }
    public HashMap<Integer, Account> getWalletInfo() {
        return walletInfo;
    }
}
