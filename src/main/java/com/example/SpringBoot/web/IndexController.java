package com.example.SpringBoot.web;

import com.example.SpringBoot.config.auth.LoginUser;
import com.example.SpringBoot.config.auth.dto.SessionUser;
import com.example.SpringBoot.service.posts.PostsService;
import com.example.SpringBoot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model; //Model 객체를 사용하여 View에 데이터 전달
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller //View를 반환하기 위해 사용
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user)
    {
        // model.addAttribute(key, value)로 key,value 쌍으로 전달 가능
        model.addAttribute("posts", postsService.findAllDesc());
        //SessionUser user = (SessionUser) httpSession.getAttribute("user"); // @LoginUser를 사용해서 필요 없음
        if(user!=null){
            model.addAttribute("userName",user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);

        return "posts-update";
    }
}
