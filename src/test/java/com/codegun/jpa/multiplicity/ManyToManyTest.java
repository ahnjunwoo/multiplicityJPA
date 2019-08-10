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
 * @desc 다대다연습
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ManyToManyTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void 맴버상품추가() {
        List<Member> members = Arrays.asList(Member.builder().id("cutesboy").build(),
                Member.builder().id("tools").build(),
                Member.builder().id("testid").build(),
                Member.builder().id("boy").build()
        );
        memberRepository.saveAll(members);
        List<Product> products = Arrays.asList(Product.builder().name("에어팟").build()
                ,Product.builder().name("아이폰").build()
                ,Product.builder().name("갤럭시").build()
                ,Product.builder().name("피존").build()
                ,Product.builder().name("오메가3").build()
                        );
        productRepository.saveAll(products);
    }

    @Test
    public void 맴버_상품연관관계맵핑() {
        Member member = memberRepository.findById("cutesboy");
        List<Product> product = productRepository.findAll();
        member.setProduct(product);
        memberRepository.save(member);
    }

    @Test
    @Transactional
    public void 맴버_상품조회() {
        Member member = memberRepository.findById("cutesboy");
        member.getProduct().stream().forEach(product -> log.info("상품이름 : {}",product.getName()));
    }

}