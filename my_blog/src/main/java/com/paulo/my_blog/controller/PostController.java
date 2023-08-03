package com.paulo.my_blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.paulo.my_blog.model.Post;
import com.paulo.my_blog.repository.PostRepository;

import jakarta.validation.Valid;


@Controller
public class PostController {
    
    @Autowired
    private PostRepository pr;

    @GetMapping("/posts")
    public String getPost( Model model){
        List<Post> post = pr.findAll();
        model.addAttribute("posts", post);
        return "postHome";
    }

    @GetMapping("/posts/{id}")
    public String detail(@PathVariable("id") long id, Model model){
        model.addAttribute("post", pr.getReferenceById(id));
        return "detalhe";
    }

    @GetMapping("/newpost")
    public String form(Model model){
        model.addAttribute("post", new Post());
        return "postForm";
    }

    @PostMapping("/newpost")
    public String formSave(@Valid Post post, BindingResult result, RedirectAttributes rAttributes){
        if (result.hasErrors()){
            rAttributes.addFlashAttribute("mensagem", "Não foi possivel salvar dados no banco");
            return "redirect:/newpost";
        }
        pr.save(post);
        rAttributes.addFlashAttribute("mensagem", "Dados salvos com sucesso");
        return "redirect:/newpost";
    }
}
