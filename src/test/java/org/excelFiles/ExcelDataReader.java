package org.excelFiles;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.reactivex.rxjava3.functions.BiConsumer;

public class ExcelDataReader implements IDataReader {
	
	private final ExcelPom xlConfig;
	
	public ExcelDataReader(ExcelPom xlConfig) {
		this.xlConfig = xlConfig;
	}
	
	//calling workbook
	public XSSFWorkbook getWorkBook() throws InvalidFormatException, IOException {
		return new XSSFWorkbook(new File(xlConfig.getFileLocation()));
	}
	//calling sheet
	private XSSFSheet getSheet(XSSFWorkbook workBook) {
		return workBook.getSheet(xlConfig.getSheetName());
	}
	//calling header
	private List<String> getHeader(XSSFSheet sheet) {
		final List<String> headers = new ArrayList<String>();
		XSSFRow row = sheet.getRow(0);
		row.forEach(new Consumer<Cell>() {
			@Override
			public void accept(Cell cell) {
				headers.add(cell.getStringCellValue());
			}
		});
		return (List<String>) Collections.unmodifiableCollection(headers);
	}
	public List<Map<String, String>> getAllRows() {
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		try (XSSFWorkbook workbook = getWorkBook()){
			XSSFSheet sheet = getSheet(workbook);
			data = getData(sheet);
		} catch (Throwable e) {
			System.out.println("ExcelDataReader.getAllRows()"+ e);
		}
		return Collections.unmodifiableList(data);
	}
	
	private List<Map<String,String>> getData(XSSFSheet sheet) throws Throwable{
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		final List<String> headers = getHeader(sheet);
		for(int i =1 ; i<= sheet.getLastRowNum(); i++) {
			final Map<String, String> rowMap = new HashMap<String, String>();
			XSSFRow row = sheet.getRow(i);
			forEachWithCounter(row,new BiConsumer<Integer, Cell>() {
				@Override
				public void accept(Integer index, Cell cell) throws Throwable {
					String header = headers.get(index);
					String value = cell.getStringCellValue();
					rowMap.put(header, value);
				}
			});
			data.add(rowMap);
		}
		return Collections.unmodifiableList(data);
	}
	
	private Map<String,String> getData(XSSFSheet sheet, int rowIndex) throws Throwable{
			final List<String> headers = getHeader(sheet);
			final Map<String, String> rowMap = new HashMap<String, String>();
			XSSFRow row = sheet.getRow(rowIndex);
			forEachWithCounter(row,new BiConsumer<Integer, Cell>() {
				@Override
				public void accept(Integer index, Cell cell) throws Throwable {
					String header = headers.get(index);
					String value = cell.getStringCellValue();
					rowMap.put(header, value);
				}
			});
		return Collections.unmodifiableMap(rowMap);
	}

	public Map<String, String> getASingleRow() {
		Map<String, String> data = new HashedMap<String, String>();
		try (XSSFWorkbook workbook = getWorkBook()){
			XSSFSheet sheet = getSheet(workbook);
			data = getData(sheet, xlConfig.getIndex());
		} catch (Throwable e) {
			System.out.println("ExcelDataReader.getAllRows()"+ e);
		}
		return Collections.unmodifiableMap(data);
	}
	private void forEachWithCounter(Iterable<Cell> source, BiConsumer<Integer, Cell> biConsumer) throws Throwable {
		int i = 0;
		for (Cell cell : source) {
			biConsumer.accept(i, cell);
			i++;
		}
	}
}
