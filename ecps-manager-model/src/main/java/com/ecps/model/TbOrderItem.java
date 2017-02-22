package com.ecps.model;

import com.ecps.model.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value="订单详情表",description="数据库表：tb_order_item")
@Table(name = "tb_order_item")
public class TbOrderItem extends BaseModel {

    @ApiModelProperty(value="",name="id", required=true)
    @NotEmpty
    @Id
    @Column(name = "id")
    private String id;

    @ApiModelProperty(value="商品id",name="itemId", required=true)
    @NotEmpty
    @Column(name = "item_id")
    private String itemId;

    @ApiModelProperty(value="订单id",name="orderId", required=true)
    @NotEmpty
    @Column(name = "order_id")
    private String orderId;

    @ApiModelProperty(value="商品购买数量",name="num")
    @Column(name = "num")
    private Integer num;

    @ApiModelProperty(value="商品标题",name="title")
    @Column(name = "title")
    private String title;

    @ApiModelProperty(value="商品单价",name="price")
    @Column(name = "price")
    private Long price;

    @ApiModelProperty(value="商品总金额",name="totalFee")
    @Column(name = "total_fee")
    private Long totalFee;

    @ApiModelProperty(value="商品图片地址",name="picPath")
    @Column(name = "pic_path")
    private String picPath;

    /**
     * 获取  字段:tb_order_item.id
     *
     * @return tb_order_item.id, 
     */
    public String getId() {
        return id;
    }

    /**
     * 设置  字段:tb_order_item.id
     *
     * @param id the value for tb_order_item.id, 
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 商品id 字段:tb_order_item.item_id
     *
     * @return tb_order_item.item_id, 商品id
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * 设置 商品id 字段:tb_order_item.item_id
     *
     * @param itemId the value for tb_order_item.item_id, 商品id
     */
    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    /**
     * 获取 订单id 字段:tb_order_item.order_id
     *
     * @return tb_order_item.order_id, 订单id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置 订单id 字段:tb_order_item.order_id
     *
     * @param orderId the value for tb_order_item.order_id, 订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 获取 商品购买数量 字段:tb_order_item.num
     *
     * @return tb_order_item.num, 商品购买数量
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置 商品购买数量 字段:tb_order_item.num
     *
     * @param num the value for tb_order_item.num, 商品购买数量
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 获取 商品标题 字段:tb_order_item.title
     *
     * @return tb_order_item.title, 商品标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置 商品标题 字段:tb_order_item.title
     *
     * @param title the value for tb_order_item.title, 商品标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取 商品单价 字段:tb_order_item.price
     *
     * @return tb_order_item.price, 商品单价
     */
    public Long getPrice() {
        return price;
    }

    /**
     * 设置 商品单价 字段:tb_order_item.price
     *
     * @param price the value for tb_order_item.price, 商品单价
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * 获取 商品总金额 字段:tb_order_item.total_fee
     *
     * @return tb_order_item.total_fee, 商品总金额
     */
    public Long getTotalFee() {
        return totalFee;
    }

    /**
     * 设置 商品总金额 字段:tb_order_item.total_fee
     *
     * @param totalFee the value for tb_order_item.total_fee, 商品总金额
     */
    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * 获取 商品图片地址 字段:tb_order_item.pic_path
     *
     * @return tb_order_item.pic_path, 商品图片地址
     */
    public String getPicPath() {
        return picPath;
    }

    /**
     * 设置 商品图片地址 字段:tb_order_item.pic_path
     *
     * @param picPath the value for tb_order_item.pic_path, 商品图片地址
     */
    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_item
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", itemId=").append(itemId);
        sb.append(", orderId=").append(orderId);
        sb.append(", num=").append(num);
        sb.append(", title=").append(title);
        sb.append(", price=").append(price);
        sb.append(", totalFee=").append(totalFee);
        sb.append(", picPath=").append(picPath);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append("]");
        return sb.toString();
    }
}