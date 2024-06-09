package crud.library.rest_api.library_rest_api.service;

import crud.library.rest_api.library_rest_api.entity.Member;
import crud.library.rest_api.library_rest_api.model.CreateMemberRequest;
import crud.library.rest_api.library_rest_api.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Member create(CreateMemberRequest request) {
        Member member = new Member();

        member.setName(request.getName());
        member.setHobby(request.getHobby());
        member.setAddress(request.getAddress());

        memberRepository.save(member);

        return member;
    }


    @Transactional
    public Member update(CreateMemberRequest request) {
        Member member = new Member();

        member.setName(request.getName());
        member.setHobby(request.getHobby());
        member.setAddress(request.getAddress());

        memberRepository.save(member);

        return member;
    }
}
