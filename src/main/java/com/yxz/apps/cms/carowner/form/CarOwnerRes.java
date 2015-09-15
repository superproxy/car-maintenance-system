package com.yxz.apps.cms.carowner.form;

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
public class CarOwnerRes {
    private int carOwnerId;
    private String carOwnerName;
    private String carOwnerPhone;
    private String carOwnerAddress;

    public int getCarOwnerId() {
        return carOwnerId;
    }

    public void setCarOwnerId(int carOwnerId) {
        this.carOwnerId = carOwnerId;
    }

    public String getCarOwnerName() {
        return carOwnerName;
    }

    public void setCarOwnerName(String carOwnerName) {
        this.carOwnerName = carOwnerName;
    }

    public String getCarOwnerPhone() {
        return carOwnerPhone;
    }

    public void setCarOwnerPhone(String carOwnerPhone) {
        this.carOwnerPhone = carOwnerPhone;
    }

    public String getCarOwnerAddress() {
        return carOwnerAddress;
    }

    public void setCarOwnerAddress(String carOwnerAddress) {
        this.carOwnerAddress = carOwnerAddress;
    }
}
