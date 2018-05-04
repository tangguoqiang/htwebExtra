import com.alibaba.fastjson.JSON;
import com.ht.extra.dao.ClinicIndexMapper;
import com.ht.extra.dao.DeptDictMapper;
import com.ht.extra.dao.InpatientMapper;
import com.ht.extra.pojo.Inpatient;
import com.ht.extra.pojo.comm.DeptDict;
import com.ht.extra.pojo.outpadm.ClinicIndex;
import com.ht.extra.service.InpatientService;
import com.ht.extra.util.DateToWeek;
import com.ht.extra.util.PinyinTool;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Dell on 2016/7/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMyBatis {
    private static Logger logger = Logger.getLogger(TestMyBatis.class);
    //	private ApplicationContext ac = null;
    @Resource
    private DeptDictMapper deptDictMapper;

    @Resource
    private InpatientMapper inpatientMapper;

    @Resource
    private ClinicIndexMapper clinicIndexMapper;
//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

    @Test
    public void test1() {
        DeptDict inps = deptDictMapper.selectByPrimaryKey("122");
        //List<Inpatient> inps = inpatientMapper.selectByOutTime("20161215000000","20161216000000");
        // System.out.println(user.getUserName());
        // logger.info("值："+inp.getHospitalDischargeTime());
        //logger.info("size"+inps.size());
        logger.info(JSON.toJSONString(inps));
    }

    @Test
    public void test2() throws Exception{
        PinyinTool pinyinTool = new PinyinTool();
        System.out.println(pinyinTool.toPinYin("张巨鹏"," ",PinyinTool.Type.UPPERCASE));
    }

    @Test
    public void test3(){
        List<ClinicIndex> clinicIndices = clinicIndexMapper.selectByDept("6400");
        System.out.println(clinicIndices.get(0).getDoctorTitleDict().getTitleName());
    }

    @Test
    public void test4(){
        ClinicIndex clinicIndice = clinicIndexMapper.selectByPrimaryKey("123456");
        System.out.println(clinicIndice.getDoctorTitle());
    }

    @Test
    public void testforDateToWeek() {
        HashMap<String, String> hashMap = DateToWeek.forDateToWeek("2016-12-10", "2016-12-20");
        System.out.println(hashMap.size());
    }
    @Test
    public void getPropertyByName() {
        String result = "";

        try {
            // 方法一：通过java.util.ResourceBundle读取资源属性文件
            result = java.util.ResourceBundle.getBundle("jdbc").getString("url");
            System.out.println("name:" + result);
        } catch (Exception e) {
            System.out.println("getPropertyByName2 error:");
        }
       // return result;
    }



}
