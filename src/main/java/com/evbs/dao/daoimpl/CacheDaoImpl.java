package com.evbs.dao.daoimpl;

import com.evbs.dao.CacheDao;
import com.evbs.dao.UserDao;
import com.evbs.dao.ViDao;
import com.evbs.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by squirrel-chen on 6/19/17.
 */
@Component
public class CacheDaoImpl implements CacheDao {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ViDao viDao;

    @Override
    public void setUser(User user) {
        userDao.setUser(user);
    }

    @Override
    public User getUser(int userid) {
        return userDao.getUser(userid);
    }

    @Override
    public void testRedis() {
        userDao.testRedis();
    }

//    @Override
//    public boolean viCache(String vidata) {
//        return viDao.ViCache(vidata);
//    }
//
//    @Override
//    public boolean viCacheGet(){
//        return viDao.ViCacheGet();
//    }
}
