package com.trophy.servicepayment.bussiness;

import com.trophy.servicepayment.exception.ErrorAllException;
import com.trophy.servicepayment.model.vo.account.AccountReq;

public interface WalletService {

    public void checkInfoAccount(AccountReq accountReq) throws ErrorAllException;

    public void saveDB(AccountReq accountReq);
}
