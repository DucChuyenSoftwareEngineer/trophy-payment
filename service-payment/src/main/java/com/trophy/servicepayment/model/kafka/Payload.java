package com.trophy.servicepayment.model.kafka;

import com.trophy.servicepayment.util.Status;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public abstract class Payload {
    private Status event;
    private Object data;
}
