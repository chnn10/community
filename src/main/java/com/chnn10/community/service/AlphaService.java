package com.chnn10.community.service;

import com.chnn10.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.AbstractList;

@Service
public class AlphaService {

    @Autowired
    private AlphaDao alphaDao;

    public String find(){
        return alphaDao.select();
    }
}
