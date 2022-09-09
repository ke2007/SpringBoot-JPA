package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //조회성능이 더 좋아짐, 영속성컨텍스트를 플러쉬안해서 더티체킹을안하고, DB에 따라 읽기전용 트랜잭션을 구분해서 리소스를 효율적으로 사용하거나 함
//조회 메서드가 더 많으므로 readOnly를 주고 join 메서드에는 그냥 트랜잭셔널을 줌
//class레벨에 @Transactional을 쓰면 public 메서드들은 트랜잭션에 다 걸려들어감. javax 트랜잭셔널도있으나 스프링 트랜잭셔널이 권장됨(쓸수있는게많음).
@RequiredArgsConstructor  //<- final필드만 생성자를 만들어줌
public class MemberService {


    private final MemberRepository memberRepository; // 그냥 @Autowired는 단점이 많다.  테스트시에 바꿔야할 경우가 있을수도있는데.. 생성자 인젝션을 추천.!(final필수)
//
//    @Autowired //setter 인젝션방법 ,장점 : TEST단계에서 MOCK을 주입가능! 치명적 단점: 실제 Run타임에 누군가가 setMemberRepository를 바꿀수있다...하지만 실제로는 스프링 올라오는 타이밍에
//    // 조립이 끝나기때문에 바뀔일이 없다!..근데 잘 동작하고 바뀔일이 없는데 굳이 이렇게 써야되나...? 라는게 단점 , 그래서 나온게 생성자 injection..이다!
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
////    }
//    @Autowired //한번 생성하고 바꿀수도없다, testCase에서도 의존관계를 명확히 알수있다. //최신버전에선. 생성자가 한개인경우 자동으로 Autowired 인젝션을 해줌. //Lombok라이브러리를 쓰면 자동으로 생성해줌
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }



    /*--핵심기능--*/

    // 회원가입
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member); //중복회원검증

        memberRepository.save(member); //검증통과시 아이디 저장후

        return member.getId(); //아이디를 반환
    }

    private void validateDuplicateMember(Member member) {
        //EXCEPTION
        List<Member> findMembers = memberRepository.findByName(member.getName()); //WAS가 동시에 여러개가 뜨므로, memberA라는 두 사람이 동시에 DB인서트를 하게 되면 동시에 중복검사를 통과함.
        // 실무에선 한번 더 걸러야한다(멀티스레드 상황을고려) DB에 member의name을 유니크 제약조건을 걸어야 안전해진다
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

    // 회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }


}
