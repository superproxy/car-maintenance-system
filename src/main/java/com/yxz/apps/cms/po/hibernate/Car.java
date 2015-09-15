package com.yxz.apps.cms.po.hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: wmj
 * Date: 13-8-3
 * Time: 下午10:37
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Car {
    private String carCard;
    private Integer carOwnerId;
    private String carType;
    private Timestamp inputTime;
    private String carOwnerName;

    @Column(name = "carCard", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public String getCarCard() {
        return carCard;
    }

    public void setCarCard(String carCard) {
        this.carCard = carCard;
    }

    @Column(name = "carOwnerId", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public Integer getCarOwnerId() {
        return carOwnerId;
    }

    public void setCarOwnerId(Integer carOwnerId) {
        this.carOwnerId = carOwnerId;
    }

    @Column(name = "carType", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Column(name = "InputTime", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    @Basic
    public Timestamp getInputTime() {
        return inputTime;
    }

    public void setInputTime(Timestamp inputTime) {
        this.inputTime = inputTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (carCard != null ? !carCard.equals(car.carCard) : car.carCard != null) return false;
        if (carOwnerId != null ? !carOwnerId.equals(car.carOwnerId) : car.carOwnerId != null) return false;
        if (carType != null ? !carType.equals(car.carType) : car.carType != null) return false;
        if (inputTime != null ? !inputTime.equals(car.inputTime) : car.inputTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = carCard != null ? carCard.hashCode() : 0;
        result = 31 * result + (carOwnerId != null ? carOwnerId.hashCode() : 0);
        result = 31 * result + (carType != null ? carType.hashCode() : 0);
        result = 31 * result + (inputTime != null ? inputTime.hashCode() : 0);
        return result;
    }

    @Column(name = "carOwnerName", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getCarOwnerName() {
        return carOwnerName;
    }

    public void setCarOwnerName(String carOwnerName) {
        this.carOwnerName = carOwnerName;
    }
}
