package service;

import model.Member;
import repository.MemberRepository;

public class MemberService {
	private MemberRepository memberRepository;
    private Long idCounter = 1L;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void registerMember(String name, String email) {
       Member member = new Member(idCounter++, name, email);
       memberRepository.save(member);
       System.out.println("Member registered successfully.");
    }

    public Member getMemberById(Long id) {
       return memberRepository.findById(id);
    }
}
