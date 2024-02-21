package me.account.account.server.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;

import java.util.List;

public class ExcelHelper {

    private Workbook workbook;

    private Sheet sheet;

    public ExcelHelper(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }

    public void setMergedCellAndRedFont(int firstRow, int lastRow, int firstCol, int lastCol, String msg){
        // 合并单元格
        CellRangeAddress cellRangeAddress = new CellRangeAddress(firstRow, lastRow, firstCol, lastCol); // 行索引从0开始，列索引也从0开始
        sheet.addMergedRegion(cellRangeAddress);

        // 创建一个样式对象，用于设置字体颜色为红色
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setColor(IndexedColors.RED.getIndex()); // 设置字体颜色为红色
        style.setFont(font);

        // 获取合并区域的第一个单元格，并设置其样式与内容
        Row row = sheet.getRow(firstRow);
        if (row == null) {
            row = sheet.createRow(firstRow);
        }
        Cell cell = row.getCell(firstCol);
        if (cell == null) {
            cell = row.createCell(firstCol);
        }
        cell.setCellValue(msg);
        cell.setCellStyle(style);
    }

    public void setDataValidation(String[] options, int firstRow, int lastRow, int firstCol, int lastCol){
        // 假设要在第一列（A列）设置下拉列表选项
        DataValidationHelper validationHelper = sheet.getDataValidationHelper();

        // 创建数据验证规则，序列类型允许下拉列表
        DataValidationConstraint constraint = validationHelper.createExplicitListConstraint(options); // 下拉选项列表

        // 设置数据验证区域范围，例如从第二行开始的整个A列
        CellRangeAddressList addressList = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);

        // 创建并添加数据验证到单元格区域
        DataValidation validation = validationHelper.createValidation(constraint, addressList);
        // 不知道为啥.在WPS里是反的..
        validation.setSuppressDropDownArrow(true); // 显示下拉箭头（默认为true，即隐藏）
        sheet.addValidationData(validation);
    }

    public void setRowData(int rowNum, List<String> data){
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }
        for (int i = 0; i < data.size(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(data.get(i));
        }
    }

}
