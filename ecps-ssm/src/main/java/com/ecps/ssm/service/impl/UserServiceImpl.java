package com.ecps.ssm.service.impl;


import com.ecps.ssm.common.EasyUIResult;
import com.ecps.ssm.mapper.TbUserMapper;
import com.ecps.ssm.pojo.TbUser;
import com.ecps.ssm.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-14 下午 02:19
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper userMapper;

    @Override
    public EasyUIResult querUserList(Integer page, Integer rows) {

        PageHelper.startPage(page, rows);

        Example example = new Example(TbUser.class);
        List<TbUser> list = this.userMapper.selectByExample(example);

        PageInfo<TbUser> pageInfo = new PageInfo<>(list);

        return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
    }
}
