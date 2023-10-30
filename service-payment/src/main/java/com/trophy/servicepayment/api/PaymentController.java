package com.trophy.servicepayment.api;

import com.trophy.servicepayment.bussiness.DepositService;
import com.trophy.servicepayment.exception.ErrorAllException;
import com.trophy.servicepayment.model.vo.deposit.DepositReq;
import com.trophy.servicepayment.model.vo.deposit.DepositRes;
import com.trophy.servicepayment.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(Constants.API_URl + Constants.URL_PAYMENT)
public class PaymentController {

    @Autowired
    private DepositService accountService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);


    /**
     *  Step 1: Check request and account have saved DB  (table Client)
     *  Step 2: Check rule. Maybe user don't allow top up
     *  Step 3: Insert database transaction before create a tid
     *  Step 4: Push message into Backend Service
     * */
    @RequestMapping(method = RequestMethod.POST,path = Constants.URL_DEPOSIT,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<DepositRes> depositClient(@RequestBody final DepositReq depositReq) throws ErrorAllException {
        DepositRes depositRes = new DepositRes();
        // step 1
        accountService.checkRuleAccount(depositReq);
        // step 2
        accountService.checkRuleAccount(depositReq);
        // step 3
        accountService.saveDb(depositReq);
        // step 4


        return new ResponseEntity<DepositRes>(depositRes, HttpStatus.CREATED);
    }


}
