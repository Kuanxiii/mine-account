package me.account.account.server.controller;

import lombok.extern.slf4j.Slf4j;
import me.account.account.server.dto.ResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@ResponseBody
@RestController
@RequestMapping("/accounts")
public class AccountsController {



    @PostMapping("add")
    public ResponseDTO<Object> addAccount(){
        return new ResponseDTO<>();
    }

}
