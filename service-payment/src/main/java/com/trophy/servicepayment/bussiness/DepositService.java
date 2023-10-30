package com.trophy.servicepayment.bussiness;


import com.trophy.servicepayment.exception.ErrorAllException;
import com.trophy.servicepayment.model.vo.deposit.DepositReq;

public interface DepositService {

    public void checkInfoAccount(DepositReq depositReq) throws ErrorAllException;

    public void checkRuleAccount(DepositReq depositReq) throws ErrorAllException;

    public void saveDb(DepositReq depositReq);

}
