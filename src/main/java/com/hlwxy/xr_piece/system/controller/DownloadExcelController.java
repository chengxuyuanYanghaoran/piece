package com.hlwxy.xr_piece.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;



/**
 *
 * @author yanghaoran
 * @email 1992lcg@163.com
 * @date 2019-11-11 17:24:05
 */

@Controller
@RequestMapping("/system/downloadExcel")
public class DownloadExcelController {

	@ResponseBody
	@RequestMapping("/product")
	public void product(HttpServletResponse response){
		//下载产品表格
		String fileRoute = "C:\\";
		String fileName="产品模板.xlsx";
		String filenameZip = fileRoute + fileName;//获取文件的路径
		download(response,filenameZip,fileName);

	}

	// 下载工序表格
	@ResponseBody
	@RequestMapping("/procedure")
	public void procedure(HttpServletResponse response){
		String fileRoute = "C:\\";
		String fileName="工序模板.xlsx";
		String filenameZip = fileRoute + fileName;//获取文件的路径
		download(response,filenameZip,fileName);
	}

	//封装下载代码
	private void download(HttpServletResponse response,String filenameZip,String fileName){
		try {
			response.setContentType("application/x-execl");
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String((fileName).getBytes(), "UTF-8"));
			// 读取文件
			InputStream in = new FileInputStream(filenameZip);
			ServletOutputStream outputStream = response.getOutputStream();
			// 写文件
			int b;
			while ((b = in.read()) != -1) {
				outputStream.write(b);
			}
			in.close();
			outputStream.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
