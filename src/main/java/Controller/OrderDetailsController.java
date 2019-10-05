package Controller;
import Model.OrderDetailsModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderDetailsController {
    OrderDetailsModel orderDetailsModel = new OrderDetailsModel();
//    @RequestMapping("/OrderDetails")
//public String OrderDetails(Model model){
//        model.addAttribute("orderDetails",orderDetailsModel.getAll());
//    return "admin/OrderDetails";
//}
@RequestMapping("/OrderDetails")
public String OrderDetails(@RequestParam(value = "page",defaultValue = "1") int page,Model model){
    int count = orderDetailsModel.count();
    int pages = (int) Math.floor(count / orderDetailsModel.ROW_PER_PAGE)+1;
    model.addAttribute("orderDetails",orderDetailsModel.getAllMem(page));
    model.addAttribute("current", page);
    model.addAttribute("total", pages);
    return "admin/OrderDetails";
}

@RequestMapping("/deleteOrderDetails")
    public String deleteOrderDetails(@RequestParam("id") int id){
        orderDetailsModel.delete(id);
        return "redirect:/OrderDetails";
}
}
