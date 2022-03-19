package top.shellwe.bip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.shellwe.bip.entity.Avatar;
import top.shellwe.bip.service.AvatarService;
import top.shellwe.bip.util.Result;

import java.io.InputStream;

@Controller
@RequestMapping("/avatar")
public class AvatarController {

    @Autowired
    AvatarService avatarService;

    @RequestMapping("/insert")
    public Result Insert(Avatar data){
        avatarService.insert(data);
        return new Result(200, "Success", "Data been changed.");
    }

    @RequestMapping("/query")
    public Result QueryByID(){
        avatarService.query(2022001);
        System.out.println("测试输出" + avatarService.query(2022001).getData());
        return new Result(200, "Success" );
    }

    @PostMapping("/uploadImage")
    @ResponseBody
    public String uploadImage(RepairOrderImage repairOrderImage){
        try {
            log.info("[repairOrderImage]: " + repairOrderImage);

            InputStream inputStream = repairOrderImage.getImage().getInputStream();
            byte [] imageByte  = new byte[(int) repairOrderImage.getImage().getSize()];
            inputStream.read(imageByte);

            RepairOrderBlobs repairOrderBlobs = new RepairOrderBlobs();
            repairOrderBlobs.setFaultDes("测试");

            repairOrderBlobs.setImage(imageByte);

            repairOrderBlobsMapper.insert(repairOrderBlobs);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMessage.successJsonData();
    }

}
