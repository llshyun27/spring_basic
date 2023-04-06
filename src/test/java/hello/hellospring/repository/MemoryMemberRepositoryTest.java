package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.springframework.stereotype.Repository;

import static org.hamcrest.CoreMatchers.*;
@Repository
public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); //내가 넣은게 제대로 들어갔는지 확인
        System.out.println("result ="+(result == member));

        Assertions.assertEquals(member,result);  //앞에 것이 기대한 값, 뒤에가 실제
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result); //assertThat 사용
     }
     @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

         Member member2 = new Member();
         member2.setName("spring2");
         repository.save(member2);

         Member result = repository.findByName("spring1").get();

         org.assertj.core.api.Assertions.assertThat(result).isEqualTo(member1);
     }
     @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

         Member member2 = new Member();
         member2.setName("spring2");
         repository.save(member2);

         List<Member> result = repository.findAll();
         org.assertj.core.api.Assertions.assertThat(result.size()).isEqualTo(2);
     }

}
