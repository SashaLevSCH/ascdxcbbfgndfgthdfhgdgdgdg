package utils;

import utils.Res;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ExcelUtil {

    private static String filePath1;
    private static  int sheetIndex1;
    private String filePath;
    private int sheetIndex;
    public ExcelUtil(String fileName, int sheetIndex){
        this.filePath = Res.getResource(fileName).getPath();
        this.sheetIndex = sheetIndex;
    }
    public Sheet getSheet(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Create Workbook instance for xlsx/xls file input stream
        Workbook workbook = null;
        try {
        if (filePath.toLowerCase().endsWith("xlsx")) {
            workbook = new XSSFWorkbook(fis);
        } else if (filePath.toLowerCase().endsWith("xls")) {
            workbook = new HSSFWorkbook(fis);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Get the nth sheet from the workbook
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        return sheet;
    }
    public List<Map> getListOfFilteredRecordAsHashMap(String columnHeader, String cellvalue){
        List<Map> list = new ArrayList<>();
        Sheet sheet = getSheet();
        Row row0 = sheet.getRow(0);
        int columnHeaderIndexForFilter = getMatchingColumnHeaderIndex(row0,columnHeader);
        int rowCount = sheet.getLastRowNum();
        for (int rowNum = 1; rowNum < rowCount; rowNum++) {
            Row row = sheet.getRow(rowNum);
            int columnCount = row.getLastCellNum();
            Cell cell = row.getCell(columnHeaderIndexForFilter);
            if(null == cell){
                System.out.println("test1");
            }
            if(getCellValueAsString(cell).trim().equalsIgnoreCase(cellvalue)){
                Map<String,String> map = new HashMap<>();
                for (int column = 0; column < columnCount; column++) {
                    Cell cell1 = row0.getCell(column);
                    Cell cell2 = row.getCell(column);
                    if(cell1 != null) {
                        map.put(getCellValueAsString(cell1), getCellValueAsString(cell2));
                    }else{
                        break;
                    }
                }
                list.add(map);
            }

        }
        return list;
    }

    private int getMatchingColumnHeaderIndex(Row row0, String columnHeader) {
        int columnCount = row0.getLastCellNum();
        for (int i = 0; i < columnCount; i++) {
            Cell cell = row0.getCell(i);
            if(getCellValueAsString(cell).trim().equalsIgnoreCase(columnHeader)){
                return i;
            }
        }
        return 0;
    }

    public String getCellValueAsString(Cell cell) {
        String cellValue = null;
        switch (cell.getCellType()) {
            case NUMERIC:
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
                cellValue= cell.getCellFormula();
            case BLANK:
                cellValue="BLANK";
            default:
                cellValue ="DEFAULT";
        }
        return cellValue;
    }


}
