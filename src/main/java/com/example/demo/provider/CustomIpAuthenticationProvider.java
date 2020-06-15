//package com.example.demo.provider;
//
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.web.authentication.WebAuthenticationDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Component
//public class CustomIpAuthenticationProvider implements AuthenticationProvider {
//
//    Set<String> whitelist = new HashSet<String>();
//
//    public CustomIpAuthenticationProvider() {
//        whitelist.add("11.11.11.11");
//        whitelist.add("12.12.12.12");
////        whitelist.add("127.0.0.1");
////        whitelist.add("178.204.255.197");
//    }
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        System.out.println("я тут!");
//        WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
//        String userIp = details.getRemoteAddress();
//
//        String resp = "";
//        if (!whitelist.contains(userIp)) {
//            resp = SendRequest.send("https://api.2ip.ua/geo.json?ip=" + userIp);
//            if (resp.contains("Russian")) {
//                whitelist.add(userIp);
//            }
//            System.out.println(resp);
//        }
//        System.out.println("userIp " + userIp);
//        if (!whitelist.contains(userIp)) {
//            throw new BadCredentialsException("Invalid IP Address");
//        }
////        if(! whitelist.contains(userIp) ){
////            throw new BadCredentialsException("Invalid IP Address");
////        }
////        //..
//        List<GrantedAuthority> authorities =new ArrayList<GrantedAuthority>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        return new UsernamePasswordAuthenticationToken("name", "password", authorities);
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return aClass.equals(UsernamePasswordAuthenticationToken.class);
////        return false;
//    }
//}