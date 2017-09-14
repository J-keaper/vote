package com.keaper.vote.web.controller;


import com.keaper.vote.common.constants.SiteConstants;
import com.keaper.vote.common.utils.BufferedImageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/image")
public class ImageController {

    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);

    @ResponseBody
    @RequestMapping("/{name}")
    public ResponseEntity<byte[]> showImage(@PathVariable(value = "name") String imageName) throws IOException {
        logger.info("name:{}",imageName);
        File file = new File(SiteConstants.IMAGE_DIR+File.separator+imageName);
        logger.info(String.valueOf(file));
        BufferedImage bufferedImage = ImageIO.read(file);
        byte [] bytes = BufferedImageUtils.getBytes(bufferedImage);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(bytes);
    }

}
