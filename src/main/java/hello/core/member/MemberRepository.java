package hello.core.member;

public interface MemberRepository {
    void save(Member member);  //회원 정보 저장

    Member findById(Long memberId);  //회원의 아이디로 회원을 찾는 기능
}
