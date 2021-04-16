import com.ligaofei.domain.User;
import com.ligaofei.domain.Video;
import com.ligaofei.domain.Video2;
import com.ligaofei.domain.VideoOrder;
import com.ligaofei.service.VideoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String [] args){

        // xmlBean();
       zjBean();

    }

    /**
     * 测试注解获取bean
     */
    private static void zjBean(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //扫描指定的包，包括子包
        context.scan("com.ligaofei");
        //里面完成初始化操作，核心方法
        context.refresh();
        VideoService videoService = (VideoService) context.getBean("videoService");
        videoService.findById(2);
        Video video = (Video) context.getBean("video");
        video.init();

        //测试注解scope作用域
        Video video1 = (Video) context.getBean("video");
        Video video2 = (Video) context.getBean("video");
        System.out.println(video1 == video2);


        VideoOrder videoOrder = (VideoOrder) context.getBean("videoOrderName");
    }
    /**
     * 测试获取xml配置
     */
    private static void xmlBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        testInjectCollection(context);
//        testInject(context);
//        testScope(context);
//        testSetInject(context);
//        testBeanJc(context);
//        testInitDestroy(context);
//        videoOrderAutowire(context);
        testAop(context);
    }
    /**
     * 测试bean的生命周期里面的init和destroy方法
     * @param context
     */
    private static void testInitDestroy(ApplicationContext context){
        User user = (User) context.getBean("User");
        //注册回调函数，就会调用destroy了
        ((ClassPathXmlApplicationContext) context).registerShutdownHook();
    }

    /**
     * List-Map注入测试
     * @param context
     */
    private static  void testInjectCollection(ApplicationContext context){
        Video video = (Video)context.getBean("videoListAndMap");
        System.out.println(video.getChapterList().toString());
        System.out.println(video.getVideoMap().values().toString());
    }

    /**
     * 构造函数注入和依赖注入测试
     * @param context
     */
    private static  void testInject(ApplicationContext context){
        Video  video = (Video)context.getBean("video");
        System.out.println(video.getTitle());

        VideoOrder videoOrder = (VideoOrder)context.getBean("videoOrder");
        System.out.println(videoOrder.getOutTradeNo());
        System.out.println(videoOrder.getVideo().getTitle());
    }

    /**
     * 测试autowire自动注入
     * @param context
     */
    private static  void videoOrderAutowire(ApplicationContext context){
        VideoOrder videoOrder = (VideoOrder)context.getBean("videoOrderAutowire");
        System.out.println(videoOrder.getOutTradeNo());
        System.out.println(videoOrder.getVideo().getTitle());
    }

    /**
     *  set注入测试
     */
    private static void testSetInject(ApplicationContext context){
        Video  video = (Video)context.getBean("videoSet");
        System.out.println(video.getTitle());
    }

    /**
     * bean集成测试
     * @param context
     */
    private static void testBeanJc(ApplicationContext context){
        Video2  video2 = (Video2)context.getBean("videoJC");
        System.out.println(video2.getSummary());
        System.out.println(video2.getTitle());
    }

    /**
     *  测试scope作用域
     *  单例singleton打印true
     *  多例prototype打印false
     * @param context
     */
    private static  void testScope(ApplicationContext context){
        Video  video1 = (Video)context.getBean("video");
        Video  video2 = (Video)context.getBean("video");
        //靠匹配内存地址，== 是匹配内存地址
        System.out.println( video1 == video2 );
    }

    /**
     * 测试AOP
     * @param context
     */
    private static  void testAop(ApplicationContext context){
        VideoService videoService = (VideoService)context.getBean("videoService");
        videoService.save(new Video());
        videoService.findById(33);

    }
}
