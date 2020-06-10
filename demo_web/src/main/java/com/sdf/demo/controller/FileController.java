package com.sdf.demo.controller;

import com.sdf.demo.constant.CommonCodeConst;
import com.sdf.demo.model.LinkManInfo;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName FileController
 * @Description: TODO
 * @Author ShuDingfeng
 * @createDate 2020-06-05-15:59
 * @Version 1.0
 **/

@RestController
@RequestMapping("/file")
public class FileController {

    @RequestMapping("test")
    public boolean test(){
//        File file = new File("E:\\downmoban\\imptempfile\\{0A00007F-FFFF-FFFF-8324-0AF700000001}.xlsx");
//        System.out.println(file.getName());
        Workbook wb = null;
        try {
            InputStream inp = new FileInputStream("E:\\downmoban\\imptempfile\\personalExcelModel.xlsx");
            wb = WorkbookFactory.create(inp);
            List<LinkManInfo> manList = new ArrayList<>();
            // 循环工作表Sheet
            for (int numSheet = 0; numSheet < wb.getNumberOfSheets(); numSheet++){
                Sheet hssfSheet = wb.getSheetAt(numSheet);
                if (hssfSheet == null) {
                    continue;
                }
                Row rowOne = hssfSheet.getRow(0);
//                int index = hssfSheet.getRow(0).getLastCellNum();
                //循环行row
                for(int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++){
                    //HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    Row hssfRow = hssfSheet.getRow(rowNum);
                    if (hssfRow != null){
                        LinkManInfo linkManInfo = getRowInfo(hssfRow, rowOne);
                        manList.add(linkManInfo);
                    }
                }
            }
            if (manList.size() > 0){
                //TODO
            }
            wb.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private LinkManInfo getRowInfo(Row row, Row rowOne){
        LinkManInfo linkManInfo = new LinkManInfo();
//        for (int i = 0; i < index ; i++){
//            row.getCell(i);
//        }

//        for (Cell cell : row){
        for (int i = 0; i < rowOne.getLastCellNum(); i++){
            Cell cell = row.getCell(i);
            String value = null;
            if (cell == null || cell.equals(null) || cell.getCellTypeEnum() == CellType.BLANK){
                value = "";
            } else {
                switch (cell.getCellTypeEnum()){
                    case FORMULA:
                        value = cell.getCellFormula();
                        break;
                    case NUMERIC:
                        if (HSSFDateUtil.isCellDateFormatted(cell)){
                            SimpleDateFormat sdf = new SimpleDateFormat(CommonCodeConst.DATE_FORMAT);
                            Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                            value = sdf.format(date);
                        } else {
                            DecimalFormat df = new DecimalFormat("0");
                            value = df.format(cell.getNumericCellValue());
                        }
//                        Date date = cell.getDateCellValue();
//                        value = cell.getNumericCellValue();
                        break;
                    case STRING:
                        value = cell.getStringCellValue().trim();
                        break;
                    case BOOLEAN:
                        value = "" + cell.getBooleanCellValue();
                        break;
                    default:
                        break;
                }
                switch (rowOne.getCell(i).getStringCellValue().trim()){
                    case CommonCodeConst.EXCEL_NAME:
                        linkManInfo.setLinkManName(value);
                        break;
                    case CommonCodeConst.EXCEL_SEX:
                        linkManInfo.setLinkManSex(value.equals("男")? 1 : 2);
                        break;
                    case CommonCodeConst.EXCEL_COMPANYNAME:
                        linkManInfo.setLinkManCompanyName(value);
                        break;
                    case CommonCodeConst.EXCEL_JOBTITLES:
                        linkManInfo.setLinkManJobTitles(value);
                        break;
                    case CommonCodeConst.EXCEL_OFFICEADDRESS:
                        linkManInfo.setLinkManOfficeAddress(value);
                        break;
                    case CommonCodeConst.EXCEL_MOBILE:
                        linkManInfo.setLinkManMobile(value);
                        break;
                    case CommonCodeConst.EXCEL_OFFICEPHONE:
                        linkManInfo.setLinkManOfficePhone(value);
                        break;
                    case CommonCodeConst.EXCEL_EMAIL:
                        linkManInfo.setLinkManEmail(value);
                        break;
                    case CommonCodeConst.EXCEL_QQ:
                        linkManInfo.setLinkManQQ(value);
                        break;
                    case CommonCodeConst.EXCEL_REMARK:
                        linkManInfo.setLinkManRemark(value);
                        break;
                    default:
                        break;
                }
            }
        }

        return linkManInfo;
    }
}
