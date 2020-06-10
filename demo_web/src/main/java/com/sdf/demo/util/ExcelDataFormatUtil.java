package com.sdf.demo.util;

import com.sdf.demo.constant.CommonCodeConst;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName:ExcelDataFormatUtil <br/>
 * Function: <br/>
 * Date: Apr 18, 2018 6:16:09 PM <br/>
 */
public class ExcelDataFormatUtil {

	/**
	 * 2003execl数据格式的转换
	 * 
	 * @param cell
	 * @return
	 */
	public static String publicExcel2003(HSSFCell cell) {
		String value = null;
		if (null == cell) {
			value = "";
		} else {
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_NUMERIC:
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat sdf = new SimpleDateFormat(CommonCodeConst.DATE_FORMAT);
					double valueCell = cell.getNumericCellValue();
					Date date = HSSFDateUtil.getJavaDate(valueCell);
					value = sdf.format(date);
				} else {
					short format = cell.getCellStyle().getDataFormat();
					SimpleDateFormat sdf = null;
					// 自定义格式日期
					if (format == 14 || format == 31 || format == 57 || format == 58 || format == 176
							|| format == 177) {
						// 日期
						sdf = new SimpleDateFormat(CommonCodeConst.DATE_FORMAT);
						double valueCell = cell.getNumericCellValue();
						Date date = DateUtil.getJavaDate(valueCell);
						value = sdf.format(date);
					} else {// 纯数字
						DecimalFormat df = null;
						double cellValue = cell.getNumericCellValue();
						df = new DecimalFormat("0");
						/*
						 * if ((int)(cellValue) == cellValue){ df = new
						 * DecimalFormat("0"); }else{ df = new
						 * DecimalFormat("0.00"); }
						 */
						value = df.format(cellValue);
					}
				}
				break;
			case HSSFCell.CELL_TYPE_STRING:
				value = cell.getStringCellValue().trim();
				break;
			case HSSFCell.CELL_TYPE_BLANK:
				value = "";
				break;
			default:
				break;
			}
		}
		return value;
	}

	/**
	 * 2007execl数据格式的转换
	 * 
	 * @param cell
	 * @return
	 */
	public static String publicExcel2007(XSSFCell cell) {
		String value = null;
		if (null == cell) {
			value = "";
		} else {
			switch (cell.getCellType()) {
			case XSSFCell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					Date date2 = cell.getDateCellValue();
					SimpleDateFormat dff = new SimpleDateFormat(CommonCodeConst.DATE_FORMAT);
					value = dff.format(date2); // 日期转化
				} else {
					DecimalFormat df = null;
					double cellValue = cell.getNumericCellValue();
					df = new DecimalFormat("0");
					/*
					 * if ((int)(cellValue) == cellValue){ df = new
					 * DecimalFormat("0"); }else{ df = new
					 * DecimalFormat("0.00"); }
					 */
					value = df.format(cellValue);
				}
				break;
			case XSSFCell.CELL_TYPE_STRING:
				value = cell.getStringCellValue().trim();
				break;
			case XSSFCell.CELL_TYPE_BLANK:
				value = "";
				break;
			case XSSFCell.CELL_TYPE_FORMULA:
				// 读公式计算值
				value = String.valueOf(cell.getNumericCellValue());
				if (value.equals("NaN")) {// 如果获取的数据值为非法值,则转换为获取字符串
					value = cell.getStringCellValue().toString();
				}
				break;
			// 布尔类型
			case XSSFCell.CELL_TYPE_BOOLEAN:
				value = " " + cell.getBooleanCellValue();
				break;
			default:
				break;
			}
		}
		return value;
	}


}
