package Controller;
import Model.PlaceModel;
import DTO.Tour;
import Model.ImagesModel;
import Model.CategoryModel;
import Model.TourModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TourController {
    PlaceModel placeModel = new PlaceModel();
    CategoryModel categoryModel = new CategoryModel();
    ImagesModel imagesModel = new ImagesModel();
    TourModel tourModel = new TourModel();
//    @RequestMapping("/Tour")
//    public String Tour(Model model){
//        model.addAttribute("getTour",tourModel.getAll());
//        return "admin/Tour";
//    }
@RequestMapping("/Tour")
    public String Tour(@RequestParam(value = "page",defaultValue = "1") int page,Model model){
    int count = tourModel.count();
    int pages = (int) Math.floor(count / tourModel.ROW_PER_PAGE)+1;
        model.addAttribute("getTour",tourModel.getAllMem(page));
        model.addAttribute("current", page);
        model.addAttribute("total", pages);
        return "admin/Tour";
    }

    @RequestMapping("/AddTour")
    public String addTour(Model model){
        Tour tour = new Tour();
        model.addAttribute("command",tour);
        model.addAttribute("place",placeModel.getAll());
        model.addAttribute("img",imagesModel.getAll());


        model.addAttribute("cate",categoryModel.getAll());

        return "admin/AddTour";
    }
    @RequestMapping("/saveTour")
    public String saveTour(@ModelAttribute("command") Tour tour){
        tourModel.Add(tour);
        return "redirect:/Tour";
    }

    @RequestMapping("/EditTour")
    public String editTour(@RequestParam("id") int id,Model model){
        Tour tour = new TourModel().getById(id);
        model.addAttribute("tour",tour);
        model.addAttribute("place",placeModel.getAll());
        model.addAttribute("img",imagesModel.getAll());
        model.addAttribute("cate",categoryModel.getAll());

        return "admin/EditTour";
    }
    @RequestMapping("/updateTour")
    public String updateTour(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id_tour"));
        String nameTour = request.getParameter("nameTour");
        int id_place = Integer.parseInt(request.getParameter("id_place"));
        int id_cate = Integer.parseInt(request.getParameter("id_cate"));
        int id_img = Integer.parseInt(request.getParameter("id_img"));
        double price = Double.parseDouble(request.getParameter("price"));
        double discount = Double.parseDouble(request.getParameter("discount"));
        String departureDate = request.getParameter("departureDate");
        String summaryTour = request.getParameter("summaryTour");
        String content = request.getParameter("content");
        int totalMem = Integer.parseInt(request.getParameter("totalMember"));
        Tour tour = new Tour(id,nameTour,content,summaryTour,departureDate,price,discount,id_place,id_cate,id_img,totalMem);
        tourModel.update(tour);
        return "redirect:/Tour";
    }
//    @RequestMapping("/updateTour")
//    public String updateTour(HttpServletRequest r, Tour tour){
//        int id = Integer.parseInt(request.getParameter("id_tour"));
//        String nameTour = request.getParameter("nameTour");
//        int id_place = Integer.parseInt(request.getParameter("id_place"));
//        int id_cate = Integer.parseInt(request.getParameter("id_cate"));
//        int id_img = Integer.parseInt(request.getParameter("id_img"));
//        double price = Double.parseDouble(request.getParameter("price"));
//        double discount = Double.parseDouble(request.getParameter("discount"));
//        String departureDate = request.getParameter("departureDate");
//        String summaryTour = request.getParameter("summaryTour");
//        String content = request.getParameter("content");
//        tour = new Tour(id,nameTour,content,summaryTour,departureDate,price,discount,id_place,id_cate,id_img);
//        System.out.println(id);
//        System.out.println(nameTour);
//        System.out.println(id_place);
//        System.out.println(id_cate);
//        System.out.println(id_img);
//        System.out.println(price);
//        System.out.println(discount);
//        System.out.println(departureDate);
//        System.out.println(summaryTour);
//        System.out.println(content);
//        tourModel.update(tour);
//        return "redirect:/Tour";
//    }
    @RequestMapping("/DeleteTour")
    public String deleteTour(@RequestParam("id") int id){
        tourModel.delete(id);
        return "redirect:/Tour";
    }

}
