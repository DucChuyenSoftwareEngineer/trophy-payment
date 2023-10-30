package com.trophy.servicepayment.bussiness.impl;

import com.trophy.servicepayment.bussiness.WalletService;
import com.trophy.servicepayment.bussiness.common.AbstractConvertService;
import com.trophy.servicepayment.db.repository.ClientRepository;
import com.trophy.servicepayment.db.repository.WalletRepository;
import com.trophy.servicepayment.exception.ErrorAllException;
import com.trophy.servicepayment.model.entity.ClientEntity;
import com.trophy.servicepayment.model.entity.WalletEntity;
import com.trophy.servicepayment.model.vo.account.AccountReq;
import com.trophy.servicepayment.util.TypeWallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WalletServiceImpl extends AbstractConvertService implements WalletService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private WalletRepository walletRepository;

    private List<TypeWallet> ruleWalletList = new ArrayList<>(Arrays.asList(TypeWallet.MAIN,TypeWallet.LOCK));


    @Override
    public void checkInfoAccount(AccountReq accountReq) throws ErrorAllException {

    }

    @Override
    @Transactional
    public void saveDB(AccountReq accountReq) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setPhoneNumber(accountReq.getAccount());
        List<WalletEntity> walletEntityList = new ArrayList<>();
        createWalletEntityList(accountReq,walletEntityList);
        walletRepository.saveAll(walletEntityList);
        clientRepository.save(clientEntity);
    }

    private void createWalletEntityList(AccountReq accountReq,List<WalletEntity> walletEntityList){
        for (TypeWallet typeWallet : ruleWalletList){
            walletEntityList.add(convertFromAccountReqToWalletEntity(accountReq,typeWallet));
        }
    }
}
