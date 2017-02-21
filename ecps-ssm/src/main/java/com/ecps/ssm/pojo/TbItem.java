package com.ecps.ssm.pojo;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value="商品表",description="数据库表：tb_item")
@Table(name = "tb_item")
public class TbItem extends  BasePojo{

    @ApiModelProperty(value="商品id，同时也是商品编号",notes="id", required=true)
    @Id
    private Long id;

    @ApiModelProperty(value="商品标题",notes="title", required=true)
    private String title;

    @ApiModelProperty(value="商品卖点",notes="sellPoint")
    private String sellPoint;

    @ApiModelProperty(value="商品价格，单位为：分",notes="price", required=true)
    private Long price;

    @ApiModelProperty(value="库存数量",notes="num", required=true)
    private Integer num;

    @ApiModelProperty(value="商品条形码",notes="barcode")
    private String barcode;

    @ApiModelProperty(value="商品图片",notes="image")
    private String image;

    @ApiModelProperty(value="所属类目，叶子类目",notes="cid", required=true)
    private Long cid;

    @ApiModelProperty(value="商品状态，1-正常，2-下架，3-删除",notes="status", required=true)
    private Byte status;

    /**
     * 获取 商品id，同时也是商品编号 字段:tb_item.id
     *
     * @return tb_item.id, 商品id，同时也是商品编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 商品id，同时也是商品编号 字段:tb_item.id
     *
     * @param id the value for tb_item.id, 商品id，同时也是商品编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 商品标题 字段:tb_item.title
     *
     * @return tb_item.title, 商品标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置 商品标题 字段:tb_item.title
     *
     * @param title the value for tb_item.title, 商品标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取 商品卖点 字段:tb_item.sell_point
     *
     * @return tb_item.sell_point, 商品卖点
     */
    public String getSellPoint() {
        return sellPoint;
    }

    /**
     * 设置 商品卖点 字段:tb_item.sell_point
     *
     * @param sellPoint the value for tb_item.sell_point, 商品卖点
     */
    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint == null ? null : sellPoint.trim();
    }

    /**
     * 获取 商品价格，单位为：分 字段:tb_item.price
     *
     * @return tb_item.price, 商品价格，单位为：分
     */
    public Long getPrice() {
        return price;
    }

    /**
     * 设置 商品价格，单位为：分 字段:tb_item.price
     *
     * @param price the value for tb_item.price, 商品价格，单位为：分
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * 获取 库存数量 字段:tb_item.num
     *
     * @return tb_item.num, 库存数量
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置 库存数量 字段:tb_item.num
     *
     * @param num the value for tb_item.num, 库存数量
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 获取 商品条形码 字段:tb_item.barcode
     *
     * @return tb_item.barcode, 商品条形码
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * 设置 商品条形码 字段:tb_item.barcode
     *
     * @param barcode the value for tb_item.barcode, 商品条形码
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    /**
     * 获取 商品图片 字段:tb_item.image
     *
     * @return tb_item.image, 商品图片
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置 商品图片 字段:tb_item.image
     *
     * @param image the value for tb_item.image, 商品图片
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * 获取 所属类目，叶子类目 字段:tb_item.cid
     *
     * @return tb_item.cid, 所属类目，叶子类目
     */
    public Long getCid() {
        return cid;
    }

    /**
     * 设置 所属类目，叶子类目 字段:tb_item.cid
     *
     * @param cid the value for tb_item.cid, 所属类目，叶子类目
     */
    public void setCid(Long cid) {
        this.cid = cid;
    }

    /**
     * 获取 商品状态，1-正常，2-下架，3-删除 字段:tb_item.status
     *
     * @return tb_item.status, 商品状态，1-正常，2-下架，3-删除
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置 商品状态，1-正常，2-下架，3-删除 字段:tb_item.status
     *
     * @param status the value for tb_item.status, 商品状态，1-正常，2-下架，3-删除
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TbItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sellPoint='" + sellPoint + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", barcode='" + barcode + '\'' +
                ", image='" + image + '\'' +
                ", cid=" + cid +
                ", status=" + status +
                '}';
    }
}