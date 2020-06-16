*package genericPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;*/

public class Generic

{
	public String getData(String sheetname,int rowno,int cellno)
	{
		String value="";
		try{
			
			FileInputStream f=new FileInputStream("G:\\final workspace\\FirstDemo\\Data\\FirstDemo.xlsx");
		
		
		Workbook	wb = WorkbookFactory.create(f);
		Sheet sheet=wb.getSheet(sheetname);
		Row row=sheet.getRow(rowno);
		Cell cell=row.getCell(cellno);
		
	switch (cell.getCellType())
		{
        case Cell.CELL_TYPE_STRING:
            System.out.println(cell.getRichStringCellValue().getString());
          
            break;
        case Cell.CELL_TYPE_NUMERIC:
            if (DateUtil.isCellDateFormatted(cell)) 
            {
                System.out.println(cell.getDateCellValue());
            } else {
                System.out.println(cell.getNumericCellValue());
            }
           
           break;
        case Cell.CELL_TYPE_BOOLEAN:
            System.out.println(cell.getBooleanCellValue());
            break;
        case Cell.CELL_TYPE_FORMULA:
            System.out.println(cell.getCellFormula());
           
           break;
        default:
            System.out.println();
    }
		DataFormatter formatter = new DataFormatter();
	    value=formatter.formatCellValue(cell);
	    
		f.close();
		wb.close();

		    }
		
		catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
		}

		
		catch (EncryptedDocumentException | InvalidFormatException| IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return value;
	
	}
	 //function to get the number of rows in sheet 
	
		public int getRowCount(String sheetname)
		{
			int count=0;
		try
		{
			FileInputStream f=new FileInputStream("G:\\final workspace\\FirstDemo\\Data\\FirstDemo.xlsx");
			
			Workbook wb=WorkbookFactory.create(f);
			Sheet sheet=wb.getSheet(sheetname);
			count=sheet.getLastRowNum();
			f.close();
			wb.close();
		}
		catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
		}

		
		catch (EncryptedDocumentException | InvalidFormatException| IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
		
			
		}
		
		
		//* function to set the data to the excel sheet *//
		public void setData(String sheetname,int rowno,int cellno,String data)
		{
			try
			{
				FileInputStream f=new FileInputStream("G:\\final workspace\\FirstDemo\\Data\\FirstDemo.xlsx");
				
				Workbook wb=WorkbookFactory.create(f);
				Sheet sheet=wb.getSheet(sheetname);
				Row row=sheet.getRow(rowno);
				Cell cell=row.getCell(cellno);
				if (cell == null) {

                    cell = row.createCell(cellno);

                    cell.setCellValue(data);

                    } else {

                        cell.setCellValue(data);

                    }

				cell.setCellValue(data);

            FileOutputStream fos=new FileOutputStream("G:\\final workspace\\FirstDemo\\Data\\FirstDemo.xlsx");
				wb.write(fos);
				f.close();
				fos.close();
				wb.close();
		  }
			catch (FileNotFoundException e)
			{
				
				e.printStackTrace();
			}

			
			catch (EncryptedDocumentException | InvalidFormatException| IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	


