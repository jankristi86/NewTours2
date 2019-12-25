package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

public class ExcelUtils {

	private static HSSFWorkbook ExcelWBook;
	private static HSSFSheet ExcelWSheet;
	private static HSSFCell Cell;
	private static HSSFRow Row;
	private static DataFormatter formatter;

	public static void setExcelFile(String Path, String SheetName) throws Exception {
		try {
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new HSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			formatter = new DataFormatter();

		} catch (Exception e) {
			throw (e);
		}
	}

	public static String getCellData(int RowNum, int ColNum) {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = formatter.formatCellValue(Cell);
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {
		try {
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}
			FileOutputStream fileOut = new FileOutputStream(Constant.PATH_TESTDATA + Constant.FILE_DATA);
			ExcelWBook.write(fileOut);

			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}

	public static HSSFSheet getWorkSheet() {
		return ExcelWSheet;
	}
}
