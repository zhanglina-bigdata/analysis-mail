package com.niu.mail.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.niu.mail.entity.MyMailServer;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 常用邮件应用 Mapper 接口
 * </p>
 *
 * @author zhengzz
 * @since 2020-01-05
 */
@Repository
public interface MyMailServerMapper extends BaseMapper<MyMailServer> {
        public List<MyMailServer> listMailServerInfo();
}
