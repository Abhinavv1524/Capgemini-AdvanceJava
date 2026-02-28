package in.cg.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

@Controller
public class MyController {

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @GetMapping("/register")
    public ModelAndView showRegister() {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public String registerCustomer(
            @RequestParam("name") String name,
            @RequestParam("age") int age,
            @RequestParam("email") String email,
            @RequestParam("city") String city,
            Model model) {

        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("email", email);
        model.addAttribute("city", city);

        return "confirmation";
    }

    @GetMapping("/plans")
    public ModelAndView showPlans() {
        return new ModelAndView("plans");
    }

    @PostMapping("/apply")
    public String applyPlan(@RequestParam("planName") String planName, Model model) {
        model.addAttribute("planName", planName);
        model.addAttribute("status", "Application Submitted Successfully!");
        return "status";
    }

    @GetMapping("/status")
    public ModelAndView checkStatus() {

        ModelAndView mv = new ModelAndView("status");
        mv.addObject("status", "Pending");

        return mv;
    }
}