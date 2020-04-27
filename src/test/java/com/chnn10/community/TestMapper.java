package com.chnn10.community;

import com.chnn10.community.dao.DiscussPostMapper;
import com.chnn10.community.dao.UserMapper;
import com.chnn10.community.entity.DiscussPost;
import com.chnn10.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class TestMapper {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelect(){
        User user = userMapper.selectById(101);
        System.out.println(user);
        User user1 = userMapper.selectByName("aaa");
        System.out.println(user1);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setUsername("陈一");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("chnn10@sina.cn");
        user.setHeaderUrl("http://images.nowcoder.com/head/1001.png");
        user.setCreateTime(new Date());

        int row = userMapper.insertUser(user);
        System.out.println(row);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdate(){
        int row = userMapper.updatePassword(150,"cba");
        System.out.println(row);
    }

    @Test
    public void testSelectPost(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0,0,10);
        for (DiscussPost discussPost : list){
            System.out.println(discussPost);
        }

        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);
    }
}
