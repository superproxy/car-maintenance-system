package com.yxz.apps.cms.po.hibernate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Orderdetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orderdetail", catalog = "car")
public class Orderdetail implements java.io.Serializable {

	// Fields
	private OrderdetailId id;
	private String barCode;
	private String peiJianFactory;
	private Long peiJianPrice;
	private Integer peiJianNum;
	private Long peiJianDiscount;
	private Long peiJianTotalPrice;
	private Long peiJianSingleDiscount;

	// Constructors

	/** default constructor */
	public Orderdetail() {
	}

	/** minimal constructor */
	public Orderdetail(OrderdetailId id) {
		this.id = id;
	}

	/** full constructor */
	public Orderdetail(OrderdetailId id, String barCode, String peiJianFactory,
			Long peiJianPrice, Integer peiJianNum, Long peiJianDiscount,
			Long peiJianTotalPrice, Long peiJianSingleDiscount) {
		this.id = id;
		this.barCode = barCode;
		this.peiJianFactory = peiJianFactory;
		this.peiJianPrice = peiJianPrice;
		this.peiJianNum = peiJianNum;
		this.peiJianDiscount = peiJianDiscount;
		this.peiJianTotalPrice = peiJianTotalPrice;
		this.peiJianSingleDiscount = peiJianSingleDiscount;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "peiJianId", column = @Column(name = "PeiJianId", nullable = false)),
			@AttributeOverride(name = "buyId", column = @Column(name = "BuyId", nullable = false)) })
	public OrderdetailId getId() {
		return this.id;
	}

	public void setId(OrderdetailId id) {
		this.id = id;
	}

	@Column(name = "BarCode")
	public String getBarCode() {
		return this.barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	@Column(name = "PeiJianFactory")
	public String getPeiJianFactory() {
		return this.peiJianFactory;
	}

	public void setPeiJianFactory(String peiJianFactory) {
		this.peiJianFactory = peiJianFactory;
	}

	@Column(name = "PeiJianPrice", precision = 10, scale = 0)
	public Long getPeiJianPrice() {
		return this.peiJianPrice;
	}

	public void setPeiJianPrice(Long peiJianPrice) {
		this.peiJianPrice = peiJianPrice;
	}

	@Column(name = "PeiJianNum")
	public Integer getPeiJianNum() {
		return this.peiJianNum;
	}

	public void setPeiJianNum(Integer peiJianNum) {
		this.peiJianNum = peiJianNum;
	}

	@Column(name = "PeiJianDiscount", precision = 10, scale = 0)
	public Long getPeiJianDiscount() {
		return this.peiJianDiscount;
	}

	public void setPeiJianDiscount(Long peiJianDiscount) {
		this.peiJianDiscount = peiJianDiscount;
	}

	@Column(name = "PeiJianTotalPrice", precision = 10, scale = 0)
	public Long getPeiJianTotalPrice() {
		return this.peiJianTotalPrice;
	}

	public void setPeiJianTotalPrice(Long peiJianTotalPrice) {
		this.peiJianTotalPrice = peiJianTotalPrice;
	}

	@Column(name = "PeiJianSingleDiscount", precision = 10, scale = 0)
	public Long getPeiJianSingleDiscount() {
		return this.peiJianSingleDiscount;
	}

	public void setPeiJianSingleDiscount(Long peiJianSingleDiscount) {
		this.peiJianSingleDiscount = peiJianSingleDiscount;
	}

}