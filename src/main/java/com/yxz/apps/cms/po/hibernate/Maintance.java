package com.yxz.apps.cms.po.hibernate;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: wmj
 * Date: 13-8-3
 * Time: 下午9:35
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Maintance {
    private String maintanceId;
    private String carCard;
    private String carOwnerId;
    private Integer carStatus;
    private String failReason;
    private Integer failType;
    private Timestamp finishedTime;
    private Integer maintanceEvaluate;
    private Timestamp receiveTime;
    private Timestamp repaireTime;
    private Timestamp takenTime;

    @javax.persistence.Column(name = "maintanceId", nullable = false, insertable = true, updatable = true, length = 14, precision = 0)
    @Id
    public String getMaintanceId() {
        return maintanceId;
    }

    public void setMaintanceId(String maintanId) {
        this.maintanceId = maintanId;
    }

    @javax.persistence.Column(name = "carCard", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String getCarCard() {
        return carCard;
    }

    public void setCarCard(String carCard) {
        this.carCard = carCard;
    }

    @javax.persistence.Column(name = "carOwnerId", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String getCarOwnerId() {
        return carOwnerId;
    }

    public void setCarOwnerId(String carOwnerId) {
        this.carOwnerId = carOwnerId;
    }

    @javax.persistence.Column(name = "carStatus", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public Integer getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(Integer carStatus) {
        this.carStatus = carStatus;
    }

    @javax.persistence.Column(name = "failReason", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    @javax.persistence.Column(name = "failType", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public Integer getFailType() {
        return failType;
    }

    public void setFailType(Integer failType) {
        this.failType = failType;
    }

    @javax.persistence.Column(name = "finishedTime", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    @Basic
    public Timestamp getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(Timestamp finishedTime) {
        this.finishedTime = finishedTime;
    }

    @javax.persistence.Column(name = "maintanceEvaluate", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public Integer getMaintanceEvaluate() {
        return maintanceEvaluate;
    }

    public void setMaintanceEvaluate(Integer maintanceEvaluate) {
        this.maintanceEvaluate = maintanceEvaluate;
    }

    @javax.persistence.Column(name = "receiveTime", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    @Basic
    public Timestamp getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Timestamp receiveTime) {
        this.receiveTime = receiveTime;
    }

    @javax.persistence.Column(name = "repaireTime", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    @Basic
    public Timestamp getRepaireTime() {
        return repaireTime;
    }

    public void setRepaireTime(Timestamp repaireTime) {
        this.repaireTime = repaireTime;
    }

    @javax.persistence.Column(name = "takenTime", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    @Basic
    public Timestamp getTakenTime() {
        return takenTime;
    }

    public void setTakenTime(Timestamp takenTime) {
        this.takenTime = takenTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Maintance maintance = (Maintance) o;

        if (carCard != null ? !carCard.equals(maintance.carCard) : maintance.carCard != null) return false;
        if (carOwnerId != null ? !carOwnerId.equals(maintance.carOwnerId) : maintance.carOwnerId != null) return false;
        if (carStatus != null ? !carStatus.equals(maintance.carStatus) : maintance.carStatus != null) return false;
        if (failReason != null ? !failReason.equals(maintance.failReason) : maintance.failReason != null) return false;
        if (failType != null ? !failType.equals(maintance.failType) : maintance.failType != null) return false;
        if (finishedTime != null ? !finishedTime.equals(maintance.finishedTime) : maintance.finishedTime != null)
            return false;
        if (maintanceId != null ? !maintanceId.equals(maintance.maintanceId) : maintance.maintanceId != null) return false;
        if (maintanceEvaluate != null ? !maintanceEvaluate.equals(maintance.maintanceEvaluate) : maintance.maintanceEvaluate != null)
            return false;
        if (receiveTime != null ? !receiveTime.equals(maintance.receiveTime) : maintance.receiveTime != null)
            return false;
        if (repaireTime != null ? !repaireTime.equals(maintance.repaireTime) : maintance.repaireTime != null)
            return false;
        if (takenTime != null ? !takenTime.equals(maintance.takenTime) : maintance.takenTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = maintanceId != null ? maintanceId.hashCode() : 0;
        result = 31 * result + (carCard != null ? carCard.hashCode() : 0);
        result = 31 * result + (carOwnerId != null ? carOwnerId.hashCode() : 0);
        result = 31 * result + (carStatus != null ? carStatus.hashCode() : 0);
        result = 31 * result + (failReason != null ? failReason.hashCode() : 0);
        result = 31 * result + (failType != null ? failType.hashCode() : 0);
        result = 31 * result + (finishedTime != null ? finishedTime.hashCode() : 0);
        result = 31 * result + (maintanceEvaluate != null ? maintanceEvaluate.hashCode() : 0);
        result = 31 * result + (receiveTime != null ? receiveTime.hashCode() : 0);
        result = 31 * result + (repaireTime != null ? repaireTime.hashCode() : 0);
        result = 31 * result + (takenTime != null ? takenTime.hashCode() : 0);
        return result;
    }
}
