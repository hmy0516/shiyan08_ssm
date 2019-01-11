package com.ssm.test;

import com.github.pagehelper.PageInfo;
import com.ssm.pojo.ClientInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * @author HMY
 * @date 2019/1/2-17:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:springmvc.xml"})
public class MvcTest {
    //传入Springmvc的IOC
    @Autowired
    WebApplicationContext context;
    //虚拟mvc请求 获取处理结果
    MockMvc mockMvc;

    @Before
    public void initMokcMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testPage() throws Exception {
            //模拟请求拿到返回值
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/ClientInfo")
                    .param("pn", "1")).andReturn();
            //请求成功以后 请求域总会有pageInfo
            MockHttpServletRequest request = result.getRequest();
            PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
            System.out.println("当前页码"+pageInfo.getPageNum());
            System.out.println("总页码"+pageInfo.getPages());
            System.out.println("总记录数"+pageInfo.getTotal());
            int [] nums = pageInfo.getNavigatepageNums();
            for (int i : nums){
                System.out.println(" " + i);
            }

            //获取员工数据
            List<ClientInfo> list = pageInfo.getList();
            for (ClientInfo clientInfo : list){
                System.out.println(clientInfo);
            }
    }

    @Test
    public void testGetClientInfoByPhoneAndNameAndIdCard() throws Exception {
        //模拟请求拿到返回值
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/ClientInfo")
                .param("pn", "1").param("phone", "1236362541").param("name","王春亦").param("idCard","325632233636321447")).andReturn();
        //请求成功以后 请求域总会有pageInfo
        MockHttpServletRequest request = result.getRequest();
        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
        //获取员工数据
        List<ClientInfo> list = pageInfo.getList();
        for (ClientInfo clientInfo : list){
            System.out.println(clientInfo.getName());
        }
    }


}
