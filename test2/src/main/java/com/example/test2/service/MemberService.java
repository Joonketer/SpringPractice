package com.example.test2.service;

import com.example.test2.dto.MemberDTO;
import com.example.test2.entity.MemberEntity;
import com.example.test2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public MemberDTO login(MemberDTO memberDTO){    //entity객체는 service에서만
        Optional<MemberEntity> byMemberEmail =
                memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if(byMemberEmail.isPresent()) {
            // 조회결과가 존재한다면
            MemberEntity memberEntity = byMemberEmail.get();    //Optional에서 꺼냄

            if (memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())) {
                // 비민번호 일치
                // entity -> dto 변환 후 리턴
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            } else {
                // 비밀번호 불일치
                return null;
            }
        }
            else{
                // 조회결과가 없다면
            return null;
            }
        }

        public List<MemberDTO> findAll(){
            List<MemberEntity> memberEntityList = memberRepository.findAll();
            //Controller로 dto로 변환해서 줘야 함
            List<MemberDTO> memberDTOList = new ArrayList<>();
            for (MemberEntity memberEntity : memberEntityList){
                memberDTOList.add(MemberDTO.toMemberDTO((memberEntity)));
            }
            return memberDTOList;
        }

        public MemberDTO findById(Long id) {
            // 하나 조회할때 optional로 감싸줌
            Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);
            if (optionalMemberEntity.isPresent()){
                return MemberDTO.toMemberDTO(optionalMemberEntity.get()); // optional을 벗겨내서 entity -> dto 변환
            }else {
                return null;
            }

        }
        public void deleteByid(Long id) {
            memberRepository.deleteById(id);
        }


}
