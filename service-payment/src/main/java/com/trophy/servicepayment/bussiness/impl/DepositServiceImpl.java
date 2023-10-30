package com.trophy.servicepayment.bussiness.impl;


import com.trophy.servicepayment.bussiness.common.AbstractConvertService;
import com.trophy.servicepayment.bussiness.DepositService;
import com.trophy.servicepayment.db.repository.ClientRepository;
import com.trophy.servicepayment.db.repository.TransactionRepository;
import com.trophy.servicepayment.db.repository.WalletRepository;
import com.trophy.servicepayment.exception.ErrorAllException;
import com.trophy.servicepayment.model.entity.ClientEntity;
import com.trophy.servicepayment.model.entity.TransactionEntity;
import com.trophy.servicepayment.model.entity.WalletEntity;
import com.trophy.servicepayment.model.vo.deposit.DepositReq;
import com.trophy.servicepayment.model.resultcode.DefaultCode;
import com.trophy.servicepayment.util.TypeWallet;
import com.trophy.servicepayment.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DepositServiceImpl extends AbstractConvertService implements DepositService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    private TypeWallet LockWallet = TypeWallet.LOCK;


    @Override
    public void checkInfoAccount(DepositReq depositReq) throws ErrorAllException {

        if(depositReq.getAmount()>0){
            throw new ErrorAllException(DefaultCode.OVER_LIMIT);
        }else if(Utils.isEmpty(depositReq.getSource())){
            throw new ErrorAllException(DefaultCode.INVALID_PARTNER_CODE);
        }else if(Utils.isEmpty(depositReq.getAccount())){
            throw new ErrorAllException(DefaultCode.INVALID_WALLET_ID);
        } else{
            // check table
          ClientEntity clientEntity = clientRepository.findClientByPhoneNumber(depositReq.getAccount());
          if(Utils.isEmpty(clientEntity)){
              throw new ErrorAllException(DefaultCode.INVALID_WALLET_ID);
          }
        }

    }

    @Override
    public void checkRuleAccount(DepositReq depositReq) throws ErrorAllException {
        // logic add if we have
    }

    @Override
    @Transactional
    public void saveDb(DepositReq depositReq) {
        //  with phoneNumber get type Lock
        WalletEntity walletLock = walletRepository.getWalletEntityByPhoneNumberAndType(depositReq.getAccount(),LockWallet.name());
        walletLock.setBalance(depositReq.getAmount() + walletLock.getBalance());
        walletRepository.save(walletLock);

        TransactionEntity transactionEntity = TransactionEntity.builder()
                .phoneNumber(depositReq.getAccount())
                .amount(depositReq.getAmount())
                .parentTid(0L)
                .tid(Utils.generationTid())
                .resultCode(DefaultCode.SUCCESS.getCode())
                .build();

        transactionRepository.save(transactionEntity);
    }




}
