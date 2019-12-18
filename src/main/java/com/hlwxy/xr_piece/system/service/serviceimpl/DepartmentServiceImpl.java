package com.hlwxy.xr_piece.system.service.serviceimpl;

import com.hlwxy.xr_piece.system.dao.DepartmentDao;
import com.hlwxy.xr_piece.system.domain.DepartmentDO;
import com.hlwxy.xr_piece.system.service.DepartmentService;
import org.apache.poi.hssf.usermodel.HSSFChart;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;





@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	public DepartmentDO get(Integer id){
		return departmentDao.get(id);
	}
	
	@Override
	public List<DepartmentDO> list(Map<String, Object> map){
		return departmentDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return departmentDao.count(map);
	}
	
	@Override
	public int save(DepartmentDO department){
		return departmentDao.save(department);
	}
	
	@Override
	public int update(DepartmentDO department){
		return departmentDao.update(department);
	}
	
	@Override
	public int remove(Integer id){
		return departmentDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return departmentDao.batchRemove(ids);
	}

	/*
	@Override
	public HSSFWorkbook exportExcel(Integer id) {
		//创建一个工作簿
		HSSFWorkbook wb=new HSSFWorkbook();
		try{
			//创建工作表
			HSSFSheet sheet=wb.createSheet("部门信息");
			//创建表头
			HSSFRow row=sheet.createRow((short)0);
			row.createCell(0).setCellValue("id");
			row.createCell(1).setCellValue("部门编号");
			row.createCell(2).setCellValue("部门名称");
			//向表格中插入文件
			DepartmentDO departmentDO=departmentDao.get(id);
			Row row1=sheet.createRow((short)1);
			row1.createCell(0).setCellValue(departmentDO.getId());
			row1.createCell(1).setCellValue(departmentDO.getBmCode());
			row1.createCell(2).setCellValue(departmentDO.getBmName());
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}

		return wb;
	}
	*/

}
