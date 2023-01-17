/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.ecommerce.controllers;

import com.spboot.ecommerce.interfaces.CategoryInterface;
import com.spboot.ecommerce.interfaces.ItemInterface;
import com.spboot.ecommerce.interfaces.OrderInterface;
import com.spboot.ecommerce.interfaces.TodoInterface;
import com.spboot.ecommerce.models.Category;
import com.spboot.ecommerce.models.Item;
import com.spboot.ecommerce.models.Order;
import com.spboot.ecommerce.models.Todo;
import com.spboot.ecommerce.models.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Asus
 */
@Controller
public class MainController {
    
    @Autowired
    private OrderInterface orderInterface;
    
    @Autowired
    private TodoInterface todoInterface;
    
    @Autowired
    private ItemInterface itemInterface;

    @GetMapping("/")
    public String index(Model model,  HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        
        long user_id = (long) session.getAttribute("id");
        
        List<Todo> todos = todoInterface.findByUserId(user_id);
        
        model.addAttribute("todos", todos);
        return "index";
    }

    @GetMapping("/order/create")
    public String create(Model model) {
        
        Order order = new Order();
        model.addAttribute("order", order);

        return "order";
    }

    @PostMapping("/order/store")
    public String store(@ModelAttribute("order") Order order) {
        orderInterface.store(order);
        return "redirect:/";
    }
    
    @PostMapping("/order/post")
    public String post(@ModelAttribute("order") Order order) {
        orderInterface.store(order);
        return "redirect:/showorders";
    }

    @GetMapping("/home")
    public String home(Model model, HttpServletRequest request) {
       
        return "home";
    }
    
    @GetMapping("/showorders")
    public String table(Model model) {
       model.addAttribute("list", orderInterface.getAll());
        return "showorders";
    }
    
    @GetMapping("/order/{id}/edit")
    public String edit(@PathVariable(value = "id") long id, Model model) {
        Order order = orderInterface.getById(id);

        model.addAttribute("order", order);
        return "edit";
    }

    @PostMapping("/order/{id}/delete")
    public String delete(@PathVariable(value = "id") long id) {
        orderInterface.delete(id);
        return "redirect:/showorders";
    }
    
    @GetMapping("/item/create")
    public String item(Model model) {
        
        Item item = new Item();
        model.addAttribute("item", item);
        
        return "item";
    }

    @PostMapping("/item/store")
    public String store(@ModelAttribute("item") Item item) {
        itemInterface.store(item);
        return "redirect:/showitems";
    }
    
    @GetMapping("/item/{id}/edit")
    public String item(@PathVariable(value = "id") long id, Model model) {
        Item item = itemInterface.getById(id);

        model.addAttribute("item", item);
        return "item";
    }

    @PostMapping("/item/{id}/delete")
    public String deletes(@PathVariable(value = "id") long id) {
        itemInterface.delete(id);
        return "redirect:/showitems";
    }
    
    @GetMapping("/showitems")
    public String showitems(Model model) {
       model.addAttribute("list", itemInterface.getAll());
        return "showitems";
    }
}
