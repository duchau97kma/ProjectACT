package Controller;
import DTO.Contact;
import Model.ContactModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {
    ContactModel contactModel = new ContactModel();
//    @RequestMapping("/ContactAdmin")
//    public String Contact(Model model){
//        model.addAttribute("contact",contactModel.getAll());
//        return "admin/ContactAdmin";
//    }
@RequestMapping("/ContactAdmin")
public String Contact(@RequestParam(value = "page",defaultValue = "1") int page,Model model){
    int count = contactModel.count();
    int pages = (int) Math.floor(count / contactModel.ROW_PER_PAGE)+1;
    model.addAttribute("contact",contactModel.getAllMem(page));
    model.addAttribute("current", page);
    model.addAttribute("total", pages);
    return "admin/ContactAdmin";
}


//    @RequestMapping("/AddContact")
//    public String addContact(Model model){
//        Contact contact = new Contact();
//        model.addAttribute("command",contact);
//        return "Contact";
//    }
//    @RequestMapping("/saveContact")
//    public String saveContact(@ModelAttribute("command") Contact contact){
//        contactModel.Add(contact);
//        return "redirect:/Contact";
//    }

    @RequestMapping("/deleteContact")
    public String deleteContact(@RequestParam("id") int id){
        contactModel.delete(id);
        return "redirect:/ContactAdmin";
    }

}
