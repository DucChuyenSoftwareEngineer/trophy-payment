package com.trophy.servicepayment.db.repository;

import com.trophy.servicepayment.model.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<WalletEntity,Long> {

    public WalletEntity getWalletEntityByPhoneNumberAndType(String phoneNumber,String type);
}

