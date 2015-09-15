package com.yxz.apps.cms.po.hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OrderdetailId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class OrderdetailId implements java.io.Serializable {

	// Fields

	private Integer peiJianId;
	private Integer buyId;

	// Constructors

	/** default constructor */
	public OrderdetailId() {
	}

	/** full constructor */
	public OrderdetailId(Integer peiJianId, Integer buyId) {
		this.peiJianId = peiJianId;
		this.buyId = buyId;
	}

	// Property accessors

	@Column(name = "PeiJianId", nullable = false)
	public Integer getPeiJianId() {
		return this.peiJianId;
	}

	public void setPeiJianId(Integer peiJianId) {
		this.peiJianId = peiJianId;
	}

	@Column(name = "BuyId", nullable = false)
	public Integer getBuyId() {
		return this.buyId;
	}

	public void setBuyId(Integer buyId) {
		this.buyId = buyId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderdetailId))
			return false;
		OrderdetailId castOther = (OrderdetailId) other;

		return ((this.getPeiJianId() == castOther.getPeiJianId()) || (this
				.getPeiJianId() != null && castOther.getPeiJianId() != null && this
				.getPeiJianId().equals(castOther.getPeiJianId())))
				&& ((this.getBuyId() == castOther.getBuyId()) || (this
						.getBuyId() != null && castOther.getBuyId() != null && this
						.getBuyId().equals(castOther.getBuyId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPeiJianId() == null ? 0 : this.getPeiJianId().hashCode());
		result = 37 * result
				+ (getBuyId() == null ? 0 : this.getBuyId().hashCode());
		return result;
	}

}