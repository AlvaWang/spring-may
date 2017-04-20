package net.bambooslips.demo.controller;

import net.bambooslips.demo.exception.FileNameExtensionNotSupportedException;
import net.bambooslips.demo.exception.InvalidParamsException;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Created by Eureka on 2016/5/12.
 * Contributed by D_Air 2016/5/15
 *
 */

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    //提供 2个接口 一个是上传html 一个是上传视频和动画，上传视频和动画返回文件的url （这边的实现还有问题吧）

    private static final Logger LOG = LoggerFactory.getLogger(DashboardController.class);


    @Autowired
    private Environment env;

    /**
     * Show the index page containing the form for uploading a file.
     */
    @RequestMapping()
    public String index() {
        return "dashboard";
    }

    @RequestMapping("/actuator")
    public String actuator() {
        return "fragments/actuator";
    }

    /**
     * POST /uploadFile -> receive and locally save a file.
     *
     * @param uploadfile The uploaded file as Multipart file parameter in the
     *                   HTTP request. The RequestParam name must be the same of the attribute
     *                   "name" in the input tag with type file.
     * @return An http OK status in case of success, an http 4xx status in case
     * of errors.
     * 上传照片
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("uploadfile") MultipartFile uploadfile) throws MultipartException,FileNotFoundException,IOException {
        String fileName = "";
        // Get the filename and build the local file path
        if(uploadfile == null ){
            throw new InvalidParamsException("Uploaded File is null.");
        }
        fileName = uploadfile.getOriginalFilename();
        // 判断文件后缀名
        String ext =fileName.substring(fileName.lastIndexOf('.')+ 1,fileName.length());
        ext = ext.toLowerCase();
        LOG.debug( ext );
        if (ext.equals("jpeg") | ext.equals("jpg") | ext.equals("png") | ext.equals("gif") | ext.equals("bmp") | ext.equals("mp4") | ext.equals("webm")  | ext.equals("ogg")){
            fileName = UUID.randomUUID().toString() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);// uploadfile.getOriginalFilename();
            LOG.debug(fileName + "saved.");
            String directory = env.getProperty("uploaded-files.path");
            String filepath = Paths.get(directory, fileName).toString();

            // Save the file locally
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(new File(filepath)));
            stream.write(uploadfile.getBytes());
            stream.close();

            // Generate thumbnails
            if (ext.equals("jpeg") | ext.equals("jpg") | ext.equals("png") | ext.equals("bmp")) {
                InputStream in = new ByteArrayInputStream(uploadfile.getBytes());
                BufferedImage img = ImageIO.read(in);
                BufferedImage scaledImg = Scalr.resize(img, Scalr.Method.QUALITY,
                        Scalr.Mode.FIT_TO_WIDTH, 200, Scalr.OP_ANTIALIAS);
                directory += "/thumbnails";
                filepath = Paths.get(directory, fileName).toString();
                ImageIO.write(scaledImg, ext, new File(filepath));

            }

        } else {
            throw new FileNameExtensionNotSupportedException("File type \'"+ ext + "\' not supported." );
        }

        return "/files/" + fileName;
    }
}
