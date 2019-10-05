package Service;

import java.io.Serializable;
import org.springframework.web.multipart.MultipartFile;
public class MyFile implements Serializable {
    private static final long serialVersionUID = 1L;
    private MultipartFile multipartFile;

    public MyFile() {
    }

    public MyFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}

