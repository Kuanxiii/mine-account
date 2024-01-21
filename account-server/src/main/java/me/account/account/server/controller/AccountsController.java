package me.account.account.server.controller;

import lombok.extern.slf4j.Slf4j;
import me.account.account.server.dto.AccountDTO;
import me.account.account.server.dto.ResponseDTO;
import me.account.account.server.service.AccountsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@ResponseBody
@RestController
@RequestMapping("/accounts")
public class AccountsController {


    @Resource
    private AccountsService accountsService;

    @PostMapping("add")
    public ResponseDTO<Object> add(@RequestBody AccountDTO accountDTO){
        accountsService.addAccount(accountDTO);
        return new ResponseDTO<>();
    }

    @PostMapping("batch_add")
    public ResponseDTO<Object> batchAdd(@RequestBody List<AccountDTO> accountDTOs){
        accountsService.batchAddAccount(accountDTOs);
        return new ResponseDTO<>();
    }

}
