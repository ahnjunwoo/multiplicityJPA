package com.codegun.jpa.multiplicity;

import com.codegun.jpa.multiplicity.entity.*;
import com.codegun.jpa.multiplicity.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author codegun
 * @desc 일대일 연습
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BlogRepository blogRepository;
    @Test
    public void 유저_블로그_추가_특정유저블로그맵핑() {
        List<User> users = Arrays.asList(
                User.builder().id("cutesboy").build(),User.builder().id("tools").build());
        List<Blog> blogs = Arrays.asList(Blog.builder().name("구름동산").build(), Blog.builder().name("자바지기").build(), Blog.builder().name("OKKY").build());
        userRepository.saveAll(users);
        blogRepository.saveAll(blogs);

        User findUser = userRepository.findById("cutesboy");
        Blog findBlog = blogRepository.findByName("구름동산");
        findUser.setBlog(findBlog);
        userRepository.save(findUser);
    }

    @Test
    public void 블로그조회() {
        User findUser = userRepository.findById("cutesboy");
        log.info("블로그이름: {}",findUser.getBlog().getName());
    }
}