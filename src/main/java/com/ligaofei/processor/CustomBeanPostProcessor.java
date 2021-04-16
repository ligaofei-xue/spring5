package com.ligaofei.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

/**
 *  bean的二次加工-Spring5.x后置处理器 BeanPostProcessor
 *  是Spring IOC容器给我们提供的一个扩展接口
 * 在调用初始化方法前后对 Bean 进行额外加工，ApplicationContext 会自动扫描实现了BeanPostProcessor的 bean，并注册这些 bean 为后置处理器
 * 是Bean的统一前置后置处理而不是基于某一个bean
 *
 * 执行顺序:
 * Spring IOC容器实例化Bean
 * 调用BeanPostProcessor的postProcessBeforeInitialization方法
 * 调用bean实例的初始化方法
 * 调用BeanPostProcessor的postProcessAfterInitialization方法
 *
 * 注意：接口重写的两个方法不能返回null，如果返回null那么在后续初始化方法将报空指针异常或者通过getBean()方法获取不到bean实例对象
 *
 * 可以注册多个BeanPostProcessor顺序
 * 在Spring机制中可以指定后置处理器调用顺序，通过BeanPostProcessor接口实现类实现Ordered接口getOrder方法，
 * 该方法返回整数，默认值为 0优先级最高，值越大优先级越低
 */
public class CustomBeanPostProcessor implements BeanPostProcessor,Ordered {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("CustomBeanPostProcessor1 postProcessBeforeInitialization beanName="+beanName);

        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("CustomBeanPostProcessor1 postProcessAfterInitialization beanName="+beanName);
        return bean;
    }


    public int getOrder() {
        return 1;
    }
}
