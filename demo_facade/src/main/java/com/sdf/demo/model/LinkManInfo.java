package com.sdf.demo.model;

import java.io.Serializable;

/**
 * @ClassName LinkManInfo
 * @Description: TODO
 * @Author ShuDingfeng
 * @createDate 2020-06-05-19:21
 * @Version 1.0
 **/

public class LinkManInfo implements Serializable {

    private static final long serialVersionUID = 7076401106340167786L;

    /** 姓名 */
    private String linkManName;

    /** 性别 */
    private Integer linkManSex;

    /** 单位名称 */
    private String linkManCompanyName;

    /** 职称 */
    private String linkManJobTitles;

    /** 单位地址 */
    private String linkManOfficeAddress;

    /** 电话 */
    private String linkManMobile;

    /** 办公电话 */
    private String linkManOfficePhone;

    /** 电子邮箱 */
    private String linkManEmail;

    /** QQ */
    private String linkManQQ;

    /** 备注 */
    private String linkManRemark;

    public String getLinkManName() {
        return linkManName;
    }

    public void setLinkManName(String linkManName) {
        this.linkManName = linkManName;
    }

    public Integer getLinkManSex() {
        return linkManSex;
    }

    public void setLinkManSex(Integer linkManSex) {
        this.linkManSex = linkManSex;
    }

    public String getLinkManCompanyName() {
        return linkManCompanyName;
    }

    public void setLinkManCompanyName(String linkManCompanyName) {
        this.linkManCompanyName = linkManCompanyName;
    }

    public String getLinkManJobTitles() {
        return linkManJobTitles;
    }

    public void setLinkManJobTitles(String linkManJobTitles) {
        this.linkManJobTitles = linkManJobTitles;
    }

    public String getLinkManOfficeAddress() {
        return linkManOfficeAddress;
    }

    public void setLinkManOfficeAddress(String linkManOfficeAddress) {
        this.linkManOfficeAddress = linkManOfficeAddress;
    }

    public String getLinkManMobile() {
        return linkManMobile;
    }

    public void setLinkManMobile(String linkManMobile) {
        this.linkManMobile = linkManMobile;
    }

    public String getLinkManOfficePhone() {
        return linkManOfficePhone;
    }

    public void setLinkManOfficePhone(String linkManOfficePhone) {
        this.linkManOfficePhone = linkManOfficePhone;
    }

    public String getLinkManEmail() {
        return linkManEmail;
    }

    public void setLinkManEmail(String linkManEmail) {
        this.linkManEmail = linkManEmail;
    }

    public String getLinkManQQ() {
        return linkManQQ;
    }

    public void setLinkManQQ(String linkManQQ) {
        this.linkManQQ = linkManQQ;
    }

    public String getLinkManRemark() {
        return linkManRemark;
    }

    public void setLinkManRemark(String linkManRemark) {
        this.linkManRemark = linkManRemark;
    }
}
