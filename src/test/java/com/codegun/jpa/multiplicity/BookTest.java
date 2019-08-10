package com.codegun.jpa.multiplicity;

import com.codegun.jpa.multiplicity.entity.Book;
import com.codegun.jpa.multiplicity.entity.Book2;
import com.codegun.jpa.multiplicity.entity.Category;
import com.codegun.jpa.multiplicity.entity.Category2;
import com.codegun.jpa.multiplicity.repository.Book2Repository;
import com.codegun.jpa.multiplicity.repository.BookRepository;
import com.codegun.jpa.multiplicity.repository.Category2Repository;
import com.codegun.jpa.multiplicity.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
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
 * @desc 일대다 연습
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BookTest {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private Book2Repository book2Repository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private Category2Repository category2Repository;
    @Test
    public void 북추가() {
        Optional<Category> category = categoryRepository.findById(1);
        Book book = Book.builder()
                .title("자바 람다 배우기")
                .category(category.get())
                .build();
        bookRepository.save(book);
    }

    @Test
    public void 카테고리_추가() {
        List<Category> categorys = Arrays.asList(Category.builder().name("자바").build(),
                Category.builder().name("c++").build(),
                Category.builder().name("파이썬").build(),
                Category.builder().name("스칼라").build()
        );
        categoryRepository.saveAll(categorys);
    }

    @Test
    public void 카테고리2_추가() {
        List<Category2> category2s = Arrays.asList(Category2.builder().name("애니메이션").build(),
                Category2.builder().name("IT").build(),
                Category2.builder().name("영문학").build(),
                Category2.builder().name("여행").build()
        );

        category2Repository.saveAll(category2s);
    }

    @Test
    public void 북조회시_카테고리정보가져오기() {
       Optional<Book> book = bookRepository.findById(1);
        book.ifPresent(book1 -> {
            log.info("book 번호 : {}",book1.getNo());
            log.info("book 제목 : {}",book1.getTitle());
            Category category = book1.getCategory();
            log.info("category 번호 : {}",category.getNo());
            log.info("category 이름 : {}",category.getName());
        });
    }
    @Test
    public void 카테고리2와_북연관관계_추가() {
        Category2 category2 = category2Repository.findByName("IT");
        List<Book2> books = Arrays.asList(Book2.builder().title("스프링클라우드").category2(category2).build(),
                Book2.builder().title("아두이노 개발서적").category2(category2).build(),
                Book2.builder().title("파이썬 기초 가이드").category2(category2).build(),
                Book2.builder().title("자바10 쉽게배우기").category2(category2).build()
        );
        book2Repository.saveAll(books);
    }
    //카테고리2와_북연관관계_추가 후 양방향 설정한 카테고리2엔티디로 북 정보조회
    @Test
    //Category2 객체에서 book2 엔티티를 조회시 LazyInitializationException 발생 @Transactional 같은 영속성 컨텍스트를 지정하여 북2 엔티티가져올수있게 수정
    //JPA는 @Trasnaction로 묶인 곳 안(영속성 컨텍스트)에서 Entity를 관리
    //Lazy Evaluation을 적용하면 프록시를 이용하며 껍데기인 참조만 리턴 그러기때문에 같은 트랜잭션 상태에서 프록시모드로 물고 있어야함. @Transactional 프록시로 객체를 관리하기때문.

    //두번째방법으로 lazy->eager 페치모드로 변경하면된다.
    @Transactional
    public void 카테고리에서_북정보조회() {
        Category2 category2 = category2Repository.findByName("IT");

        category2.getBooks().stream().forEach(book -> {
            log.info("책제목 :{}",book.getTitle());
        });
    }

}