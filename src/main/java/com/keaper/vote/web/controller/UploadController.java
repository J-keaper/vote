package com.keaper.vote.web.controller;

import com.keaper.vote.common.constants.SiteConstants;
import com.keaper.vote.web.vo.JsonResult;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
public class UploadController {
    private  static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    @ResponseBody
    @RequestMapping(value = "/image",method = RequestMethod.POST)
    public JsonResult fileUpload(@RequestParam("file")MultipartFile multipartFile, HttpServletRequest request){
        String baseDirName = SiteConstants.IMAGE_DIR;
        File baseDir = new File(baseDirName);
        if(!baseDir.exists()){
            baseDir.mkdirs();
        }
        String fileName = baseDir.getAbsolutePath() + File.separator +
                UUID.randomUUID().toString().replace("-","");
        File file = new File(fileName);
        logger.info("文件路径：{}",file.getPath());
        try {
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(),file);
            String imageUrl = "/image/"+file.getName();
            return JsonResult.getCorrectResult(imageUrl);
        } catch (IOException e) {
            logger.error("上传文件失败！",e);
            return JsonResult.getErrorResult(
                    JsonResult.Code.UPLOAD_IMAGE_FAIL.name(),
                    JsonResult.Code.UPLOAD_IMAGE_FAIL.getCode(),
                    null
            );
        }
    }
}
