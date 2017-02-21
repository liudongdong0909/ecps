package com.ecps.ssm.pojo;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@ApiModel(value = "订单表", description = "数据库表：tb_order")
@Table(name = "tb_order")
public class TbOrder extends BasePojo {

    @ApiModelProperty(value = "订单id", notes = "orderId", required = true)
    @NotEmpty
    @Id
    @Column(name = "order_id")
    private String orderId;

    @ApiModelProperty(value = "实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分", notes = "payment")
    @Column(name = "payment")
    private String payment;

    @ApiModelProperty(value = "支付类型，1、在线支付，2、货到付款", notes = "paymentType")
    @Column(name = "payment_type")
    private Integer paymentType;

    @ApiModelProperty(value = "邮费。精确到2位小数;单位:元。如:200.07，表示:200元7分", notes = "postFee")
    @Column(name = "post_fee")
    private String postFee;

    @ApiModelProperty(value = "状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭", notes = "status")
    @Column(name = "status")
    private Integer status;

    @ApiModelProperty(value = "付款时间", notes = "paymentTime")
    @Column(name = "payment_time")
    private Date paymentTime;

    @ApiModelProperty(value = "发货时间", notes = "consignTime")
    @Column(name = "consign_time")
    private Date consignTime;

    @ApiModelProperty(value = "交易完成时间", notes = "endTime")
    @Column(name = "end_time")
    private Date endTime;

    @ApiModelProperty(value = "交易关闭时间", notes = "closeTime")
    @Column(name = "close_time")
    private Date closeTime;

    @ApiModelProperty(value = "物流名称", notes = "shippingName")
    @Column(name = "shipping_name")
    private String shippingName;

    @ApiModelProperty(value = "物流单号", notes = "shippingCode")
    @Column(name = "shipping_code")
    private String shippingCode;

    @ApiModelProperty(value = "用户id", notes = "userId")
    @Column(name = "user_id")
    private Long userId;

    @ApiModelProperty(value = "买家留言", notes = "buyerMessage")
    @Column(name = "buyer_message")
    private String buyerMessage;

    @ApiModelProperty(value = "买家昵称", notes = "buyerNick")
    @Column(name = "buyer_nick")
    private String buyerNick;

    @ApiModelProperty(value = "买家是否已经评价", notes = "buyerRate")
    @Column(name = "buyer_rate")
    private Integer buyerRate;

    /**
     * 获取 订单id 字段:tb_order.order_id
     *
     * @return tb_order.order_id, 订单id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置 订单id 字段:tb_order.order_id
     *
     * @param orderId the value for tb_order.order_id, 订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 获取 实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分 字段:tb_order.payment
     *
     * @return tb_order.payment, 实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分
     */
    public String getPayment() {
        return payment;
    }

    /**
     * 设置 实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分 字段:tb_order.payment
     *
     * @param payment the value for tb_order.payment, 实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分
     */
    public void setPayment(String payment) {
        this.payment = payment == null ? null : payment.trim();
    }

    /**
     * 获取 支付类型，1、在线支付，2、货到付款 字段:tb_order.payment_type
     *
     * @return tb_order.payment_type, 支付类型，1、在线支付，2、货到付款
     */
    public Integer getPaymentType() {
        return paymentType;
    }

    /**
     * 设置 支付类型，1、在线支付，2、货到付款 字段:tb_order.payment_type
     *
     * @param paymentType the value for tb_order.payment_type, 支付类型，1、在线支付，2、货到付款
     */
    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * 获取 邮费。精确到2位小数;单位:元。如:200.07，表示:200元7分 字段:tb_order.post_fee
     *
     * @return tb_order.post_fee, 邮费。精确到2位小数;单位:元。如:200.07，表示:200元7分
     */
    public String getPostFee() {
        return postFee;
    }

    /**
     * 设置 邮费。精确到2位小数;单位:元。如:200.07，表示:200元7分 字段:tb_order.post_fee
     *
     * @param postFee the value for tb_order.post_fee, 邮费。精确到2位小数;单位:元。如:200.07，表示:200元7分
     */
    public void setPostFee(String postFee) {
        this.postFee = postFee == null ? null : postFee.trim();
    }

    /**
     * 获取 状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭 字段:tb_order.status
     *
     * @return tb_order.status, 状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置 状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭 字段:tb_order.status
     *
     * @param status the value for tb_order.status, 状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取 付款时间 字段:tb_order.payment_time
     *
     * @return tb_order.payment_time, 付款时间
     */
    public Date getPaymentTime() {
        return paymentTime;
    }

    /**
     * 设置 付款时间 字段:tb_order.payment_time
     *
     * @param paymentTime the value for tb_order.payment_time, 付款时间
     */
    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    /**
     * 获取 发货时间 字段:tb_order.consign_time
     *
     * @return tb_order.consign_time, 发货时间
     */
    public Date getConsignTime() {
        return consignTime;
    }

    /**
     * 设置 发货时间 字段:tb_order.consign_time
     *
     * @param consignTime the value for tb_order.consign_time, 发货时间
     */
    public void setConsignTime(Date consignTime) {
        this.consignTime = consignTime;
    }

    /**
     * 获取 交易完成时间 字段:tb_order.end_time
     *
     * @return tb_order.end_time, 交易完成时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置 交易完成时间 字段:tb_order.end_time
     *
     * @param endTime the value for tb_order.end_time, 交易完成时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取 交易关闭时间 字段:tb_order.close_time
     *
     * @return tb_order.close_time, 交易关闭时间
     */
    public Date getCloseTime() {
        return closeTime;
    }

    /**
     * 设置 交易关闭时间 字段:tb_order.close_time
     *
     * @param closeTime the value for tb_order.close_time, 交易关闭时间
     */
    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    /**
     * 获取 物流名称 字段:tb_order.shipping_name
     *
     * @return tb_order.shipping_name, 物流名称
     */
    public String getShippingName() {
        return shippingName;
    }

    /**
     * 设置 物流名称 字段:tb_order.shipping_name
     *
     * @param shippingName the value for tb_order.shipping_name, 物流名称
     */
    public void setShippingName(String shippingName) {
        this.shippingName = shippingName == null ? null : shippingName.trim();
    }

    /**
     * 获取 物流单号 字段:tb_order.shipping_code
     *
     * @return tb_order.shipping_code, 物流单号
     */
    public String getShippingCode() {
        return shippingCode;
    }

    /**
     * 设置 物流单号 字段:tb_order.shipping_code
     *
     * @param shippingCode the value for tb_order.shipping_code, 物流单号
     */
    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode == null ? null : shippingCode.trim();
    }

    /**
     * 获取 用户id 字段:tb_order.user_id
     *
     * @return tb_order.user_id, 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置 用户id 字段:tb_order.user_id
     *
     * @param userId the value for tb_order.user_id, 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 买家留言 字段:tb_order.buyer_message
     *
     * @return tb_order.buyer_message, 买家留言
     */
    public String getBuyerMessage() {
        return buyerMessage;
    }

    /**
     * 设置 买家留言 字段:tb_order.buyer_message
     *
     * @param buyerMessage the value for tb_order.buyer_message, 买家留言
     */
    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage == null ? null : buyerMessage.trim();
    }

    /**
     * 获取 买家昵称 字段:tb_order.buyer_nick
     *
     * @return tb_order.buyer_nick, 买家昵称
     */
    public String getBuyerNick() {
        return buyerNick;
    }

    /**
     * 设置 买家昵称 字段:tb_order.buyer_nick
     *
     * @param buyerNick the value for tb_order.buyer_nick, 买家昵称
     */
    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick == null ? null : buyerNick.trim();
    }

    /**
     * 获取 买家是否已经评价 字段:tb_order.buyer_rate
     *
     * @return tb_order.buyer_rate, 买家是否已经评价
     */
    public Integer getBuyerRate() {
        return buyerRate;
    }

    /**
     * 设置 买家是否已经评价 字段:tb_order.buyer_rate
     *
     * @param buyerRate the value for tb_order.buyer_rate, 买家是否已经评价
     */
    public void setBuyerRate(Integer buyerRate) {
        this.buyerRate = buyerRate;
    }
}