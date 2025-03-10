package com.example.imapp.web.users;

import com.example.imapp.domain.auth.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "users/list";
    }

    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute UserForm form) {
        return "users/creationForm";
    }

    @PostMapping
    public String create(@Validated UserForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return showCreationForm(form);
        }

        userService.create(form.getUsername(), form.getPassword(), form.getAuthority());
        return "redirect:/users";
    }
}
