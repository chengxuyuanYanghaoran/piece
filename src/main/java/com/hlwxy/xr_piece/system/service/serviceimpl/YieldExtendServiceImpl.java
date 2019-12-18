package com.hlwxy.xr_piece.system.service.serviceimpl;

import com.hlwxy.xr_piece.system.dao.YieldDao;
import com.hlwxy.xr_piece.system.dao.YieldExtendDao;
import com.hlwxy.xr_piece.system.domain.YieldDO;
import com.hlwxy.xr_piece.system.domain.YieldExtendDO;
import com.hlwxy.xr_piece.system.service.YieldExtendService;
import com.hlwxy.xr_piece.system.service.YieldService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class YieldExtendServiceImpl implements YieldExtendService {
	@Autowired
	private YieldExtendDao yieldExtendDao;

	@Override
	public List<YieldExtendDO> list(String mode) {
		List<Integer> list =yieldExtendDao.list();
		List<YieldExtendDO> yieldExtendDOS =new ArrayList<>();
		for (Integer id:list) {
			YieldExtendDO yieldExtendDO=yieldExtendDao.get(id);
			//计算每条数据的金额
			if ("0".equals(mode)){ //按产品计价
				if (yieldExtendDO.getProductPrice()!=null&&yieldExtendDO.getHarvest()!=null){
					BigDecimal money =yieldExtendDO.getProductPrice().multiply(BigDecimal.valueOf(yieldExtendDO.getHarvest()));
					yieldExtendDO.setMoney(money);
				}
			}else { //按工序计价
				if (yieldExtendDO.getProPrice()!=null&&yieldExtendDO.getHarvest()!=null){
					BigDecimal money =yieldExtendDO.getProPrice().multiply(BigDecimal.valueOf(yieldExtendDO.getHarvest()));
					yieldExtendDO.setMoney(money);
				}
			}
			yieldExtendDOS.add(yieldExtendDO);
		}
		return yieldExtendDOS;
	}

	@Override
	public YieldExtendDO get(int id,String mode) {
		YieldExtendDO yieldExtendDO=yieldExtendDao.get(id);
		//计算每条数据的金额
		if ("0".equals(mode)){ //按产品计价
			if (yieldExtendDO.getProductPrice()!=null&&yieldExtendDO.getHarvest()!=null){
				BigDecimal money =yieldExtendDO.getProductPrice().multiply(BigDecimal.valueOf(yieldExtendDO.getHarvest()));
				yieldExtendDO.setMoney(money);
			}
		}else { //按工序计价
			if (yieldExtendDO.getProPrice()!=null&&yieldExtendDO.getHarvest()!=null){
				BigDecimal money =yieldExtendDO.getProPrice().multiply(BigDecimal.valueOf(yieldExtendDO.getHarvest()));
				yieldExtendDO.setMoney(money);
			}
		}
		return yieldExtendDO;
	}

	@Override
	public void getHeaderId(Integer[] ids) {
		//创建一个存放表头id的集合
		List<Integer> list1 =new ArrayList<>();
		//遍历表体的id
		for (int i= 0;i<ids.length;i++){
			//根据表体id获取表头id
			Integer headerId=yieldExtendDao.getHeaderId(ids[i]);
			//创建临时变量
			Integer tapo=headerId;
//			for (Integer j:list1) {
				//如果表头id的集合为空，添加一个元素，如果不为空将临时变量与集合中的所有值进行比较
				if (list1.size()==0){
					list1.add(tapo);
				}else {
					//临时变量与表头id集合中的所有值都不不同则添加id，相同则不添加
					for (Integer x:list1) {
						if (tapo==x){}else {
							list1.add(tapo);
						}
					}
				}
//			}
		}
		updateStats2(list1);
	}

	@Override
	public void add(List<YieldExtendDO> yieldExtendDOS) {
		yieldExtendDao.add(yieldExtendDOS);
	}

	@Override
	public List<Integer> findWagesId(String code) {
		return yieldExtendDao.findWagesId(code);
	}

	/*
	* 修改表头状态值二的方法
	* */
	private void updateStats2(List<Integer> list){
		for (Integer i:list) {
			yieldExtendDao.updateStats2(i);
		}
	}
}
