package com.niu.mail.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niu.mail.entity.MyMailServer;
import com.niu.mail.mapper.MyMailServerMapper;
import com.niu.mail.service.IMyMailServerService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 常用邮件应用 服务实现类
 * </p>
 *
 * @author zhengzz
 * @since 2020-01-05
 */
@Service
public class MyMailServerServiceImpl extends ServiceImpl<MyMailServerMapper, MyMailServer> implements IMyMailServerService {

}
