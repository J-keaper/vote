package com.keaper.vote.service;

import com.keaper.vote.common.constants.SiteConstants;
import com.keaper.vote.common.utils.DateUtils;
import com.keaper.vote.persistence.dao.ResetPasswordDao;
import com.keaper.vote.persistence.dao.UserDao;
import com.keaper.vote.persistence.po.ResetPasswordInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;


@Repository
public class ResetPasswordService {

    @Resource
    ResetPasswordDao resetPasswordDao;

    @Resource
    UserDao userDao;

    public String generateResetPasswordUrlAndRecord(String email){
        int id = userDao.selectIdByEmail(email);
        Timestamp timestamp = new Timestamp(
                DateUtils.addDay(new Date(),1).getTime());
        String token = DigestUtils.sha1Hex(UUID.randomUUID()+email+timestamp);

        if(resetPasswordDao.selectExistId(id)){
            resetPasswordDao.updateOneRecord(new ResetPasswordInfo(id,token,timestamp));
        }else{
            resetPasswordDao.insertOneRecord(new ResetPasswordInfo(id,token,timestamp));
        }
        return SiteConstants.DOMAIN+"/user/password/setNew?token="+token;
    }

    /**
     * 判断链接是否过期
     * @param token
     * @return
     */
    public boolean judgeValid(String token){
        if(!resetPasswordDao.selectExistToken(token)){
            return false;
        }
        int id = resetPasswordDao.selectIdByToken(token);
        ResetPasswordInfo resetPasswordInfo = resetPasswordDao.selectInfoById(id);
        return resetPasswordInfo.getLapseTime().after(new Timestamp(new Date().getTime()));
    }

    /**
     * 设置新密码并且删除重置密码记录，注意事务
     * @param token
     * @param password
     */
    @Transactional
    public boolean setNewPasswordAndDeleteRecord(String token,String password){
        int id = resetPasswordDao.selectIdByToken(token);
        int deleteAffectRows = resetPasswordDao.deleteOneRecord(id);
        int updateAffectRows = userDao.updatePasswordById(id,password);
        return deleteAffectRows > 0 && updateAffectRows > 0;
    }

}
