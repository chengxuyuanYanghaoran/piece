package com.hlwxy.xr_piece.system.service.serviceimpl;

import com.hlwxy.xr_piece.system.dao.YieldDao;
import com.hlwxy.xr_piece.system.domain.YieldDO;
import com.hlwxy.xr_piece.system.domain.YieldHeaderDO;
import com.hlwxy.xr_piece.system.service.YieldService;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;





@Service
public class YieldServiceImpl implements YieldService {
	@Autowired
	private YieldDao yieldDao;
	
	@Override
	public YieldDO get(Integer id){
		return yieldDao.get(id);
	}
	
	@Override
	public List<YieldDO> list(Map<String, Object> map){
		return yieldDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return yieldDao.count(map);
	}
	
	@Override
	public int save(YieldDO yield){
		return yieldDao.save(yield);
	}
	
	@Override
	public int update(YieldDO yield){
		return yieldDao.update(yield);
	}
	
	@Override
	public int remove(Integer id){
		return yieldDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return yieldDao.batchRemove(ids);
	}

//	 YieldHeaderDO yieldHeaderDO,
	@Override
	public void importTable(XSSFWorkbook hssfWorkbook,String mode) {
		XSSFSheet sheet = hssfWorkbook.getSheetAt(0);
		System.out.println("表格的最大行数："+sheet.getLastRowNum());
		List<YieldDO> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		YieldDO yieldDO;

		for (int i=1;i<sheet.getLastRowNum()+1;i++){
			Row row =sheet.getRow(i);
			yieldDO = new YieldDO();
//			yieldDO.setYieldCode(yieldHeaderDO.getYieldCode());
			if (row.getCell(0).toString()!=null&&!row.getCell(0).toString().equals("")){
				System.out.println(row.getCell(0).toString());
				String dataStr=row.getCell(0).toString();
				Date date = null;
				try {
					date = new Date(String.valueOf(sdf.parse(dataStr)));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				yieldDO.setDateMark(date);
			}
			if (row.getCell(1).toString()!=null&&!row.getCell(1).toString().equals("")){
				yieldDO.setPeopleCode(row.getCell(1).toString());
			}
			if (row.getCell(2).toString()!=null&&!row.getCell(2).toString().equals("")){
				yieldDO.setName(row.getCell(2).toString());
			}

			if(mode.equals("1") ){  //工序计价
				if (row.getCell(3).toString()!=null&&!row.getCell(3).toString().equals("")){
					yieldDO.setProCode(row.getCell(3).toString());
				}
				if (row.getCell(4).toString()!=null&&!row.getCell(4).toString().equals("")){
					yieldDO.setProName(row.getCell(4).toString());
				}
			}

			if(mode.equals("0") ){  //产品计价
				if (row.getCell(3).toString()!=null&&!row.getCell(3).toString().equals("")){
					yieldDO.setProductCode(row.getCell(3).toString());
				}
				if (row.getCell(4).toString()!=null&&!row.getCell(4).toString().equals("")){
					yieldDO.setProductName(row.getCell(4).toString());
				}
			}

			if (row.getCell(5).toString()!=null&&!row.getCell(5).toString().equals("")){
				String str = (row.getCell(5).toString()).substring(0,(row.getCell(5).toString()).indexOf("."));
				yieldDO.setHarvest(Integer.valueOf(str));
			}

			list.add(yieldDO);
		}

//		yieldDao.addYieldHeaderDO(yieldHeaderDO);//插入表头
		if (mode.equals("0")){
			yieldDao.importTable(list);//插入表体（产品）
		}
		if (mode.equals("1")){
			yieldDao.importProTable(list);//插入表体（工序）
		}

	}

}
