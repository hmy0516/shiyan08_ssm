package com.ssm.service;

import com.ssm.mapper.ClientInfoMapper;
import com.ssm.pojo.BankCardInfo;
import com.ssm.pojo.ClientInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author HMY
 * @date 2018/12/30-0:22
 */
@Service
public class ClientInfoService {
    @Autowired
    private ClientInfoMapper clientInfoMapper;

    public ClientInfo details(int clientId){
        ClientInfo clientInfo = clientInfoMapper.details(clientId);
        Date cardDate = clientInfo.getBankCardInfo().get(0).getCardDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //clientInfo.getBankCardInfo().get(0).setCardDate();
        return clientInfo;
    }

    public List<ClientInfo> getAll() {
        return clientInfoMapper.getAll();
    }

    /**
     * 根据手机号 姓名 身份证号组合查询客户
     * @return
     */
    public List<ClientInfo> getClientInfoByPhoneAndNameAndIdCard(ClientInfo clientInfo){
        return clientInfoMapper.getClientInfoByPhoneAndNameAndIdCard(clientInfo);
    }
}
