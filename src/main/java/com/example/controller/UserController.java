package com.example.controller;


import com.example.model.UserInfo;
import com.example.model.message.DemoData;
import com.example.model.message.MessageServer;
import com.example.service.TestInterFace;
import com.example.service.impl.MailService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author: Yuchenxi
 * @Description:
 * @Date: Created in 15:06 2017/11/21
 * @Param:
 */
@Slf4j
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private TestInterFace testInterFace;
    @Autowired
    private MailService mailService;
    @Autowired
    Configuration configuration;

    /**
     * @author: ycx
     * @date: 2018/3/26 14:06
     * @description: get
     */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public UserInfo getUser() {
        return testInterFace.testUser();
    }

    public static final String to = "18813173384@163.com";
//    private String to = "1471117553@qq.com";

    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    @ResponseBody
    public void sendInlineResourceMail() {
        String rscId = "rscId001";
        mailService.sendInlineResourceMail(to,
                "主题：嵌入静态资源的邮件",
                "<html><body>这是有嵌入静态资源：<img src=\'cid:" + rscId + "\' ><p>原标题:拿过最高科技奖的29人后来都咋样了？</p>\n" +
                        "\n" +
                        "<p><strong>撰文丨高语阳</strong></p>\n" +
                        "\n" +
                        "<p>要说今天（1月8日）的重要新闻，首先要提到的就是一年一次的国家科学技术奖励大会。&nbsp;</p>\n" +
                        "\n" +
                        "<p>大会公布，王泽山和侯云德获得2017年度国家最高科学技术奖，这是中国科技界的最高荣誉，只有非常顶尖的科学家才有机会获得该奖项。从2000年奖项正式设立到现在，已经有29位科学家获奖，每位获奖者可以获得500万元奖金。&nbsp;</p>\n" +
                        "\n" +
                        "<p>政知圈（微信ID:wepolitics）注意到，这些科技贡献者在获得该奖项时的年纪平均都在80岁以上，而且，从2000年设立奖项至今，已经过去18年，这18年来的29位获奖者如今都怎么样了？他们在获奖之后都做了哪些事情？</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<p><strong>82岁与88岁的获奖者</strong></p>\n" +
                        "\n" +
                        "<p>关于这个奖项，先看一下国家是怎么规定的。&nbsp;</p>\n" +
                        "\n" +
                        "<p>1999年5月中华人民共和国国务院发布《国家科学技术奖励条例》，条例中规定：&nbsp;</p>\n" +
                        "\n" +
                        "<p>&ldquo;国务院设立国家科学技术奖。国家科学技术奖包括国家最高科学技术奖、国家自然科学奖、国家技术发明奖、国家科学技术进步奖、中华人民共和国国际科学技术合作奖。</p>\n" +
                        "\n" +
                        "<p>国家最高科学技术奖授予下列科学技术工作者：（1）在当代科学技术前沿取得重大突破或者在科学技术发展中有卓越建树的；（2）在科学技术创新、科学技术成果转化和高技术产业化中，创造巨大经济效益或者社会效益的。</p>\n" +
                        "\n" +
                        "<p>国家最高科学技术奖每年授予人数不超过2名。&rdquo;</p>\n" +
                        "\n" +
                        "<p>然后我们再看下最新获奖的两位科学家。不得不说，他们都是&ldquo;终身贡献，贡献终身&rdquo;的典型。&nbsp;</p>\n" +
                        "\n" +
                        "<p>王泽山出生于1935年，今年已经82岁了，他是火炸药学家，中国工程院院士，南京理工大学教授。&nbsp;</p>\n" +
                        "\n" +
                        "<p><img alt=\"\" src=\"http://p0.ifengimg.com/pmop/2018/0108/DF2BE9F1238A33439EA74D4D9D3C010424E5A915_size20_w530_h282.jpeg\" /></p>\n" +
                        "\n" +
                        "<p>△王泽山</p>\n" +
                        "\n" +
                        "<p>他被称为是&ldquo;火药王&rdquo;，先后攻克&ldquo;废弃火炸药再利用&rdquo;、&ldquo;降低武器对环境温度敏感性&rdquo;、&ldquo;等模块装药和远程、低膛压发射装药技术&rdquo;等难题，最后一项技术难题，他用了20多年的时间才攻克，开始研究这项技术时，他已经61岁。&nbsp;</p>\n" +
                        "\n" +
                        "<p>侯云德出生于1929年，今年88岁，他也是中国工程院院士，分子病毒学家，中国疾病预防控制中心病毒病预防控制所研究员。&nbsp;</p>\n" +
                        "\n" +
                        "<p><img alt=\"\" src=\"http://p0.ifengimg.com/pmop/2018/0108/6ACC17BB0594651860E429C8A6F94D102A08F9C4_size60_w1080_h720.jpeg\" /></p>\n" +
                        "\n" +
                        "<p>△侯云德</p>\n" +
                        "\n" +
                        "<p>侯云德毕业于同济大学医学院七年制，1962年被原苏联医学科学院破格授予医学博士学位。回国后，他曾担任中国预防医学科学院病毒研究所所长、中国工程院医药卫生学部主任等职务。&nbsp;</p>\n" +
                        "\n" +
                        "<p>2009年，侯云德率队实现人类历史上首次对流感大流行的成功干预，87天成功研制疫苗，打破世界纪录。同时，在侯云德的主导下，中国建立了&ldquo;应对新发突发传染病的综合防控网络体系&rdquo;，实现了72小时内鉴定152种已知病毒、147种已知细菌以及新病原检测确认和筛查。</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<p><strong>12位获奖者已经去世</strong></p>\n" +
                        "\n" +
                        "<p>我们一直说，从奖项设立至今，一共有29位获奖者。这29位都是哪些人？我们通过国家科学技术奖励工作办公室公布的名单来看一下。&nbsp;</p>\n" +
                        "\n" +
                        "<p><img alt=\"\" src=\"http://p0.ifengimg.com/pmop/2018/0108/A6104513985074C77A7196DEE4B2A4571A06DDA5_size138_w773_h927.jpeg\" /></p>\n" +
                        "\n" +
                        "<p><img alt=\"\" src=\"http://p0.ifengimg.com/pmop/2018/0108/3D6C7C2B75663B724DF4F33E69CEC28D12A1AFF5_size72_w772_h604.jpg\" /></p>\n" +
                        "\n" +
                        "<p>可以看出，从2000年度至2017年度，只有2004年度和2015年度国家最高科学技术奖获奖者空缺。此外，共有13年获奖者为2人，有3年为1人，共29人。&nbsp;</p>\n" +
                        "\n" +
                        "<p>名单中有你熟悉的科学家么？大概获得2016年度国家最高科学技术奖的屠呦呦算是大家比较熟悉的一位，1930年出生的她在2015年10月，因其发现的青蒿素可以有效降低疟疾患者的死亡率，而成为史上首位获得诺贝尔科学奖项的中国本土科学家。&nbsp;</p>\n" +
                        "\n" +
                        "<p>2014年的国家最高科学技术奖获得者于敏也是享有盛誉的科学家，他出生于1926年，是&ldquo;两弹一星功勋奖章&rdquo;获得者，而在29人名单中，还有一位&ldquo;两弹一星功勋奖章&rdquo;获得者，他是物理学家、中国科学院院士、中国人民解放军总装备部研究员程开甲，他在2013年获得国家最高科学技术奖。&nbsp;</p>\n" +
                        "\n" +
                        "<p><img alt=\"\" src=\"http://p0.ifengimg.com/pmop/2018/0108/975124893917A42927064398ECF71DC783ABDFF5_size31_w550_h385.jpeg\" /></p>\n" +
                        "\n" +
                        "<p>△程开甲获奖证书</p>\n" +
                        "\n" +
                        "<p>首届评奖的2000年度获奖者有大家比较熟悉的袁隆平，他是杂交水稻专家，中国工程院院士，湖南省农业科学院研究员。另外一位是吴文俊，数学家，中国科学院院士，中国科学院数学与系统科学研究院研究员。吴文俊对数学的主要领域拓扑学做出了重大贡献，他引进的示性类和示嵌类被称为&ldquo;吴示性类&rdquo;和&ldquo;吴示嵌类&rdquo;，他导出的示性类之间的关系式被称为&ldquo;吴公式&rdquo;。1970年代后期，他开创了崭新的数学机械化领域，提出了用计算机证明几何定理的&ldquo;吴方法&rdquo;，被认为是自动推理领域的先驱性工作。&nbsp;</p>\n" +
                        "\n" +
                        "<p>吴文俊已经于今年5月7日去世，享年98岁。&nbsp;政知圈（微信ID:wepolitics）看了下，29位获奖者中，去世的有12位。</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<p><strong>获奖后继续出新的研究成果</strong></p>\n" +
                        "\n" +
                        "<p>虽然在获奖时各位科学家的年纪已经不小，平均也是在80岁以上，但是他们中的一些人在获奖后还一直在坚持科学研究。比如我们比较熟知的袁隆平，2000年之后也一直在推进自己的研究，还有一位就是近来大家了解比较多的屠呦呦。&nbsp;</p>\n" +
                        "\n" +
                        "<p><img alt=\"\" src=\"http://p0.ifengimg.com/pmop/2018/0108/62C79028C5BB90A2E67A7A01EB6DCF85FD10D5A4_size28_w562_h350.jpeg\" /></p>\n" +
                        "\n" +
                        "<p>△屠呦呦</p>\n" +
                        "\n" +
                        "<p>屠呦呦获诺贝尔奖和国家最高科学技术奖后的这两年里，一直都在进行青蒿素项目研究。最近公开披露，屠呦呦团队新发现，双氢青蒿素对红斑狼疮有独特效果。研究人员还已证明，青蒿素在治疗肿瘤、白血病、类风湿关节炎、多发性硬化、变态反应性疾病等方面也有一些效果。&nbsp;</p>\n" +
                        "\n" +
                        "<p>弄清楚青蒿素的&ldquo;秘密&rdquo;，很可能不仅仅是发挥它抗疟的作用。前些天，屠呦呦在接受《新华每日电讯》记者采访时说，她已经看到青蒿素&ldquo;在扩大适应症方面的希望&rdquo;。&ldquo;科学要实事求是，药物的关键是疗效，我们现在就是要把论文变成药，让药治得了病，让青蒿素更好地造福人类。&rdquo;屠呦呦说。&nbsp;</p>\n" +
                        "\n" +
                        "<p>有受访专家表示，根据现有临床试验，青蒿素对盘状红斑狼疮有效率超90%、对系统性红斑狼疮有效率超80%，且在发生、发展到终结的整个病理过程均有明显的疗效。&nbsp;</p>\n" +
                        "\n" +
                        "<p>目前，&ldquo;双氢青蒿素治疗红斑狼疮&rdquo;已获国家食药监总局批复同意开展临床验证。&nbsp;</p>\n" +
                        "\n" +
                        "<p>在科学领域贡献一生，对于这些获奖者来说，都不是只说说而已。</p>\n" +
                        "\n" +
                        "<p><strong>资料丨中国网新华社国家科学技术奖励工作办公室官网澎湃新闻观察者网</strong></p>\n</body></html>",
                "D:\\1.jpg",
                rscId);
    }


    //增加新的对外访问接口
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public MessageServer add(@RequestBody DemoData<UserInfo> demoData) throws Exception {
        MessageServer messageServer = new MessageServer();
        try {
            UserInfo userInfo = demoData.getData();
            Integer i = testInterFace.insertUser(userInfo);
            List<UserInfo> list;
            if (i == 1) {
                messageServer.setMsg("添加成功");
                list = testInterFace.selectALL();
                messageServer.setData(list);
                messageServer.setCode(1);
            } else {
                messageServer.setMsg("添加失败");
                messageServer.setCode(-1);
                log.error("新增用户失败！！！");
            }
        } catch (Exception e) {
            log.error("新增用户失败！！！", e);
            throw e;
        }
        return messageServer;
    }

    @ResponseBody
    @RequestMapping(value = "/sendHtmlMailUsingFreeMarker", method = RequestMethod.POST)
    public void sendHtmlMailUsingFreeMarker() {
        String content = null;
        try {
            Map<String, Object> model = new HashMap<String, Object>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            model.put("time", sdf.format(new Date()));
            model.put("message", "这是测试的内容。。。");
            model.put("toUserName", "张三");
            model.put("fromUserName", "老许");
            Template t = configuration.getTemplate("welcome.ftl"); // freeMarker template
            content = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
            log.info(content + "=============");
            mailService.sendHtmlMail(to, "主题：html邮件", content);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    //新增的接口方法
    @RequestMapping(value = "/getall", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<UserInfo> getall() {
        log.info("=============================" + "今晚打老虎" + "=============================");
        List<UserInfo> list = testInterFace.selectALL();
//        JsonConfig jsonConfig = new JsonConfig();
//        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
//        JSONObject json = new JSONObject();
//        JSONObject jsonObject =JSONObject.fromObject(list.get(1), jsonConfig);
//        JSONObject js =  JSONObject.fromObject(jsonObject);
//        log.info(String.valueOf(js));
        return list;
    }

    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list) {
            // 注意这里得到的n是其上边界类型的, 也就是Number, 需要将其转换为double.
            s += n.doubleValue();
        }
        return s;
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public void test(HttpServletRequest request){
        byte[] bytes = new byte[1024 * 1024];
        try {
            request.getInputStream().read(bytes);
            String params = new String(bytes, "utf-8");
            System.out.println(params);
            JSONObject jsonObject = JSONObject.fromObject(params);
//            OrderListParam orderListParam = (OrderListParam) JSONObject.toBean(jsonObject,OrderListParam.class);
//            System.out.println(orderListParam.getSecondaryClassify());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
