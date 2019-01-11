package com.ssm.service;

import com.ssm.mapper.AccountMapper;
import com.ssm.pojo.BankCardInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author HMY
 * @date 2019/1/3-16:53
 */
@Service
public class AccountService{
    @Autowired
    private AccountMapper accountMapper;

    /**
     *  当前方法进行事务增强.
     */
    @Transactional
    public void transfer(String outAccount, String inAccount, double money) {
        // 执行一组sql语句.
        try {
            accountMapper.out(outAccount , money);
            //int i = 1/ 0 ;
            accountMapper.in(inAccount , money);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkAccount(Long cardNumber){
        BankCardInfo bankCardInfo = accountMapper.checkAccount(cardNumber);
        if (bankCardInfo!=null){
            return true;
        }else {
            return false;
        }

    }
    public boolean checkMoney(BankCardInfo bankCardInfo){
        Double balance = accountMapper.checkMoney(bankCardInfo.getCardNumber());
        if (balance>=bankCardInfo.getBalance()){
            return true;
        }else {
            return false;
        }

    }
}
