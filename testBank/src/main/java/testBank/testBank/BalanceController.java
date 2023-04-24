package testBank.testBank;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import testBank.testBank.model.TransferBalance;

import java.math.BigDecimal;

@RestController("/balace")
@AllArgsConstructor
public class BalanceController {

    private final BanrServise banrServise;


    @GetMapping("/{accountId}")
    public BigDecimal getBalance(@PathVariable long accounteiId){
       return banrServise.getBalance(accounteiId);
    }

//    добавляем деньги
    @PostMapping("/add")
    public BigDecimal addMoney(@RequestBody TransferBalance transferBalance){
        return banrServise.addMoney(transferBalance.getTo(), transferBalance.getAmount());
    }
    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferBalance transferBalance){
        banrServise.makeTransfer(transferBalance);
    }
}
