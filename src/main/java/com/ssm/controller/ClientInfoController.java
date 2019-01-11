package com.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.pojo.ClientInfo;
import com.ssm.pojo.Msg;
import com.ssm.service.ClientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author HMY
 * @date 2019/1/2-16:50
 */
@Controller
public class ClientInfoController {
    @Autowired
    ClientInfoService clientInfoService;
    /**
     * 查询员工数据分页查询
     * @return
     */
    @RequestMapping("/ClientInfo")
    public String getClientInfo(@RequestParam(value = "pn",defaultValue = "1") int pn, HttpServletRequest request){
        List<ClientInfo> clientInfoList;
        //引入PageHelper分页插件
        //在查询之前只需要调用 传入的当前页码 和每页大小
        PageHelper.startPage(pn,2);
        clientInfoList = clientInfoService.getAll();
        //使用PageInfo包装查询后的结果，只需要将page交给界面就行了
        //封装了详细的分页信息 及查询出的数据
        request.removeAttribute("pageInfo");
        PageInfo page = new PageInfo(clientInfoList);
        request.setAttribute("pageInfo",page);
        return "list";
    }

    //@RequestMapping("/ClientInfo")
    @ResponseBody
    public Msg getClientInfo(@RequestParam(value = "pn",defaultValue = "1") int pn){
        //引入PageHelper分页插件
        //在查询之前只需要调用 传入的当前页码 和每页大小
        PageHelper.startPage(pn,2);
        //startPage后面紧跟的这个查询是 一个分页的查询
        List<ClientInfo> clientInfoList = clientInfoService.getAll();
        //使用PageInfo包装查询后的结果，只需要将page交给界面就行了
        //封装了详细的分页信息 及查询出的数据
        PageInfo page = new PageInfo(clientInfoList);
        return Msg.success().add("pageInfo", page);
    }

    @RequestMapping(value = "/searchByPNI")
    public String getClientInfoByPhoneAndNameAndIdCard(@RequestParam(value = "pn",defaultValue = "1") int pn, HttpServletRequest request,ClientInfo clientInfo){
        PageHelper.startPage(pn,2);
        List<ClientInfo> list = clientInfoService.getClientInfoByPhoneAndNameAndIdCard(clientInfo);
        PageInfo pageInfo = new PageInfo(list);
        request.removeAttribute("pageInfo");
        request.setAttribute("pageInfo",pageInfo);
        return "list";
    }

    @RequestMapping("/Details")
    public String details(HttpServletRequest request,int id){
        System.out.println(id);
        ClientInfo clientInfo = clientInfoService.details(id);
        request.setAttribute("clientInfo",clientInfo);
        return "details";
    }
}
