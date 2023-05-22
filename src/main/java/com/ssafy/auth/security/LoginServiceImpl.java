package com.ssafy.auth.security;

import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.member.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.google.common.base.Optional;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements UserDetailsService {

    private final MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return Optional.fromNullable(memberService.findByUserId(username))
                    .transform(this::createUserDetails)
                    .or(() -> {
                        throw new UsernameNotFoundException(username + "-> DB에 없는 유저");
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //        return memberService.findByUserId(username)
//                .map(this::createUserDetails)
//                .orElseThrow(() -> new UsernameNotFoundException(username + "-> DB에 없는 유저"));
    }

    //DB에 존재하는 유저일 경우 UserDetails로 만들어서 반환
    private UserDetails createUserDetails(MemberDto user) {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole().toString());

        return new org.springframework.security.core.userdetails.User(
                String.valueOf(user.getEmail()),
                user.getPassword(),
                Collections.singleton(grantedAuthority)
        );
    }
}