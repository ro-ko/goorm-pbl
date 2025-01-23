package com.hello.service;


import com.hello.domain.Member;
import com.hello.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member signup(Member member) {
        return memberRepository.save(member);
    }

    public Member login(String loginId, String password) {
        return memberRepository.findByLoginId(loginId, password)
                .orElseThrow(() -> new RuntimeException("Member info is not found"));
    }

    public Member findMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member info is not found"));
    }
}
