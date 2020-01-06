package com.niu.mail.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niu.mail.entity.MyMailUser;
import com.niu.mail.mapper.MyMailUserMapper;
import com.niu.mail.service.IMyMailUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户邮箱表 服务实现类
 * </p>
 *
 * @author zhengzz
 * @since 2020-01-05
 */
@Service
public class MyMailUserServiceImpl extends ServiceImpl<MyMailUserMapper, MyMailUser> implements IMyMailUserService {

}
