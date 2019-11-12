package com.hlwxy.xr_piece.system.domain;

import java.io.Serializable;


/**
 * 
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-11 17:24:41
 */
public class ProductDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//产品编码
	private String productCode;
	//产品名称
	private String productName;
	//规格型号
	private String productModel;
	//产品计件单价
	private Double productPrice;

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：产品编码
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	/**
	 * 获取：产品编码
	 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * 设置：产品名称
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * 获取：产品名称
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * 设置：规格型号
	 */
	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}
	/**
	 * 获取：规格型号
	 */
	public String getProductModel() {
		return productModel;
	}
	/**
	 * 设置：产品计件单价
	 */
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	/**
	 * 获取：产品计件单价
	 */
	public Double getProductPrice() {
		return productPrice;
	}
}
