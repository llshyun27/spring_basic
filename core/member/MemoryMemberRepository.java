package hello.core.member;

import java.util.HashMap;
import java.util.Map;

//구현체
public class MemoryMemberRepository implements MemberRepository {
    private  static Map<Long,Member> store = new HashMap<>();
    //HashMap 클래스를 사용하여 데이터를 저장하고, Map 인터페이스를 사용하여 이 클래스의 참조를 보유

    @Override
    public void save(Member member) {
       store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
