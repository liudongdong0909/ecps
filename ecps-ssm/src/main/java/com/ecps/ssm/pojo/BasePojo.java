package com.ecps.ssm.pojo;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-15 上午 09:57
 */
@ApiModel()
public class BasePojo {

    @ApiModelProperty(value="创建时间",notes="created", required=true)
    private Date created;

    @ApiModelProperty(value="更新时间",notes="updated", required=true)
    private Date updated;

    /**
     * 获取 创建时间 字段:tb_item.created
     *
     * @return tb_item.created, 创建时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 设置 创建时间 字段:tb_item.created
     *
     * @param created the value for tb_item.created, 创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 获取 更新时间 字段:tb_item.updated
     *
     * @return tb_item.updated, 更新时间
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * 设置 更新时间 字段:tb_item.updated
     *
     * @param updated the value for tb_item.updated, 更新时间
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
