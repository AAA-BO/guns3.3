package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangbo123
 * @since 2019-04-21
 */
@TableName("house_manager")
public class HouseManager extends Model<HouseManager> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "uuid", type = IdType.AUTO)
    private Integer uuid;
    /**
     * 房屋业主名称
     */
    @TableField("house_user")
    private String houseUser;
    /**
     * 房屋面积
     */
    @TableField("house_area")
    private Double houseArea;
    /**
     * 房屋地址
     */
    @TableField("house_address")
    private String houseAddress;
    /**
     * 房屋交付日期
     */
    @TableField("house_time")
    private Date houseTime;
    /**
     * 是否有贷款(0-无,1-有)
     */
    @TableField("house_loan")
    private byte[] houseLoan;
    /**
     * 房屋描述信息
     */
    @TableField("house_desc")
    private String houseDesc;


    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getHouseUser() {
        return houseUser;
    }

    public void setHouseUser(String houseUser) {
        this.houseUser = houseUser;
    }

    public Double getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(Double houseArea) {
        this.houseArea = houseArea;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public Date getHouseTime() {
        return houseTime;
    }

    public void setHouseTime(Date houseTime) {
        this.houseTime = houseTime;
    }

    public byte[] getHouseLoan() {
        return houseLoan;
    }

    public void setHouseLoan(byte[] houseLoan) {
        this.houseLoan = houseLoan;
    }

    public String getHouseDesc() {
        return houseDesc;
    }

    public void setHouseDesc(String houseDesc) {
        this.houseDesc = houseDesc;
    }

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }

    @Override
    public String toString() {
        return "HouseManager{" +
        "uuid=" + uuid +
        ", houseUser=" + houseUser +
        ", houseArea=" + houseArea +
        ", houseAddress=" + houseAddress +
        ", houseTime=" + houseTime +
        ", houseLoan=" + houseLoan +
        ", houseDesc=" + houseDesc +
        "}";
    }
}
