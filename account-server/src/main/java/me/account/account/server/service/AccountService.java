package me.account.account.server.service;

import me.account.account.server.dto.AccountDTO;
import me.account.account.server.mapper.BillAttributeRelationMapper;
import me.account.account.server.mapper.BillsMapper;
import me.account.account.server.mapper.EconomicAttributesMapper;
import me.account.account.server.mapper.PurposeAttributesMapper;
import me.account.account.server.po.BillAttributeRelation;
import me.account.account.server.po.Bills;
import me.account.account.server.po.PurposeAttributes;
import me.account.account.server.po.example.BillAttributeRelationExample;
import me.account.account.server.po.example.PurposeAttributesExample;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class AccountService {

    @Resource
    private BillAttributeRelationMapper billAttributeRelationMapper;

    @Resource
    private EconomicAttributesMapper economicAttributesMapper;

    @Resource
    private PurposeAttributesMapper purposeAttributesMapper;

    @Resource
    private BillsMapper billsMapper;

    public AccountDTO buildAccountDTOFromBills(Bills bills) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(bills.getBillId());
        accountDTO.setUserId(bills.getUserId());
        accountDTO.setDayNo(bills.getDayNo());
        accountDTO.setWeekNo(bills.getWeekNo());
        accountDTO.setMouthNo(bills.getMouthNo());
        accountDTO.setStat(bills.getStat());
        accountDTO.setAmount(bills.getAmount());
        accountDTO.setUseIn(bills.getUseIn());
        accountDTO.setEconomicAttributeId(bills.getEconomicAttributeId());
        accountDTO.setEconomicAttributeName(economicAttributesMapper.selectByPrimaryKey(bills.getEconomicAttributeId()).getAttributeName());
        BillAttributeRelationExample billAttributeRelationExample = new BillAttributeRelationExample();
        billAttributeRelationExample.createCriteria().andBillIdEqualTo(bills.getBillId());
        List<BillAttributeRelation> billAttributeRelations = billAttributeRelationMapper.selectByExample(billAttributeRelationExample);
        List<Integer> purposeAttributeIds = billAttributeRelations.stream().map(BillAttributeRelation::getPurposeAttributeId).collect(Collectors.toList());
        PurposeAttributesExample purposeAttributesExample = new PurposeAttributesExample();
        purposeAttributesExample.createCriteria().andPurposeAttributeIdIn(purposeAttributeIds);
        List<PurposeAttributes> purposeAttributes = purposeAttributesMapper.selectByExample(purposeAttributesExample);
        accountDTO.setPurposeAttributes(purposeAttributes);
        accountDTO.setRemark(bills.getRemark());
        accountDTO.setInsertTime(bills.getInsertTime());
        accountDTO.setUpdateTime(bills.getUpdateTime());
        return accountDTO;
    }

    public Bills buildBillsFromAccountDTO(AccountDTO accountDTO) {
        Bills bills = new Bills();
        bills.setBillId(accountDTO.getId());
        bills.setUserId(accountDTO.getUserId());
        bills.setDayNo(accountDTO.getDayNo());
        bills.setWeekNo(accountDTO.getWeekNo());
        bills.setMouthNo(accountDTO.getMouthNo());
        bills.setStat(accountDTO.getStat());
        bills.setAmount(accountDTO.getAmount());
        bills.setUseIn(accountDTO.getUseIn());
        bills.setEconomicAttributeId(accountDTO.getEconomicAttributeId());
        bills.setRemark(accountDTO.getRemark());
        bills.setInsertTime(accountDTO.getInsertTime());
        bills.setUpdateTime(accountDTO.getUpdateTime());
        return bills;
    }

    public List<BillAttributeRelation> buildBillAttributeRelationListFromAccountDTO(AccountDTO accountDTO) {
        return accountDTO.getPurposeAttributes().stream().map(purposeAttributes -> {
            BillAttributeRelation billAttributeRelation = new BillAttributeRelation();
            billAttributeRelation.setBillId(accountDTO.getId());
            billAttributeRelation.setPurposeAttributeId(purposeAttributes.getPurposeAttributeId());
            return billAttributeRelation;
        }).collect(Collectors.toList());
    }

    public List<PurposeAttributes> getNeedInsertPurposeAttributes(AccountDTO accountDTO) {
        List<PurposeAttributes> needInsertPurposeAttributes = new ArrayList<>();
        PurposeAttributesExample purposeAttributesExample = new PurposeAttributesExample();
        purposeAttributesExample.createCriteria()
                .andUserIdEqualTo(accountDTO.getUserId())
                .andAttributeNameIn(accountDTO.getPurposeAttributes().stream().map(PurposeAttributes::getAttributeName).collect(Collectors.toList()));
        List<PurposeAttributes> purposeAttributeList = purposeAttributesMapper.selectByExample(purposeAttributesExample);
        Map<String, Integer> nameMep = purposeAttributeList.stream().collect(Collectors.toMap(PurposeAttributes::getAttributeName, PurposeAttributes::getPurposeAttributeId));
        for (PurposeAttributes purposeAttributes : accountDTO.getPurposeAttributes()){
            if (nameMep.containsKey(purposeAttributes.getAttributeName())) {
                purposeAttributes.setPurposeAttributeId(nameMep.get(purposeAttributes.getAttributeName()));
            } else {
                needInsertPurposeAttributes.add(purposeAttributes);
            }
        }
        return needInsertPurposeAttributes;
    }


    @Transactional
    public Bills addAccount(AccountDTO accountDTO) {
        Bills bills = buildBillsFromAccountDTO(accountDTO);
        billsMapper.insertSelective(bills);
        accountDTO.setId(bills.getBillId());
        List<PurposeAttributes> needInsertPurposeAttributes = getNeedInsertPurposeAttributes(accountDTO);
        if (!needInsertPurposeAttributes.isEmpty()) {
            needInsertPurposeAttributes.forEach(purposeAttribute -> {
                purposeAttribute.setUserId(accountDTO.getUserId());
                purposeAttributesMapper.insertSelective(purposeAttribute);
            });
        }
        List<BillAttributeRelation> billAttributeRelationList = buildBillAttributeRelationListFromAccountDTO(accountDTO);
        billAttributeRelationList.forEach(billAttributeRelation -> {
            billAttributeRelation.setBillId(bills.getBillId());
            billAttributeRelationMapper.insertSelective(billAttributeRelation);
        });

        return bills;
    }

}
