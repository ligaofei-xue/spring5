import com.ligaofei.domain.User;
import com.ligaofei.domain.Video;
import com.ligaofei.domain.Video2;
import com.ligaofei.domain.VideoOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String [] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        testInjectCollection(context);
//        testInject(context);
//        testScope(context);
//        testSetInject(context);
//        testBeanJc(context);
//        testInitDestroy(context);
        videoOrderAutowire(context);

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
}
