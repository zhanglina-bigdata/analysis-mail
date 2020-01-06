package com.niu.mail.mapper;

import com.niu.mail.MailApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>
 * 用户邮箱表 Mapper 接口
 * </p>
 *
 * @author zhengzz
 * @since 2020-01-05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MailApplication.class)
@Slf4j
public class MyMailServerMapperTest {
    @Autowired
    MyMailServerMapper serverMapper;

    @Test
    public void testSelect() {
       log.info( serverMapper.listMailServerInfo().toString());

    }


}
