package com.yihuisort.poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author 李灿 使用poi实现excel读写
 */
public class PoiTest {

	/**
	 * 读取excel文件
	 */
	public void testReadExcel() {
		try {
			// 读取Excel
			Workbook wb = new HSSFWorkbook(new FileInputStream(
					"E:\\WorkSpace\\Help\\src\\excel\\template.xls"));

			// 获取sheet数目
			for (int t = 0; t < wb.getNumberOfSheets(); t++) {
				Sheet sheet = wb.getSheetAt(t);
				Row row = null;
				int lastRowNum = sheet.getLastRowNum();

				// 循环读取
				for (int i = 0; i <= lastRowNum; i++) {
					row = sheet.getRow(i);
					if (row != null) {
						// 获取每一列的值
						for (int j = 0; j < row.getLastCellNum(); j++) {
							Cell cell = row.getCell(j);
							String value = getCellValue(cell);
							if (!value.equals("")) {
								System.out.print(value + " | ");
							}
						}
						System.out.println();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 写入excel文件
	 */
	public void testWriteExcel() {
		String excelPath = "d:/3.xls";

		Workbook workbook = null;
		try {
			// XSSFWorkbook used for .xslx (>= 2007), HSSWorkbook for 03 .xsl
			workbook = new HSSFWorkbook();// XSSFWorkbook();//WorkbookFactory.create(inputStream);
		} catch (Exception e) {
			System.out.println("创建Excel失败: ");
			e.printStackTrace();
		}
		if (workbook != null) {
			Sheet sheet = workbook.createSheet("测试数据");
			Row row0 = sheet.createRow(0);
			for (int i = 0; i < 6; i++) {
				Cell cell = row0.createCell(i, Cell.CELL_TYPE_STRING);
				cell.setCellValue("列标题" + i);
				// sheet.autoSizeColumn(i);//自动调整宽度
			}
			for (int rowNum = 1; rowNum < 10; rowNum++) {
				Row row = sheet.createRow(rowNum);
				for (int i = 0; i < 6; i++) {
					Cell cell = row.createCell(i, Cell.CELL_TYPE_STRING);
					cell.setCellValue("单元格" + String.valueOf(rowNum + 1)
							+ String.valueOf(i + 1));
				}
			}
			try {
				FileOutputStream outputStream = new FileOutputStream(excelPath);
				workbook.write(outputStream);
				outputStream.flush();
				outputStream.close();
			} catch (Exception e) {
				System.out.println("写入Excel失败: ");
				e.printStackTrace();
			}
		}
	}

	/***
	 * 读取单元格的值
	 * 
	 * @Title: getCellValue
	 * @Date : 2014-9-11 上午10:52:07
	 * @param cell
	 * @return
	 */
	private String getCellValue(Cell cell) {
		Object result = "";
		if (cell != null) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				result = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				result = cell.getNumericCellValue();
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				result = cell.getBooleanCellValue();
				break;
			case Cell.CELL_TYPE_FORMULA:
				result = cell.getCellFormula();
				break;
			case Cell.CELL_TYPE_ERROR:
				result = cell.getErrorCellValue();
				break;
			case Cell.CELL_TYPE_BLANK:
				break;
			default:
				break;
			}
		}
		return result.toString();
	}

	public static void main(String[] args) throws Exception {
		PoiTest poiTest = new PoiTest();
//		poiTest.testReadExcel();
		poiTest.testWriteExcel();
		// poiTest.getClazz();

	}

	// 获得字节码的几种方式,得到信息:class com.xin.test.Person
	public Class<?> getClazz() throws Exception {
		// 第一种方式
		Class<?> clazz = Class.forName("com.yihuisort.poi.PoiTest");
		// 第二种方式
		// clazz=PoiTest.class;
		// 第三种方式
		// PoiTest p=new PoiTest();
		// clazz=p.getClass();

		PoiTest person = (PoiTest) clazz.newInstance();
		// String
		// path=person.getClass().getClassLoader().getResource("/excel/template.xls").getPath();
		// String replace =
		// getClass().getClassLoader().getResource("/sy/config/sheetMonitor-config.xml").getPath().replace("%20",
		// " ");
		// System.out.println(path);
		return clazz;
	}
	
	/**
	 * 读
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void readExcel() throws FileNotFoundException, IOException
	{
		//创建Excel实例对象
		Workbook wb = new HSSFWorkbook(new FileInputStream(
				"E:\\WorkSpace\\Help\\src\\excel\\template.xls"));
		//取得Sheet的数量
		int count = wb.getNumberOfSheets();
		//得到指定索引Sheet(表)对象
		Sheet sheet = wb.getSheetAt(0);
		//设置sheet名称
		wb.setSheetName(1, "第一张工作表");  
		//设置列宽
		sheet.setColumnWidth((short)10,(short)100);      
		    
		
		//取得有效的行数
		int line = sheet.getLastRowNum();  
		//得到指定行
		Row row = sheet.getRow(1);
		//设置行高
		row.setHeight((short)50);
		
		//取得一行的有效单元格个数
		int celline = row.getLastCellNum();
		row.setHeight((short)50);
		
		//得到指定列
		Cell cell = row.getCell(1);
		//设置列内容
		cell.setCellValue("内容");
		//得到单元格样式
		CellStyle cellStyle = cell.getCellStyle();
		//创建单元格样式  
		cellStyle = wb.createCellStyle();
		cellStyle.getAlignment();
		
		//创建Excel工作表指定行的单元格
		row.createCell((short)0).setCellStyle(cellStyle);  
		//设置Excel工作表的值
		row.createCell((short)0).setCellValue(1);   
		
		
		
	}

}
