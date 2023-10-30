package com.trophy.servicepayment.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name = "wallet")
public class WalletEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="balance")
    private Long balance;

    public WalletEntity() {

    }
}
