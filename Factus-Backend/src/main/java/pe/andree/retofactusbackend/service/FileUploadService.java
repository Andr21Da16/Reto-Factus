package pe.andree.retofactusbackend.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    String uploadFile(MultipartFile file, Long CompanyId);
    boolean deleteFile(String url);
}
