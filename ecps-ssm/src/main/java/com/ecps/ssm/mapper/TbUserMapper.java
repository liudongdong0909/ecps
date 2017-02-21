package com.ecps.ssm.mapper;

import com.ecps.ssm.pojo.TbUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * 用户管理mapper
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-14 下午 01:48
 */
@Repository
public interface TbUserMapper extends Mapper<TbUser> {

}
