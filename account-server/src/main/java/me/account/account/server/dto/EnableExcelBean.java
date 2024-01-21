package me.account.account.server.dto;

import org.apache.poi.ss.usermodel.Row;

import java.util.List;
import java.util.Map;

public interface EnableExcelBean {

    Map<String, String> getExcelNameMap();

    List<String> getExcelNameList();

}
