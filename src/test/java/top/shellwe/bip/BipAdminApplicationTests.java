package top.shellwe.bip;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BipAdminApplicationTests {

    @Autowired
    public GetInfoService getInfoService;

    @Test
    void contextLoads() {
        Result result = getInfoService.getByIdEn(20220001);
        System.out.println(result);
    }

}
