package com.trophy.servicepayment.model.vo.deposit;

import lombok.*;


@Data
@Getter
@Setter
public class DepositReq {
    private String account;
    private Long amount;
    private String source;
}
