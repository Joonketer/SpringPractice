package com.example.jwt.service;

import com.example.jwt.dto.MemberSignInResquestDto;
import com.example.jwt.dto.MemberSignUpRequestDto;
import com.example.jwt.entity.Member;
import com.example.jwt.jwt.JwtUtil;
import com.example.jwt.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface MemberService {


    public String signIn(MemberSignInResquestDto requestDto) throws Exception;


    public Long signUp(MemberSignUpRequestDto requestDto) throws Exception;

    public String generateToken(String username);


}