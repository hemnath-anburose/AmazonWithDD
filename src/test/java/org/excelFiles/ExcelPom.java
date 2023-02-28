package org.excelFiles;

import java.util.Objects;

public class ExcelPom {
	
	private final String fileName;
	private final String fileLocation;
	private final String SheetName;
	private int index = -1;
	
	private ExcelPom(String fileName, String fileLocation, String SheetName, int index) {
		this.fileName = fileName;
		this.fileLocation = fileLocation;
		this.SheetName = SheetName;
		this.index = index;
	}

	public String getFileName() {
		return fileName;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public String getSheetName() {
		return SheetName;
	}

	public int getIndex() {
		return index;
	}
	
	public static class ExcelPomReader{
		private String fileName;
		private String fileLocation;
		private String SheetName;
		private int index = -1;
		
		public ExcelPomReader setFileName(String fileName) {
			this.fileName = fileName;
			return this;
		}
		public ExcelPomReader setFileLocation(String fileLocation) {
			this.fileLocation = fileLocation;
			return this;
		}
		public ExcelPomReader setSheetName(String SheetName) {
			this.SheetName = SheetName;
			return this;
		}
		public ExcelPomReader setIndex(int index) {
			this.index = index;
			return this;
		}
		
		public ExcelPom reader() {
			Objects.requireNonNull(fileName);
			Objects.requireNonNull(fileLocation);
			Objects.requireNonNull(SheetName);
			return new ExcelPom(fileName, fileLocation, SheetName, index);
		}
	}
}
