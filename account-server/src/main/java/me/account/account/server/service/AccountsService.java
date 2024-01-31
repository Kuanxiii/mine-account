package me.account.account.server.service;


import me.account.account.server.mapper.BillsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountsService {

    @Resource
    private BillsMapper billsMapper;

//    public void addAccount(AccountDTO accountDTO) {
//        billingAccountsMapper.insertSelective(accountDTO.toPOJO());
//    }
//
//    @Transactional
//    public void batchAddAccount(List<AccountDTO> accountDTOs){
//        accountDTOs.forEach(accountDTO -> billingAccountsMapper.insertSelective(accountDTO.toPOJO()));
//    }

}
