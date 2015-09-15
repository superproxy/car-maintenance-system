package com.yxz.apps.cms.po.hibernate;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: wmj
 * Date: 13-8-4
 * Time: 上午11:11
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class CarOwner {
    private int carOwnerId;
    private String carOwnerName;
    private String carOwnerPhone;
    private String carOwnerAddress;
    private Timestamp inputTime;

    @javax.persistence.Column(name = "carOwnerId", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getCarOwnerId() {
        return carOwnerId;
    }

    public void setCarOwnerId(int carOwnerId) {
        this.carOwnerId = carOwnerId;
    }

    @javax.persistence.Column(name = "carOwnerName", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getCarOwnerName() {
        return carOwnerName;
    }

    public void setCarOwnerName(String carOwnerName) {
        this.carOwnerName = carOwnerName;
    }

    @javax.persistence.Column(name = "carOwnerPhone", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getCarOwnerPhone() {
        return carOwnerPhone;
    }

    public void setCarOwnerPhone(String carOwnerPhone) {
        this.carOwnerPhone = carOwnerPhone;
    }

    @javax.persistence.Column(name = "carOwnerAddress", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getCarOwnerAddress() {
        return carOwnerAddress;
    }

    public void setCarOwnerAddress(String carOwnerAddress) {
        this.carOwnerAddress = carOwnerAddress;
    }

    @javax.persistence.Column(name = "inputTime", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
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

        CarOwner carOwner = (CarOwner) o;

        if (carOwnerId != carOwner.carOwnerId) return false;
        if (carOwnerAddress != null ? !carOwnerAddress.equals(carOwner.carOwnerAddress) : carOwner.carOwnerAddress != null)
            return false;
        if (carOwnerName != null ? !carOwnerName.equals(carOwner.carOwnerName) : carOwner.carOwnerName != null)
            return false;
        if (carOwnerPhone != null ? !carOwnerPhone.equals(carOwner.carOwnerPhone) : carOwner.carOwnerPhone != null)
            return false;
        if (inputTime != null ? !inputTime.equals(carOwner.inputTime) : carOwner.inputTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = carOwnerId;
        result = 31 * result + (carOwnerName != null ? carOwnerName.hashCode() : 0);
        result = 31 * result + (carOwnerPhone != null ? carOwnerPhone.hashCode() : 0);
        result = 31 * result + (carOwnerAddress != null ? carOwnerAddress.hashCode() : 0);
        result = 31 * result + (inputTime != null ? inputTime.hashCode() : 0);
        return result;
    }
}
