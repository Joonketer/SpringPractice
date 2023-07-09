package com.example.test1.service;

import com.example.test1.dto.MemberDTO;
import com.example.test1.entity.MemberEntity;
import org.springframework.stereotype.Service;

@Service // 스프링 관리해주는 객체
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository; // 먼저 jpa, mysql dependency 추가

    public void save(MemberDTO memberDTO) {
        // repository의 save 메소드 호출
        MemberEntity memberEntity =
                MemberEntity.toMemberEntitiy(memberDTO);
        memberRepository.save(memberEntity);
        // Repository의 save 메소드 호출 (조건. entity 객체를 넘겨줘야 함)
    }
}
