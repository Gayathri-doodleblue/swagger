package com.project.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.model.FileUpload;
import com.project.repository.FileUploadRepository;
import com.project.util.ImageUtils;

@Service
public class FileService {
	
	@Autowired
	private FileUploadRepository fileUploadRepository;
	
	
	public String uploadFile(MultipartFile file) throws IOException {

		FileUpload fileData = fileUploadRepository.save(FileUpload.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .fileData(ImageUtils.compressImage(file.getBytes())).build());
        if (fileData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadFile(String fileName){
        Optional<FileUpload> dbImageData = fileUploadRepository.findByName(fileName);
        byte[] images=ImageUtils.decompressImage(dbImageData.get().getFileData());
        return images;
    }

}
