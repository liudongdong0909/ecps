package com.ecps.model.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.util.Date;

/**
 * 基础公共类
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-21 上午 11:16
 */
@ApiModel(value="baseModel",description="基础公共类")
public class BaseModel {

    @ApiModelProperty(value="创建时间",name="created", required=true)
    @Column(name = "created")
    protected Date created;

    @ApiModelProperty(value="更新时间",name="updated", required=true)
    @Column(name = "updated")
    protected Date updated;

    /**
     * 获取 创建时间 字段:tb_content_category.created
     *
     * @return tb_content_category.created, 创建时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 设置 创建时间 字段:tb_content_category.created
     *
     * @param created the value for tb_content_category.created, 创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 获取 创建时间 字段:tb_content_category.updated
     *
     * @return tb_content_category.updated, 创建时间
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * 设置 创建时间 字段:tb_content_category.updated
     *
     * @param updated the value for tb_content_category.updated, 创建时间
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "created=" + created +
                ", updated=" + updated +
                '}';
    }
}
