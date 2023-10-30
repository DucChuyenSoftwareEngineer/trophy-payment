package com.trophy.servicepayment.bussiness.common;

import com.trophy.servicepayment.model.entity.WalletEntity;
import com.trophy.servicepayment.model.vo.account.AccountReq;
import com.trophy.servicepayment.model.vo.deposit.DepositReq;
import com.trophy.servicepayment.util.TypeWallet;

public abstract class AbstractConvertService {

    protected WalletEntity convertFromAccountReqToWalletEntity(AccountReq accountReq, TypeWallet typeWallet){
         return  WalletEntity.builder()
                 .phoneNumber(accountReq.getAccount())
                 .balance(0L)
                 .type(typeWallet.name())
                 .build();
    }

    protected WalletEntity covertFromDepositReqToWalletEntity(DepositReq depositReq){
            return WalletEntity.builder()
                    .phoneNumber(depositReq.getAccount())
                    .type(depositReq.getSource())
                    .balance(depositReq.getAmount())
                    .build();
    }



}
