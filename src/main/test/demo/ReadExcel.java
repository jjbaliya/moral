package demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * 读取excel内容
 * @author wgf
 *
 */

public class ReadExcel {
	
	private String filepath;
	private List list = new ArrayList();
	
	public ReadExcel(String filepath) {
		this.filepath = filepath;
	}
	
	public void readExcel() throws BiffException, IOException{
		//创建输入流;
		InputStream stream = new FileInputStream(filepath);  
		 //获取Excel文件对象  
        Workbook  rwb = Workbook.getWorkbook(stream);  
        //获取文件的指定工作表 默认的第一个  
        Sheet sheet = rwb.getSheet(0);    
        //行数(表头的目录不需要，从1开始)  
        for(int i = 0 ; i < sheet.getRows(); i++){
        	//创建一个数组，用户储存每一列的值；
        	String[] str = new String[sheet.getColumns()];
        	Cell cell = null;
        	//列数  
        	for(int j = 0 ; j < sheet.getColumns(); j++){
        		//获取第i行，第j列的值;
        		cell = sheet.getCell(j, i);
        		str[j] = cell.getContents();
        	}
        	//把刚获取的列存入list；
        	list.add(str);
        }
	}
	
	public void outData(){
		for(int i=0;i<list.size();i++){  
			String[] str = (String[]) list.get(i);
			for(int j = 0 ; j < str.length ; j++){
				System.out.print(str[j] + '\t');
				
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) throws BiffException, IOException{  
		
		ReadExcel excel = new ReadExcel("D:\\java\\java_data\\region.xls");
		excel.readExcel();
		excel.outData();
		
	}
	
}
