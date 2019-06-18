package com.oauth2.client1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oauth2.client1.model.Member;

@Controller
@RequestMapping("/member")
public class MemberController {

   
    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("member/list");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('memberExport')")
    @ResponseBody
    @RequestMapping("/export")
    public List<Member> export() {
        Member member = new Member();
        member.setName("閼诲繋绡�閸庯拷");
        member.setCode("1000");
        member.setMobile("13112345678");
        member.setGender(1);
        Member member1 = new Member();
        member1.setName("闁厼寮�");
        member1.setCode("1001");
        member1.setMobile("15812346723");
        member1.setGender(1);
        List<Member> list = new ArrayList<>();
        list.add(member);
        list.add(member1);
        return list;
    }

    @PreAuthorize("hasAuthority('memberDetail')")
    @RequestMapping("/detail")
    public ModelAndView detail() {
        return new ModelAndView(" member/detail");
    }
}
