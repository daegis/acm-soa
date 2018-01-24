package cn.aegisa.acm.model;

import java.io.Serializable;


/**
 * Activities Entity.
 */
public class Activities implements Serializable {

    //列信息
    private Integer aid;

    private String activityBus;

    private java.util.Date activityDate;

    private String activityName;

    private Integer activityPrice;

    private String dayCount;

    private java.util.Date endDate;

    private String inUse;


    public void setAid(Integer value) {
        this.aid = value;
    }

    public Integer getAid() {
        return this.aid;
    }


    public void setActivityBus(String value) {
        this.activityBus = value;
    }

    public String getActivityBus() {
        return this.activityBus;
    }


    public void setActivityDate(java.util.Date value) {
        this.activityDate = value;
    }

    public java.util.Date getActivityDate() {
        return this.activityDate;
    }


    public void setActivityName(String value) {
        this.activityName = value;
    }

    public String getActivityName() {
        return this.activityName;
    }


    public void setActivityPrice(Integer value) {
        this.activityPrice = value;
    }

    public Integer getActivityPrice() {
        return this.activityPrice;
    }


    public void setDayCount(String value) {
        this.dayCount = value;
    }

    public String getDayCount() {
        return this.dayCount;
    }


    public void setEndDate(java.util.Date value) {
        this.endDate = value;
    }

    public java.util.Date getEndDate() {
        return this.endDate;
    }


    public void setInUse(String value) {
        this.inUse = value;
    }

    public String getInUse() {
        return this.inUse;
    }

}

