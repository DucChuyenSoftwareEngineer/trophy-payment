package com.trophy.servicepayment.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Builder
@Data
@Entity
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="tid")
    private Long tid;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="amount")
    private Long amount;

    @Column(name="status")
    private String status;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name="parent_tid")
    private Long parentTid;

    @Column(name="sof")
    private String sof;

    @Column(name="result_code")
    private Integer resultCode;


}
