package com.ssm.mapper;

import com.ssm.pojo.BankCardInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author HMY
 * @date 2019/1/3-16:52
 */
public interface AccountMapper {
    /**
     *  转账.
     */
    void out(@Param("cardNumber") String outAccount, @Param("money") double money);

    /**
     *  入账
     */
    void in(@Param("cardNumber") String inAccount, @Param("money") double money);

    BankCardInfo checkAccount(Long cardNumber);
    Double checkMoney(Long cardNumber);
}
