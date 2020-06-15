package com.example.demo.controllers;

import com.example.demo.dto.SignUpDto;
import com.example.demo.models.User;
import com.example.demo.service.SignUpService;
import com.example.demo.translater.LgTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Locale;

@Controller
public class SignUpController {
    @Autowired
    private SignUpService service;

    @GetMapping("/signUp")
    public String getSignUpPage(Model model) {
        System.out.println("hello bro");
        model.addAttribute("user", new User());
        return "test";
    }

    @PostMapping("/signUp")
    public String signUp(SignUpDto form) {
        service.signUp(form);
        return "redirect:/signUp";
    }

    @GetMapping("/trans")
    public String postTranslate() {
        LgTranslator tr = new LgTranslator();
        System.out.println(tr.print("Привет!",new Locale(Locale.ENGLISH.getLanguage())));
        return "trans";
    }

//    @ResponseBody
//    @RequestMapping(value = "/photo2", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
//    public byte[] testphoto() throws IOException {
//        InputStream in = servletContext.getResourceAsStream("/images/no_image.jpg");
//        return IOUtils.toByteArray(in);
//    }
}
