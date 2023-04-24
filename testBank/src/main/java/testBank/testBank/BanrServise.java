package testBank.testBank;

import org.springframework.stereotype.Service;
import testBank.testBank.model.TransferBalance;

import java.math.BigDecimal;

@Service
public class BanrServise {

    public BigDecimal getBalance(long accounteiId) {
        return null;
    }

    public BigDecimal addMoney(Long to, BigDecimal amount) {
        return null;
    }

    public void makeTransfer(TransferBalance transferBalance) {
    }
}
