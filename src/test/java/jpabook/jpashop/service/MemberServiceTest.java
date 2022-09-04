package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //Springboot를 띄운 상태에서 테스트하려면 넣어줘야함 없으면 Autowired가 다 실패함!
@Transactional //트랜잭션을 걸고 테스트를 돌린후, 테스트가 끝나면 롤백함. 서비스에선 롤백하면안됩니당
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
//    @Rollback(false) DB에서 눈으로 확인할 수 있다 .
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("kim");
        //when
        Long savedId = memberService.join(member);
        //then
//        em.flush(); // flush 영속성컨텍스트안에 있는 변경,등록내용을 DB에 반영하는것 , 보이지않던 insert 쿼리를 볼수있다. 그 후 롤백.(TEST 시 DB에 데이터가 남으면 안되므로)
        assertEquals(member,memberRepository.findOne(savedId));
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("Kim1");

        Member member2 = new Member();
        member2.setName("Kim1");

        //when
        memberService.join(member1);
//        try {
//            memberService.join(member2); //예외가 터저야한다 !
//        } catch (IllegalStateException e) {
//            return;
//        } // 밑의 코드로 대체가능

        //then

        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertEquals("이미 존재하는 회원입니다",thrown.getMessage());


    }

}
