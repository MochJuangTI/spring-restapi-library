package crud.library.rest_api.library_rest_api.service;

import crud.library.rest_api.library_rest_api.entity.Member;
import crud.library.rest_api.library_rest_api.model.CreateMemberRequest;
import crud.library.rest_api.library_rest_api.model.MemberResponse;
import crud.library.rest_api.library_rest_api.model.UpdateMemberRequest;
import crud.library.rest_api.library_rest_api.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MemberService {

    private MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public MemberResponse create(CreateMemberRequest request) {
        Member member = new Member();

        member.setName(request.getName());
        member.setHobby(request.getHobby());
        member.setAddress(request.getAddress());

        memberRepository.save(member);

        return toMemberResponse(member);
    }


    @Transactional
    public MemberResponse update(UpdateMemberRequest request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "member not found") );

        member.setName(request.getName());
        member.setHobby(request.getHobby());
        member.setAddress(request.getAddress());

        memberRepository.save(member);

        return toMemberResponse(member);
    }

    @Transactional
    public MemberResponse delete(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "member not found") );

        memberRepository.delete(member);
        return toMemberResponse(member);
    }

    public MemberResponse getById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "member not found") );

        return toMemberResponse(member);
    }

    public List<MemberResponse> getAll() {
        List<Member> members = memberRepository.findAll();

        List<MemberResponse> memberResponses = List.of();
        for (Member member : members) {
            memberResponses.add(toMemberResponse(member));
        }
        return memberResponses;
    }


    private MemberResponse toMemberResponse(Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .hobby(member.getHobby())
                .address(member.getAddress()).build();

    }
}
