package com.ecps.ssm.mapper;

import com.ecps.ssm.pojo.TbUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-14 下午 04:31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-dao.xml",
        "classpath:spring/applicationContext-trans.xml",
        "classpath:spring/applicationContext-service.xml"})
public class TbUserMapperTest {

    @Autowired
    private  TbUserMapper userMapper;

    @Test
    public void testInserUser(){
        TbUser user = new TbUser();
        user.setUsername("林青霞");
        user.setPassword("343434");
        user.setUpdated(new Date());
        user.setCreated(new Date());

        userMapper.insert(user);
        System.out.println(user.getId());

    }

    @Test
    public  void testSelectPage(){
        PageHelper.startPage(1,10);
        TbUser user = new TbUser();

        List<TbUser> list = userMapper.select(user);
        PageInfo<TbUser> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo.getTotal());
        System.out.println(pageInfo.getList());


    }

}