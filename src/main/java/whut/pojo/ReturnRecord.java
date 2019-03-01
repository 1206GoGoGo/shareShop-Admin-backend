package whut.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 退货/款记录
 * @author wangql
 *
 */
public class ReturnRecord implements Serializable{
    private Integer returnId; //退货id

    private Integer userId; // 用户id

    private Integer orderDetailId; // 订单详情id

    private Integer productId; // 商品id

    private Byte returnType; // 0:退货   1:退款

    private BigDecimal returnMoney; //退款金额

    private Date createTime;  //申请时间

    private Byte status;  //退货状态

    private String reason;  //退货原因

    public Integer getReturnId() {
        return returnId;
    }

    public void setReturnId(Integer returnId) {
        this.returnId = returnId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Byte getReturnType() {
        return returnType;
    }

    public void setReturnType(Byte returnType) {
        this.returnType = returnType;
    }

    public BigDecimal getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(BigDecimal returnMoney) {
        this.returnMoney = returnMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}