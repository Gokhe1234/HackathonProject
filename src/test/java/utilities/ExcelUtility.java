package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pageObject.CarInsurancePage;
import pageObject.HealthInsurancePage;
import pageObject.TravelPlanPage;

public class ExcelUtility {
	
	//Read Data
	public static String readExcel(int row) throws Exception {
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\excelfile\\inputexcel.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(file);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			String ab=sheet.getRow(row).getCell(0).toString();
			workbook.close();
			return ab;
		
	}
	//Write Data
	public static void excel() throws IOException {
		
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\excelfile\\output.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Student Insurance Plan");
		XSSFRow row=sheet.createRow(0);
		XSSFCell cell=row.createCell(0);
		cell.setCellValue("Companay Provider Name");
		row.createCell(1).setCellValue("Package Name");
		row.createCell(2).setCellValue("Price");
		
		for(int i=1; i<=TravelPlanPage.company.size();i++ ) {
			XSSFRow r=sheet.createRow(i);
			r.createCell(0).setCellValue(TravelPlanPage.company.get(i-1));
			r.createCell(1).setCellValue(TravelPlanPage.name.get(i-1));
			r.createCell(2).setCellValue(TravelPlanPage.prices.get(i-1));

		}
		
		
		XSSFSheet sheet1=workbook.createSheet("All Health Insurance List");
		XSSFRow nrow=sheet1.createRow(0);
		XSSFCell ncell=nrow.createCell(0);
		ncell.setCellValue("Health Insurance List");
		
		for(int i=1; i<=HealthInsurancePage.allHealthList.size();i++ ) {
			XSSFRow ro=sheet1.createRow(i);
			ro.createCell(0).setCellValue(HealthInsurancePage.allHealthList.get(i-1));
			
		}
		
		
		workbook.write(file);
		workbook.close();
		file.close();
		

	}
	


	
	

}
