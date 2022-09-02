package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository  //컴포넌트 스캔에의해 자동으로 스프링 빈에의해 관리가되게된다
public class MemberRepository {
    @PersistenceContext //jPA가 제공하는 표준 어노테이션
    private EntityManager em; //스프링이 엔티티매니저를 만들어서 주입해준다.

    public void save(Member member) {
        em.persist(member); //persist 하면 영속성컨텍스트에 member객체를 넣는다, 나중에 트랙잭션이 커밋되는시점에 db에 반영
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id); //JPA 단건조회 find메서드 파라미터는 ( 타입, Primary key )
    }

    public List<Member> findAll() {

        return em.createQuery("select m from Member m", Member.class) //sql과는 조금 다르다 기능적으로는 동일하나, sql은 테이블을 대상으로 쿼리를 하지만, 얘는 엔티티 객체에 대한 쿼리를 날림.
                .getResultList();
    }

    public List<Member> findByName(String name) { //Parameter 바인딩을통한 특정 이름에 의한 회원 찾는기능
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}


