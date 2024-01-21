package me.account.account.server.dto;

import me.account.account.server.annotations.ExcelName;
import org.apache.poi.ss.usermodel.Row;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbstractEnableExcelBean implements EnableExcelBean {

    /**
     * 获取Excel表头与Bean属性名的映射
     * @return Map<Excel表头, Bean属性名>
     */
    @Override
    public Map<String, String> getExcelNameMap() {
        Map<String, String> map = new HashMap<>();
        for(Field field : this.getClass().getDeclaredFields()){
            ExcelName excelName = field.getAnnotation(ExcelName.class);
            if(excelName != null){
                map.put(excelName.value(), field.getName());
            }
        }
        return map;
    }


    /**
     * 获取Excel表头列表
     * @return Excel表头列表
     */
    @Override
    public List<String> getExcelNameList() {
        List<String> excelNameList = new ArrayList<>();
        for(Field field : this.getClass().getDeclaredFields()){
            ExcelName excelName = field.getAnnotation(ExcelName.class);
            if(excelName != null){
                excelNameList.add(excelName.value());
            }
        }
        return excelNameList;
    }

}
