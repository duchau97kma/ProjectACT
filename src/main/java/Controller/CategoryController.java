package Controller;

import DTO.Category;
import Model.CategoryModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {
    CategoryModel categoryModel = new CategoryModel();
//    @RequestMapping("/Category")
//    public String category(Model model){
//
//        model.addAttribute("cate",categoryModel.getAll());
//        return "admin/Category";
//    }
@RequestMapping("/Category")
public String category(@RequestParam(value = "page",defaultValue = "1") int page,Model model){
    int count = categoryModel.count();
    int pages = (int) Math.floor(count / categoryModel.ROW_PER_PAGE)+1;
    model.addAttribute("cate",categoryModel.getAllMem(page));
    model.addAttribute("current", page);
    model.addAttribute("total", pages);
    return "admin/Category";
}
    @RequestMapping("/AddCategory")
    public String addCategory(Model model){
        Category category = new Category();
        model.addAttribute("command",category);
        return "admin/AddCategory";
    }
    @RequestMapping("/saveCate")
    public String saveCategory(@ModelAttribute("command") Category category){
        categoryModel.Add(category);
        return "redirect:/Category";
    }
    @RequestMapping("/EditCategory")
    public String editCategory(@RequestParam("id") int id,Model model){
       Category category = categoryModel.getById(id);
       model.addAttribute("cate",category);
        return "admin/EditCategory";
    }
    @RequestMapping("/updateCate")
    public String updateCategory(@ModelAttribute("cate") Category category){
        categoryModel.update(category);
        return "redirect:/Category";
    }
    @RequestMapping("/deleteCate")
    public String deleteCategory(@RequestParam("id") int  id){
        categoryModel.delete(id);
        return "redirect:/Category";
    }
}
