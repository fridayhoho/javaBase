package com.test.mybatis.dao;

import com.test.mybatis.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;


@Slf4j
public class UserDAOImplTest {
    private ApplicationContext applicationContext;
    @Before
    public void setup() throws Exception {
        applicationContext = new
                ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void findUserById() {
        try {
            UserDAO userDAO = (UserDAO)applicationContext.getBean("userDAO");
            User user = userDAO.findUserById(12);
            assertTrue(user.getRegion_id() == 12);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}