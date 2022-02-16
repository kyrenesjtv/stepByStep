package com.github.kyrenesjtv.stepbystep.designmodel.oo.ddd;

import com.github.kyrenesjtv.stepbystep.designmodel.exception.InsufficientBalanceException;
import com.github.kyrenesjtv.stepbystep.designmodel.exception.InvalidAmountException;

import java.math.BigDecimal;

/**
 * @author huojianxiong
 * @Description 充血模型
 * @Date 2022/2/16 11:05
 */
public class VirtualWallet {

    private Long id;
    private Long createTime = System.currentTimeMillis();
    private BigDecimal balacne = BigDecimal.ZERO;

    public VirtualWallet(Long preAllocatedId) {
        this.id = preAllocatedId;
    }

    public BigDecimal balance() {
        return this.balacne;
    }

    //借贷
    public void debit(BigDecimal amount) throws InsufficientBalanceException {
        if (this.balacne.compareTo(amount) < 0) {
            throw new InsufficientBalanceException("借贷金额不允许超出余额");
        }
        this.balacne = this.balacne.subtract(amount);
    }

    //充值
    public void credit(BigDecimal amount) throws InvalidAmountException {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidAmountException("充值金额不能小于0");
        }
        this.balacne = this.balacne.add(amount);
    }


}
