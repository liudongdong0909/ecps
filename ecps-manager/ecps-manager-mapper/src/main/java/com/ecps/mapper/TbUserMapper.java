package com.ecps.mapper;

import com.ecps.model.TbUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface TbUserMapper extends Mapper<TbUser> {
}