package Controller;

import DTO.Member;
import Model.MemberModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MemberController {
    MemberModel memberModel = new MemberModel();
    public static final int RECORD_PER_PAGE = 5;
//    @RequestMapping("/Member")
//    public String Member(Model model){
//        model.addAttribute("mem",memberModel.getAll());
//        return "admin/Member";
//    }
@RequestMapping("/Member")
public String Member(@RequestParam(value = "page",defaultValue = "1") int page,Model model){
    int count = memberModel.count();
    int pages = (int) Math.floor(count / memberModel.ROW_PER_PAGE)+1;
    List<Member> list = memberModel.getAllMem(page);
    model.addAttribute("mem",list);
    model.addAttribute("current", page);
    model.addAttribute("total", pages);
    return "admin/Member";
}
    @RequestMapping("/AddMember")
    public String addMember(Model model){
        Member member = new Member();
        model.addAttribute("addMember",member);
        return "admin/AddMember";
    }
    @RequestMapping("/saveMember")
    public String saveMember(@ModelAttribute("addMember") Member member){
        memberModel.Add(member);
        return "redirect:/Member";
    }
    @RequestMapping("/EditMember")
    public String editMember(@RequestParam("id") int id,Model model){
        Member member = memberModel.getById(id);
        model.addAttribute("mem",member);
        return "admin/EditMember";
    }
    @RequestMapping("/updateMember")
    public String updateMember(HttpServletRequest req){
    int id = Integer.parseInt(req.getParameter("id_member"));
    String account = req.getParameter("account");
    String password = req.getParameter("password");
    String fullname = req.getParameter("fullname");
    String phone = req.getParameter("phone");
    int permission = Integer.parseInt(req.getParameter("permission"));
    Member member = new Member(id,account,password,fullname,phone,permission);
    memberModel.update(member);
        return "redirect:/Member";
    }
    @RequestMapping("/deleteMember")
    public String deleteMember(@RequestParam("id") int id){
        memberModel.delete(id);
        return "redirect:/Member";
    }
}
