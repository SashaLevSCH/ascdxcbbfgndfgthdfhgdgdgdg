package utils;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.util.logging.Level;

public class TestDataProviderUtility {


	private TestDataProviderUtility() {

		// no-op
	}


	public static Object[][] ExcelToMap(String fileName, String sheetName) {

		Workbook workbook = null;
		FileInputStream fis = null;
		String header[] = null;
		List<HashMap<String, String>> maps = new ArrayList<>();
		try {
			File file = new File(fileName);
			fis = new FileInputStream(fileName);
			workbook = getWorkbookObj(fis, fileName);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(0);
			int numberOfCells = row.getLastCellNum();
			header = new String[numberOfCells + 1];
			// add headers
			if (null != row) {
				for (int j = 0; j <= row.getLastCellNum(); j++) {
					if (j == 0) {
						header[j] = "slNo";
					} else {
						header[j] = getCellDataToString(row.getCell(j - 1));
					}

				}
			}

			int datafirstRow = sheet.getFirstRowNum() + 1;
			int datalastRow = sheet.getLastRowNum();

			//remove empty rows from excel
			removenullrows(datafirstRow, datalastRow, sheet);

			// Create map of column as key and row value as value.

			for (int i = datafirstRow; i <= datalastRow; ) {
				LinkedHashMap<String, String> rowMap = new LinkedHashMap<>();
				int start = 0;
				row = sheet.getRow(i);
				if (row != null) {
					for (int j = 0; j <= numberOfCells; j++) {
						if (j == 0) {
							rowMap.put(header[start], Integer.toString(i));
						} else {
							rowMap.put(header[start], getCellDataToString(row.getCell(j - 1)));
						}
						start++;
					}
					maps.add(rowMap);
					i++;
				} else
					i++;
			}
			System.out.println("Test data map is created ");

		} catch (Exception e) {
			System.out.println("Unable to parse the excel file" + e.getCause());

		}


		// create object type to return
		Object[][] returnArray = new Object[maps.size()][1];
		for (int i = 0; i < maps.size(); i++) {
			returnArray[i][0] = maps.get(i);
		}
		return returnArray;
	}


	public static Workbook getWorkbookObj(FileInputStream fis, String fileName) {
		try {
			String fileExtensionName = fileName.substring(fileName.indexOf("."));
			if (fileExtensionName.equalsIgnoreCase(".xlsx")) {
				return new XSSFWorkbook(fis);
			} else if (fileExtensionName.equalsIgnoreCase(".xls")) {
				return new HSSFWorkbook(fis);
			} else {
				System.out.println("Invalid file type.");
				System.out.println("We support excel files with extension .xls or .xlsx");
				return null;
			}
		} catch (Exception e) {
			System.out.println("unable to read data" + e);
			return null;
		}
	}


	private static void removenullrows(int firstrow, int lastrow, Sheet sheet) {
		//Remove a row from this sheet.
		for (int i = firstrow; i <= lastrow; i++) {
			Row row = sheet.getRow(i);
			if (row == null) {
				sheet.removeRow(row);
			}

		}
	}

	private static String getCellDataToString(Cell cell) {
		if (null != cell) {
			switch (cell.getCellType()) {
				case BOOLEAN:
					return String.valueOf(cell.getBooleanCellValue()).trim();

				case STRING:
					return cell.getStringCellValue().trim();

				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						if (cell.getDateCellValue().toString() == "") {
							return "";
						} else {
							return cell.toString() + "";
						}
					} else {
						Double doubleValue = cell.getNumericCellValue();
						Long longValue = doubleValue.longValue();
						return new String(longValue.toString().trim());
					}
				default:
					return "";
			}
		} else {
			return "";
		}

	}






		public static void main (String[]args){
			Object[][] testdata = TestDataProviderUtility.ExcelToMap("src/test/resources/TestData/ridp_test_data.xlsx", "Sheet1");
			System.out.println(Arrays.deepToString(testdata));
		}

	}




