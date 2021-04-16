package com.ligaofei.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;



public class CustomBeanPostProcessor2 implements BeanPostProcessor,Ordered {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("CustomBeanPostProcessor2 postProcessBeforeInitialization beanName="+beanName);

        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("CustomBeanPostProcessor2 postProcessAfterInitialization beanName="+beanName);
        return bean;
    }


    public int getOrder() {
        return 2;
    }
}
