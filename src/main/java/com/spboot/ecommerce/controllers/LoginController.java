/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.ecommerce.controllers;

import com.spboot.ecommerce.interfaces.UserInterface;
import com.spboot.ecommerce.models.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Asus
 */
@Controller
public class LoginController {

    @Autowired
    private UserInterface userInterface;

    @GetMapping("/login")
    public String index(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "login";
    }

    @PostMapping("/login")
    public String store(@ModelAttribute("user") User user,
        HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession(true);

        User obj = userInterface.auth(user.getEmail(), user.getPassword());

        if (obj == null) {
            session.setAttribute("error", "Invalid username or password!");
            return "redirect:/login";
        }

        session.setAttribute("id", obj.getId());
        session.setAttribute("email", obj.getEmail());
        session.setAttribute("name", obj.getName());
        session.setAttribute("loggedIn", true);

        return "redirect:/";
    }
    
    @GetMapping("/login/admin")
    public String admin(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "admin";
    }

    @PostMapping("/login/admin")
    public String adminstore(@ModelAttribute("user") User user,
            HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession(true);

        User obj = userInterface.auth(user.getEmail(), user.getPassword());

        if (obj == null) {
            session.setAttribute("error", "Invalid username or password!");
            return "redirect:/login";
        }

        session.setAttribute("id", obj.getId());
        session.setAttribute("email", obj.getEmail());
        session.setAttribute("name", obj.getName());
        session.setAttribute("loggedIn", true);

        return "redirect:/showorders";
    }

}
