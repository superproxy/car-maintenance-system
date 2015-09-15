package com.yxz.apps.cms.po.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "order", catalog = "car")
public class Order implements java.io.Serializable {

    // Fields
    private Long buyId;
    private Timestamp inputDate;
    private Timestamp buyDate;
    private String inputPersonId;
    private String buyPerson;
    private Long discount;
    private Long totalPrice;


    /**
     * default constructor
     */
    public Order() {
    }

    /**
     * minimal constructor
     */
    public Order(Long buyId) {
        this.buyId = buyId;
    }

    // Constructors

    /**
     * full constructor
     */
    public Order(Long buyId, Timestamp inputDate, Timestamp buyDate,
                 String inputPersonId, String buyPerson, Long discount,
                 Long totalPrice) {
        this.buyId = buyId;
        this.inputDate = inputDate;
        this.buyDate = buyDate;
        this.inputPersonId = inputPersonId;
        this.buyPerson = buyPerson;
        this.discount = discount;
        this.totalPrice = totalPrice;
    }

    // Property accessors
    @Id
    @Column(name = "BuyId", unique = true, nullable = false)
    public Long getBuyId() {
        return this.buyId;
    }

    public void setBuyId(Long buyId) {
        this.buyId = buyId;
    }

    @Column(name = "InputDate", length = 19)
    public Timestamp getInputDate() {
        return this.inputDate;
    }

    public void setInputDate(Timestamp inputDate) {
        this.inputDate = inputDate;
    }

    @Column(name = "BuyDate", length = 19)
    public Timestamp getBuyDate() {
        return this.buyDate;
    }

    public void setBuyDate(Timestamp buyDate) {
        this.buyDate = buyDate;
    }

    @Column(name = "InputPersonId")
    public String getInputPersonId() {
        return this.inputPersonId;
    }

    public void setInputPersonId(String inputPersonId) {
        this.inputPersonId = inputPersonId;
    }

    @Column(name = "BuyPerson")
    public String getBuyPerson() {
        return this.buyPerson;
    }

    public void setBuyPerson(String buyPerson) {
        this.buyPerson = buyPerson;
    }

    @Column(name = "Discount", precision = 10, scale = 0)
    public Long getDiscount() {
        return this.discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    @Column(name = "TotalPrice", precision = 10, scale = 0)
    public Long getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

}