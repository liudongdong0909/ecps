package com.ecps.model;

import com.ecps.model.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value="",description="数据库表：tb_order_shipping")
@Table(name = "tb_order_shipping")
public class TbOrderShipping extends BaseModel {

    @ApiModelProperty(value="订单ID",name="orderId", required=true)
    @NotEmpty
    @Id
    @Column(name = "order_id")
    private String orderId;

    @ApiModelProperty(value="收货人全名",name="receiverName")
    @Column(name = "receiver_name")
    private String receiverName;

    @ApiModelProperty(value="固定电话",name="receiverPhone")
    @Column(name = "receiver_phone")
    private String receiverPhone;

    @ApiModelProperty(value="移动电话",name="receiverMobile")
    @Column(name = "receiver_mobile")
    private String receiverMobile;

    @ApiModelProperty(value="省份",name="receiverState")
    @Column(name = "receiver_state")
    private String receiverState;

    @ApiModelProperty(value="城市",name="receiverCity")
    @Column(name = "receiver_city")
    private String receiverCity;

    @ApiModelProperty(value="区/县",name="receiverDistrict")
    @Column(name = "receiver_district")
    private String receiverDistrict;

    @ApiModelProperty(value="收货地址，如：xx路xx号",name="receiverAddress")
    @Column(name = "receiver_address")
    private String receiverAddress;

    @ApiModelProperty(value="邮政编码,如：310001",name="receiverZip")
    @Column(name = "receiver_zip")
    private String receiverZip;

    /**
     * 获取 订单ID 字段:tb_order_shipping.order_id
     *
     * @return tb_order_shipping.order_id, 订单ID
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置 订单ID 字段:tb_order_shipping.order_id
     *
     * @param orderId the value for tb_order_shipping.order_id, 订单ID
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 获取 收货人全名 字段:tb_order_shipping.receiver_name
     *
     * @return tb_order_shipping.receiver_name, 收货人全名
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * 设置 收货人全名 字段:tb_order_shipping.receiver_name
     *
     * @param receiverName the value for tb_order_shipping.receiver_name, 收货人全名
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    /**
     * 获取 固定电话 字段:tb_order_shipping.receiver_phone
     *
     * @return tb_order_shipping.receiver_phone, 固定电话
     */
    public String getReceiverPhone() {
        return receiverPhone;
    }

    /**
     * 设置 固定电话 字段:tb_order_shipping.receiver_phone
     *
     * @param receiverPhone the value for tb_order_shipping.receiver_phone, 固定电话
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone == null ? null : receiverPhone.trim();
    }

    /**
     * 获取 移动电话 字段:tb_order_shipping.receiver_mobile
     *
     * @return tb_order_shipping.receiver_mobile, 移动电话
     */
    public String getReceiverMobile() {
        return receiverMobile;
    }

    /**
     * 设置 移动电话 字段:tb_order_shipping.receiver_mobile
     *
     * @param receiverMobile the value for tb_order_shipping.receiver_mobile, 移动电话
     */
    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile == null ? null : receiverMobile.trim();
    }

    /**
     * 获取 省份 字段:tb_order_shipping.receiver_state
     *
     * @return tb_order_shipping.receiver_state, 省份
     */
    public String getReceiverState() {
        return receiverState;
    }

    /**
     * 设置 省份 字段:tb_order_shipping.receiver_state
     *
     * @param receiverState the value for tb_order_shipping.receiver_state, 省份
     */
    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState == null ? null : receiverState.trim();
    }

    /**
     * 获取 城市 字段:tb_order_shipping.receiver_city
     *
     * @return tb_order_shipping.receiver_city, 城市
     */
    public String getReceiverCity() {
        return receiverCity;
    }

    /**
     * 设置 城市 字段:tb_order_shipping.receiver_city
     *
     * @param receiverCity the value for tb_order_shipping.receiver_city, 城市
     */
    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity == null ? null : receiverCity.trim();
    }

    /**
     * 获取 区/县 字段:tb_order_shipping.receiver_district
     *
     * @return tb_order_shipping.receiver_district, 区/县
     */
    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    /**
     * 设置 区/县 字段:tb_order_shipping.receiver_district
     *
     * @param receiverDistrict the value for tb_order_shipping.receiver_district, 区/县
     */
    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict == null ? null : receiverDistrict.trim();
    }

    /**
     * 获取 收货地址，如：xx路xx号 字段:tb_order_shipping.receiver_address
     *
     * @return tb_order_shipping.receiver_address, 收货地址，如：xx路xx号
     */
    public String getReceiverAddress() {
        return receiverAddress;
    }

    /**
     * 设置 收货地址，如：xx路xx号 字段:tb_order_shipping.receiver_address
     *
     * @param receiverAddress the value for tb_order_shipping.receiver_address, 收货地址，如：xx路xx号
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress == null ? null : receiverAddress.trim();
    }

    /**
     * 获取 邮政编码,如：310001 字段:tb_order_shipping.receiver_zip
     *
     * @return tb_order_shipping.receiver_zip, 邮政编码,如：310001
     */
    public String getReceiverZip() {
        return receiverZip;
    }

    /**
     * 设置 邮政编码,如：310001 字段:tb_order_shipping.receiver_zip
     *
     * @param receiverZip the value for tb_order_shipping.receiver_zip, 邮政编码,如：310001
     */
    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip == null ? null : receiverZip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_shipping
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", receiverName=").append(receiverName);
        sb.append(", receiverPhone=").append(receiverPhone);
        sb.append(", receiverMobile=").append(receiverMobile);
        sb.append(", receiverState=").append(receiverState);
        sb.append(", receiverCity=").append(receiverCity);
        sb.append(", receiverDistrict=").append(receiverDistrict);
        sb.append(", receiverAddress=").append(receiverAddress);
        sb.append(", receiverZip=").append(receiverZip);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append("]");
        return sb.toString();
    }
}