package com.ecps.model;

import com.ecps.model.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value="商品描述表",description="数据库表：tb_item_desc")
@Table(name = "tb_item_desc")
public class TbItemDesc extends BaseModel {

    @ApiModelProperty(value="商品ID",name="itemId", required=true)
    @NotEmpty
    @Id
    @Column(name = "item_id")
    private Long itemId;

    @ApiModelProperty(value="商品描述",name="itemDesc")
    @Column(name = "item_desc")
    private String itemDesc;

    /**
     * 获取 商品ID 字段:tb_item_desc.item_id
     *
     * @return tb_item_desc.item_id, 商品ID
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * 设置 商品ID 字段:tb_item_desc.item_id
     *
     * @param itemId the value for tb_item_desc.item_id, 商品ID
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取 商品描述 字段:tb_item_desc.item_desc
     *
     * @return tb_item_desc.item_desc, 商品描述
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * 设置 商品描述 字段:tb_item_desc.item_desc
     *
     * @param itemDesc the value for tb_item_desc.item_desc, 商品描述
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", itemId=").append(itemId);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append(", itemDesc=").append(itemDesc);
        sb.append("]");
        return sb.toString();
    }
}