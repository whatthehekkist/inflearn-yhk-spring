package inflearn.yhk._01.service;

import inflearn.yhk._01.domain.Member;
import inflearn.yhk._01.repository.MemberRepository;
import inflearn.yhk._01.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    /**
     * @param memberRepository
     */
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * Create a member
     * @param member
     * @return member.getId()
     */
    public Long join(Member member) {

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * Get all members
     * @return memberRepository.findAll()
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * Get a member
     * @param memberId
     * @return memberRepository.findById(memberId)
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    private void validateDuplicateMember(Member member) {
        // As findByName(member.getName()) returns an optional member,
        // chaining .ifPresent() does the same as the code below reducing codes.
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
            throw new IllegalStateException("member already exists");
        });

        /***
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("member already exists");
        });
        ***/

        // some other ways
        /* result.orElseGet() */
        /* Member member1 = result.get(); // can get result directly, but not recommended */
    }
}
