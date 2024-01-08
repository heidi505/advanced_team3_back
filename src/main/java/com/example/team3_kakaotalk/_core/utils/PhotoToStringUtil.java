package com.example.team3_kakaotalk._core.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import com.example.team3_kakaotalk._core.vo.MyPath;


public class PhotoToStringUtil {
    public static String picToString(MultipartFile file) {
        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(MyPath.IMG_PATH + fileName);
        try {
            Files.write(filePath, file.getBytes());
        } catch (Exception e) {
        	// 예외 처리 부분
        }
        return "/images/uploads/" + fileName;
    }

}
