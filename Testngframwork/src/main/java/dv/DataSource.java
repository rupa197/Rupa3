package dv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataSource {
	@DataProvider(name = "somthing")
	public Object[][] dp() {
		// return new Object[][] { new Object[] { "user1", "pass1" }, new Object[]
		// {"user2", "pass2" }, };

		// Object[][] mdp = { { "user id", "password" }, { "user id", "password" } };
		// return mdp;

		Object[][] obj = new Object[3][2];
		obj[0][0] = "userid";
		obj[0][1] = "password";

		obj[1][0] = "userid";
		obj[1][1] = "password";

		obj[2][0] = "userid";
		obj[2][1] = "password";

		return obj;
		// three different way example above

	}

	@Test
	@DataProvider(name = "ronzu")
	public Object[][] getDataFromExcel() {
		XSSFWorkbook book = null;
		FileInputStream file = null;

		try {

			file = new FileInputStream(new File("/Users/rupa/eclipse-workspace/Testngframwork/Data.xlsx"));
			book = new XSSFWorkbook(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found");
		} catch (IOException e) {

		}
		XSSFSheet sheet = book.getSheetAt(0);

		int rs = sheet.getLastRowNum();
		int cs = sheet.getRow(0).getLastCellNum();

		Object[][] object = new Object[rs][cs];

		for (int i = 1; i < rs; i++) {

			for (int j = 0; j < cs; j++) {

				XSSFCell cell = sheet.getRow(i).getCell(j);
				switch (cell.getCellType()) {

				case XSSFCell.CELL_TYPE_NUMERIC:

					object[i - 1][j] = cell.getNumericCellValue();

				case XSSFCell.CELL_TYPE_STRING:
					object[i - 1][j] = cell.getStringCellValue();

				}

			}
		}
		return object;
	}

	@DataProvider(name = "RONZU XMLDATA")
	public Object[][] getDatafromExcel() {
		XSSFWorkbook book = null;
		FileInputStream file = null;
		try {
			file = new FileInputStream(new File("/Users/ihalder/eclipse-workspace/TestngFramework/Data.xlsx"));
			book = new XSSFWorkbook(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File not found");
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (book != null) {
				try {
					book.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		XSSFSheet sheet = book.getSheetAt(0);

		// sheet.getRow(5).getCell(0).getStringCellValue();
		int rs = sheet.getLastRowNum();
		int cs = sheet.getRow(0).getLastCellNum();

		Object[][] object = new Object[rs][cs];

		for (int i = 1; i <= rs; i++) {

			for (int j = 0; j <= cs; j++) {

				XSSFCell cell = sheet.getRow(i).getCell(j);
				switch (cell.getCellType()) {
				case XSSFCell.CELL_TYPE_NUMERIC:
					object[i - 1][j] = cell.getNumericCellValue();

				case XSSFCell.CELL_TYPE_STRING:
					object[i - 1][j] = cell.getStringCellValue();
				}
			}
		}

		return object;
	}

	
	
	
	
	
	
	@DataProvider(name = "RONZU XMLDATA")
	public Object[][] getDatafromExcelWithTryAndCatch() {
		XSSFWorkbook book = null;
		FileInputStream file = null;
		try {
			file = new FileInputStream(new File("/Users/ihalder/eclipse-workspace/TestngFramework/Data.xlsx"));
			book = new XSSFWorkbook(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File not found");
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (book != null) {
				try {
					book.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		XSSFSheet sheet = book.getSheetAt(0);

		// sheet.getRow(5).getCell(0).getStringCellValue();
		int rs = sheet.getLastRowNum();
		int cs = sheet.getRow(0).getLastCellNum();

		Object[][] object = new Object[rs][cs];

		for (int i = 1; i <= rs; i++) {

			for (int j = 0; j <= cs; j++) {

				XSSFCell cell = sheet.getRow(i).getCell(j);
				switch (cell.getCellType()) {
				case XSSFCell.CELL_TYPE_NUMERIC:
					object[i - 1][j] = cell.getNumericCellValue();

				case XSSFCell.CELL_TYPE_STRING:
					object[i - 1][j] = cell.getStringCellValue();
				}
			}
		}

		return object;
	}
	
	
	
	
	@DataProvider(name = "write data")
	public void writeDataToXlSheet() throws IOException {
		XSSFWorkbook workBook=new XSSFWorkbook(); //i need xl work book
		XSSFSheet sheet=workBook.createSheet("Sheet1");  // i need xl sheet
		
	XSSFRow	ro=sheet.createRow(0);
   XSSFCell co= ro.createCell(0);
	 co.setCellValue("NAME BITTECH USA ");
	 

	
		
		
		
		File f=new File("/Users/rupa/Desktop/btc/Name entry.xlsx");//for file path
		FileOutputStream fos=new FileOutputStream(f); //to send data
		workBook.write(fos);
		fos.close();
		workBook.close();
		System.out.println("File is written");
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
