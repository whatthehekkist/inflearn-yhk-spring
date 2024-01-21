package inflearn.yhk._01.repository;

import inflearn.yhk._01.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    /**
     * save (create)  an instance of  Member
     * @param member
     * @return a new member
     */
    @Override
    public Member save(Member member) {
        member.setId(++sequence); // auto-increment
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    /**
     * @param name
     * @return name in DB that is equals to param name
     */
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    /**
     * @return all member in DB
     */
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    /**
     * clear all the mapping on call
     */
    public void clearStore() {
        store.clear();
    }
}
