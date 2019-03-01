package whut.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 * 店主申请
 * @author wangql
 *
 */
public class SellerRegister implements Serializable{
    private Integer registerId;  //店主申请id

    private Integer userId; //用户id

    private String remark;  //备注

    private Date submitTime;  //申请时间

    private Byte status;  //申请状态

    public Integer getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}