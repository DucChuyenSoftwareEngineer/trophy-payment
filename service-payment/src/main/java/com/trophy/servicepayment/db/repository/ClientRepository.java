package com.trophy.servicepayment.db.repository;

import com.trophy.servicepayment.model.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity,Long> {
    public ClientEntity findClientByPhoneNumber(String phoneNumber);
}
