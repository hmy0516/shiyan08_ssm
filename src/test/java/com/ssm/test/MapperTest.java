package com.ssm.test;

import com.ssm.service.ClientInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author HMY
 * @date 2018/12/30-0:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    ClientInfoService clientInfoService;

    @Test
    public void testCrud(){
        //System.out.println(clientInfoService.findClientInfoByClientId(1));
        //System.out.println(clientInfoService.getClientInfoByPhoneAndNameAndIdCard());
    }
}
