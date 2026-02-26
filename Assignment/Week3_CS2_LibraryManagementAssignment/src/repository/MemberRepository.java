package repository;

import java.util.ArrayList;
import java.util.List;

import model.Member;

public class MemberRepository {
    private List<Member> members = new ArrayList<>();

    public void save(Member member) {
        members.add(member);
    }

    public Member findById(Long id) {
        for (Member m : members) {
            if (m.getId().equals(id)) {
                return m;
            }
        }
        return null;
    }
	
}
