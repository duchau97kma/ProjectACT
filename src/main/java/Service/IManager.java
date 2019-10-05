package Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

public interface IManager<T> {
     public final static int ROW_PER_PAGE = 6;
     List<T> getAll();
     List<T> getAllMem(int page);
     void Add(T t);
     T getById(int id);
     void update(T t);
     void delete(int id);
     int count();
}
