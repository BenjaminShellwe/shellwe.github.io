package top.shellwe.bip;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.shellwe.bip.service.*;
import top.shellwe.bip.util.Result;

@SpringBootTest
class BipAdminApplicationTests {

    @Autowired
    public GetInfoService getInfoService;
    @Autowired
    public GlobalDicService globalDicService;
    @Autowired
    public LogSystemService logSystemService;
    @Autowired
    public MonitorService monitorService;
    @Autowired
    public PerformanceService performanceService;
    @Autowired
    public VacancyComingService vacancyComingService;
    @Autowired
    public VacancyService vacancyService;

    @Test
    void contextLoads() {
        Result result = getInfoService.getByIdEn(20220001);
        System.out.println("result = " + result);
        Result result1 = getInfoService.getByIdPe(20220001);
        System.out.println("result1 = " + result1);
        Result result2 = globalDicService.queryAll();
        System.out.println("result2 = " + result2);
        Result result3 = globalDicService.getByTypeName("证件类型");
        System.out.println("result3 = " + result3);
        Result result4 = logSystemService.queryAll();
        System.out.println("result4 = " + result4);
        Result result5 = monitorService.queryAll();
        System.out.println("result4 = " + result5);
        Result result6 = performanceService.queryAll();
        System.out.println("result4 = " + result6);
        Result result7 = vacancyComingService.queryAll();
        System.out.println("result4 = " + result7);
        Result result8 = vacancyService.queryAll();
        System.out.println("result4 = " + result8);
    }

}
