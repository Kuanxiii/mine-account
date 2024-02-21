package me.account.account.server.service;


import me.account.account.server.dto.AccountDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BillsService {

    @Resource
    private AccountService accountService;

    public void addAccount(AccountDTO accountDTO) {
        accountService.addAccount(accountDTO);
    }

    @Transactional
    public void batchAddAccount(List<AccountDTO> accountDTOs){
        accountDTOs.forEach(accountDTO -> accountService.addAccount(accountDTO));
    }

}
