package com.trophy.servicepayment.api;

import com.trophy.servicepayment.bussiness.WalletService;
import com.trophy.servicepayment.bussiness.impl.WalletServiceImpl;
import com.trophy.servicepayment.exception.ErrorAllException;
import com.trophy.servicepayment.model.vo.account.AccountReq;
import com.trophy.servicepayment.model.vo.account.AccountRes;
import com.trophy.servicepayment.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private WalletService walletService;

    @GetMapping("/kafka/{value_send}")
    public @ResponseBody
    ResponseEntity putKafka(@PathVariable String value_send) {
        kafkaTemplate.send("Backend",value_send);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,path = Constants.URL_ACCOUNT,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<AccountRes> createAccount(@RequestBody final AccountReq accountReq) throws ErrorAllException {

        walletService.checkInfoAccount(accountReq);
        walletService.saveDB(accountReq);

        return new ResponseEntity<>(HttpStatus.OK);
    }



}
