package com.ssm.mapper;

import com.ssm.pojo.ClientInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HMY
 * @date 2018/12/30-0:06
 */
public interface ClientInfoMapper {
    ClientInfo details(int clientId);
    List<ClientInfo> getAll();
    List<ClientInfo> getClientInfoByPhoneAndNameAndIdCard(ClientInfo clientInfo);
}
