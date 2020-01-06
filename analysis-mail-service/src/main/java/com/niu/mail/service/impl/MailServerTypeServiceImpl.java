package com.niu.mail.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niu.mail.entity.MailServerType;
import com.niu.mail.mapper.MailServerTypeMapper;
import com.niu.mail.service.IMailServerTypeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 邮箱服务器类型表 服务实现类
 * </p>
 *
 * @author zhengzz
 * @since 2020-01-06
 */
@Service
public class MailServerTypeServiceImpl extends ServiceImpl<MailServerTypeMapper, MailServerType> implements IMailServerTypeService {

}
