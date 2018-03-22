package com.yueting.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.yueting.model.Jiuye;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ReadExcel {
 public static void main(String[] args) throws Exception {
//  File file = new File("test1.xls");
//  if(!file.exists()){
//   file.createNewFile();
//  }
//  List<Computer> computers = new ArrayList<Computer>();
//  computers.add(new Computer(1,"宏碁","笔记本电脑",3333,9.0));
//  computers.add(new Computer(2,"苹果","笔记本电脑，一体机",8888,9.6));
//  computers.add(new Computer(3,"联想","笔记本电脑，台式机",4444,9.3));
//  computers.add(new Computer(4, "华硕", "笔记本电脑,平板电脑",3555,8.6));
//  computers.add(new Computer(5, "注解", "以上价格均为捏造，如有雷同，纯属巧合", 1.0, 9.9));
//  write2excel(computers, file);
  
  System.out.println("-------------------------");
  
	 String fileName = "test1.xls";
	 System.out.println(ReadExcel.readExcel(fileName));
	
		
  
 }
 
 public static void write2excel(List<Jiuye> jiuye,File file) {
  //创建操作Excel的HSSFWorkbook对象
  HSSFWorkbook excel = new HSSFWorkbook();
  //创建HSSFSheet对象
  //Excel中的一个sheet（工作表)对应着java中的一个HSSFSheet对象，
  //利用HSSFWorkbook对象可以创建一个HSSFSheet对象
  HSSFSheet sheet = excel.createSheet("jiuye");
  //创建第一行标题信息的HSSFRow对象
  HSSFRow firstRow = sheet.createRow(0);
  //创建标题行中的HSSFCell数组
  //假设我们一行有五列数据
  HSSFCell cells[] = new HSSFCell[9];
  
 
  
  
  //创建标题数据，并通过HSSFCell对象的setCellValue()方法对每个单元格进行赋值
  String[] titles = new String[] { "NAME", "sex", "school", "major","graduate","tel","comname","xuqiu","salary",
    "jiuyetime" };
  //通过for循环来填充第一行标题的数据
  for (int i = 0; i < 9; i++) {
   cells[0] = firstRow.createCell(i);
   cells[0].setCellValue(titles[i]);
  }
 
  // 向excel中写入数据
  for (int i = 0; i < jiuye.size(); i++) {
   HSSFRow row = sheet.createRow(i + 1);
   Jiuye jiu = jiuye.get(i);
   HSSFCell cell = row.createCell(0);
   cell.setCellValue(jiu.getNAME());
   cell = row.createCell(1);
   cell.setCellValue(jiu.getSex());
   cell = row.createCell(2);
   cell.setCellValue(jiu.getSchool());
   cell = row.createCell(3);
   cell.setCellValue(jiu.getMajor());
   cell = row.createCell(4);
   cell.setCellValue(jiu.getGraduate());
   cell = row.createCell(5);
   cell.setCellValue(jiu.getTel());
   cell = row.createCell(6);
   cell.setCellValue(jiu.getComname());
   cell = row.createCell(7);
   cell.setCellValue(jiu.getXuqiu());
   cell = row.createCell(8);
   cell.setCellValue(jiu.getSalary());
   cell = row.createCell(9);
   cell.setCellValue(jiu.getJiuyetime());
  }
  //将数据真正的写入excel文件中
  //做到这里，数据都写好了，最后就是把HSSFWorkbook对象excel写入文件中了。
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            excel.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("数据已经写入excel"); //温馨提示
 }
 
 
 public static String readExcel(String fileName) {
	 StringBuffer sb = new StringBuffer();
		Workbook wb = null;
		try {
			// 构造Workbook（工作薄）对象
			wb = Workbook.getWorkbook(new File(fileName));
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (wb == null)
			return null;

		// 获得了Workbook对象之后，就可以通过它得到Sheet（工作表）对象了
		Sheet[] sheet = wb.getSheets();

		if (sheet != null && sheet.length > 0) {
			// 对每个工作表进行循环
			for (int i = 0; i < sheet.length; i++) {
				// 得到当前工作表的行数
				int rowNum = sheet[i].getRows();
				for (int j = 0; j < rowNum; j++) {
					// 得到当前行的所有单元格
					Cell[] cells = sheet[i].getRow(j);
					if (cells != null && cells.length > 0) {
						// 对每个单元格进行循环
						for (int k = 0; k < cells.length; k++) {
							// 读取当前单元格的值
							String cellValue = cells[k].getContents();
							sb.append(cellValue + "\t");
						}
					}
					sb.append("\r\n");
				}
				sb.append("\r\n");
			}
		}
		// 最后关闭资源，释放内存
		wb.close();
		return sb.toString();
	}

}