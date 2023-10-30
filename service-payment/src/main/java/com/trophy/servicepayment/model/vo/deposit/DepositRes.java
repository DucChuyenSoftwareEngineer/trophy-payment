package com.trophy.servicepayment.model.vo.deposit;

import com.trophy.servicepayment.util.Status;
import lombok.*;


@Data
@Getter
@Setter
public class DepositRes {
    private String account;
    private String tid;
    private Status status;
}
