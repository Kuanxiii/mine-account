package me.account.account.server.service;

import me.account.account.server.dto.AccountDTO;
import me.account.account.server.mapper.BillingAccountsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountsService {

    @Resource
    private BillingAccountsMapper billingAccountsMapper;

    public void addAccount(AccountDTO accountDTO) {
        billingAccountsMapper.insertSelective(accountDTO.toPOJO());
    }

    @Transactional
    public void batchAddAccount(List<AccountDTO> accountDTOs){
        accountDTOs.forEach(accountDTO -> billingAccountsMapper.insertSelective(accountDTO.toPOJO()));
    }

}
