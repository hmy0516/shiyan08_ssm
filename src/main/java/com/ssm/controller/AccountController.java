package com.ssm.controller;

import com.ssm.pojo.BankCardInfo;
import com.ssm.pojo.Transfer;
import com.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HMY
 * @date 2019/1/3-16:59
 */
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/toTransfer")
    public String toTransfer(HttpServletRequest request,String outAccount,int clientId){
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("clientId",clientId);
        map.put("outAccount",outAccount);
        request.getSession().setAttribute("map",map);
        return "transfer";
    }

    //转账，并接收页面请求的JSON数据,返回JSON格式结果
    @RequestMapping("/transfer")
    @ResponseBody
    public String transfer(@RequestBody Transfer transfer,
                           HttpServletRequest request){
        Map map = (Map) request.getSession().getAttribute("map");
        String outAccount = (String) map.get("outAccount");
        // 调用业务层 , 完成转账功能.
        accountService.transfer(outAccount, transfer.getInAccount() , transfer.getBalance());
        return "redirect:ClientInfo";
    }

    @RequestMapping(value = "/checkAccount",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String checkAccount(Long cardNumber){
        boolean b = accountService.checkAccount(cardNumber);
        if(b){
            return "√";
        }else{
            return "×";
        }
    }
    @RequestMapping(value = "/checkBalance",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String checkBalance(BankCardInfo bankCardInfo){
        boolean b = accountService.checkMoney(bankCardInfo);
        if(b){
            return "√";
        }else{
            return "×";
        }
    }
}
