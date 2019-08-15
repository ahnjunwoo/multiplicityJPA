# 로컬에 mysql 설치후 테스트 진행

## Many To One   - 다대일( N : 1 )

엔티티 book, category 샘플 소스참고(BookTest.class)

Category에서 Book 정보들을 쭉 가져오고 싶은 경우 양방향 설정을 해줘야 한다.

엔티티 book, category2 샘플 참고(BookTest.class)

## One To one - 일대일( 1:1 )

유저는 하나의 블로그를 가지게 된다 1:1관계

엔티티 User,Blog 참조

## Many To Many - 다대다( N:N )

member,product 참조 다대다 관계로 중간 테이블을 생성하여 처리(ManyToManyTest.class)

