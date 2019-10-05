package Controller;

import DTO.Member;
import Model.MemberModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("account")
public class LoginController {
    MemberModel memberModel = new MemberModel();
    @RequestMapping("/login")
    public String loginForm(Model model){
        Member member = new Member();
        model.addAttribute("command",member);
        return "admin/LoginAdmin";
    }
    @RequestMapping("/logging")
    public String login(@ModelAttribute("command") Member member, Model model){
        try {
            Member member1 = memberModel.checkLogin(member.getAccount(),member.getPassword());
            if(member1!=null){
                if (memberModel.checkAdmin(member)){
                    model.addAttribute("account",member.getAccount());
                        return "redirect:/report";
                }else{
                    return "redirect:/home";
                }
            }else {
                model.addAttribute("err","invalid account or password");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return "admin/LoginAdmin";
    }
    @RequestMapping("/logoutad")
    public String logoutad(SessionStatus status){
        status.setComplete();
        return "admin/LoginAdmin";
    }
}
