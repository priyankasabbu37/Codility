package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import beans.Employee;

public class XLSMaker {
	
	private static String[] columns = {"Name", "Email", "Date Of Birth", "Salary"};
    private static List<Employee> employees =  new ArrayList<>();
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    static 
    {
    	for(int i = 1; i <= 10; i++)
    	{
    		employees.add(new Employee("A"+i,"a@gmail.com"+i,new Date(),1000+i));
    	}
    }
    
    static void writeXLSX() throws IOException
    {
    	//create a workbook
    	Workbook workbook = new HSSFWorkbook();
    	
    	//create a sheet
    	Sheet sheet = workbook.createSheet(	);

    	//font style for headers
    	Font font = workbook.createFont();
    	font.setBoldweight((short) (12));
    	font.setColor(IndexedColors.DARK_GREEN.getIndex());
    	font.setFontName("calibri");
    	
    	CellStyle headerCellStyle = workbook.createCellStyle();
    	headerCellStyle.setFont(font);  
    	
    	// an header row
    	Row headerRow  = sheet.createRow(0);
    	
    	for (int i = 0; i < columns.length; i++) {
			
    		Cell cell = headerRow .createCell(i);
    		cell.setCellValue(columns[i]);
    		cell.setCellStyle(headerCellStyle);
		}
    	
    	int rowNum = 1;
    	
    	for (Employee employee : employees) {
			
    		Row row = sheet.createRow(rowNum++);
    		row.createCell(0).setCellValue(employee.getName());
    		row.createCell(1).setCellValue(employee.getEmail());
    		
    		Cell dateOfBirthCell = row.createCell(2);
    		dateOfBirthCell.setCellValue(simpleDateFormat.format(employee.getDateOfBirth()));
    		
    		row.createCell(3).setCellValue(employee.getSalary());
		}
    	
		FileOutputStream outputStream = new FileOutputStream("emp.xlsx");
		workbook.write(outputStream);
		outputStream.flush();
		outputStream.close();

    }
    static void readXLSX() throws IOException, ParseException
    {
    	FileInputStream fileInputStream = new FileInputStream("emp.xlsx");
    	
    	Workbook workbook = new HSSFWorkbook(fileInputStream);
    	Sheet sheet       = workbook.getSheetAt(0);
    	Iterator<Row> iterator = sheet.iterator();
    	
    	List<Employee> empList = new ArrayList<>();
    	Employee employee      = null;
    	iterator.next();
    	while (iterator.hasNext())
    	{
    		employee = new Employee();
			Row currentRow = (Row) iterator.next();
			Iterator<Cell> cellIterator = currentRow.iterator();
			
			while (cellIterator.hasNext())
			{
				Cell cell = (Cell) cellIterator.next();
				int index = cell != null ? cell.getColumnIndex() : -1;
				
				if(index == -1)
					break;
					
				switch (index) 
				{
					case 0:
						employee.setName(cell.getStringCellValue());
						break;
						
					case 1:
						employee.setEmail(cell.getStringCellValue());
						break;
		
					case 2:
						Date d = simpleDateFormat.parse(cell.getStringCellValue());
						simpleDateFormat.format(d);
						employee.setDateOfBirth(d);
						break;
					
					case 3:
						employee.setSalary(cell.getNumericCellValue());
						break;
					
					default:
						break;
				}
			}
			empList.add(employee);
			System.out.println(employee);
		}
    }
    public static void main(String[] args) {
	
    	try 
    	{
			writeXLSX();
			readXLSX();
		}
    	catch (IOException | ParseException e) 
    	{
			e.printStackTrace();
		}
 	}
}
