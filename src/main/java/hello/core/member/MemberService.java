package hello.core.member;

public interface MemberService {
    void join(Member member); //회원가입
    Member findMember(Long memberId); //id로 멤버 찾기
}
