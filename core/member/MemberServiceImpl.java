package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //implements는 여러개의 interfaces를 상속 받을 수 있으며,
    //자식 클래스는 부모의 기능을 다시 정의해야 사용해야 한다.

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    } //직접 지정하지 않고, 생성자를 통해서 memberRepository에 무엇이 들어갈지를 지정.

    @Override
    public void join(Member member) {
       memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
