package com.ecps.ssm.service;

import com.ecps.ssm.common.EasyUIResult;

/**
 * 用户管理service
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-14 下午 01:57
 */
public interface UserService {

    public EasyUIResult querUserList(Integer page, Integer rows);

}
