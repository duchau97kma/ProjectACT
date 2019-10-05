package Controller;
import Model.OrderModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {
    OrderModel orderModel = new OrderModel();
//    @RequestMapping("/Order")
//    public String order(Model model){
//        model.addAttribute("order",orderModel.getAll());
//        return "admin/Order";
//    }
    @RequestMapping("/Order")
    public String order(@RequestParam(value = "page",defaultValue = "1") int page,Model model){
        int count = orderModel.count();
        int pages = (int) Math.floor(count / orderModel.ROW_PER_PAGE)+1;
        model.addAttribute("order",orderModel.getAllMem(page));
        model.addAttribute("current", page);
        model.addAttribute("total", pages);

        return "admin/Order";
    }

    @RequestMapping("/deleteOrder")
    public String deleteOrder(@RequestParam("id") int id){
        orderModel.delete(id);
        return "redirect:/Order";
    }
}
