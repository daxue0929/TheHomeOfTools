package org.daxue.controller;

import lombok.extern.slf4j.Slf4j;
import org.daxue.service.core.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CoreUserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    SysUserService sysUserService;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/generateToken")
    private String generateToken(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(upToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Reload password post-security so we can generate token
        final UserDetails userDetails = sysUserService.loadUserByUsername(username);
        // 持久化的redis
//        String token = CommonUtils.encrypt(userDetails.getUsername());
        stringRedisTemplate.opsForValue().set(userDetails.getUsername(), userDetails.getUsername());
        log.info("{}", userDetails.toString());
        return userDetails.getUsername();
    }




}
