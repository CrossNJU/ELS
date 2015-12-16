package org.cross.elsclient.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.cross.elsclient.vo.StockCheckVO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.ResultMessage;

public class ExportExcel {

	private static List<StockCheckVO> getStockcheck() {

		List list = new ArrayList();

		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");

		StockCheckVO vo1 = new StockCheckVO("R0000001", "2015/12 03", "南京", "SA0001s");
		StockCheckVO vo2 = new StockCheckVO("R0000002", "2015/12 03", "南京", "SA0001s");
		StockCheckVO vo3 = new StockCheckVO("R0000003", "2015/12 03", "南京", "SA0001s");
		StockCheckVO vo4 = new StockCheckVO("R0000004", "2015/12 03", "南京", "SA0001s");
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);

		return list;
	}

	public static ResultMessage exportExcel(List list) {
		String success = "导出成功！";
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("test");
		HSSFRow row = sheet.createRow(0);
		HSSFCellStyle style = wb.createCellStyle();

		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		@SuppressWarnings("deprecation")
		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("快件编号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("入库时间");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("到达城市");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("存放位置");
		cell.setCellStyle(style);

		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow((int) i + 1);
			StockCheckVO check = (StockCheckVO) list.get(i);

			row.createCell((short) 0).setCellValue((String) check.goodsNumber);
			row.createCell((short) 1).setCellValue((String) check.inTime);
			row.createCell((short) 2).setCellValue((String) check.targetCity);
			row.createCell((short) 3).setCellValue((String) check.stockAreaNum);

			try {
				FileOutputStream fout = new FileOutputStream("src/main/test.xls");
				wb.write(fout);
				fout.close();

			} catch (IOException e) {
				e.printStackTrace();
				return ResultMessage.FAILED;
			}

		}
		return ResultMessage.SUCCESS;

	}

	public static void main(String[] args) {
		List list = ExportExcel.getStockcheck();
		ResultMessage res = ExportExcel.exportExcel(list);
		if (res == ResultMessage.SUCCESS)
			System.out.println("导出成功");
		else
			System.out.println("导出失败");
	}
}
