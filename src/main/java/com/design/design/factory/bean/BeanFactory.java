package com.design.design.factory.bean;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * putIfAbsent在放入数据时，如果存在重复的key，那么putIfAbsent不会放入值
 *
 * BeanFactory 创建对象用到的主要技术点就是Java中的反射语法：一种动态加载类和创建对象的机制
 */
public class BeanFactory {
    /**
        如果对象的scope属性是singleton，那么对象创建之后会缓存在singletonObjects这样的一个map中
        下次在请求此对象的时候，直接从map中取出返回，不需要重新创建

        如果对象scope属性是prototype，那么每次请求丢向，BeanFactory都会创建一个新的对象返回
     */
    private ConcurrentHashMap<String,Object> singletonObjects=new ConcurrentHashMap<>();
    private ConcurrentHashMap<String,BeanDefinition> beanDefinitions=new ConcurrentHashMap<>();

    public void addBeanDefinitions(List<BeanDefinition> beanDefinitionList){
        //循环遍历解析出来后的beanDefinitions列表对象
        for (BeanDefinition beanDefinition:beanDefinitionList){
            //讲beanDefinition加入到Map中，id作为键值
            this.beanDefinitions.putIfAbsent(beanDefinition.getId(),beanDefinition);
        }

        for (BeanDefinition beanDefinition:beanDefinitionList){
            if(beanDefinition.isLazyInit()==false && beanDefinition.isSingleton()){
                createBean(beanDefinition); //创建Bean对象
            }
        }
    }

    public Object getBean(String beanId){
        BeanDefinition beanDefinition=beanDefinitions.get(beanId);
        if (beanDefinition == null) {
            throw new NoSuchBeanDefinitionException("Bean is not defined: " + beanId);
        }
        return createBean(beanDefinition);
    }
 

    protected Object createBean(BeanDefinition beanDefinition){
        if(beanDefinition.isSingleton() && singletonObjects.contains(beanDefinition)){
            return singletonObjects.get(beanDefinition.getId());
        }
        Object bean=null;
        try {
            Class beanClass=Class.forName(beanDefinition.getClassName());
            List<BeanDefinition.ConstructorArg> args=beanDefinition.getConstructorArgs();
            if(args.isEmpty()){
                bean=beanClass.newInstance();
            }else {
                Class[] argClasses=new Class[args.size()];
                Object[] argObjects=new Object[args.size()];
                for (int i=0;i<args.size();i++){
                    BeanDefinition.ConstructorArg arg=args.get(i);
                    if(!arg.getIsRef()){
                        argClasses[i] = arg.getType();
                        argObjects[i] = arg.getArg();
                    }else{
                        BeanDefinition refBeanDefinition=beanDefinitions.get(arg.getArg());
                        if (refBeanDefinition == null) {
                            throw new NoSuchBeanDefinitionException("Bean is not defined: " + arg.getArg());
                        }
                        argClasses[i] = Class.forName(refBeanDefinition.getClassName());
                        argObjects[i] = createBean(refBeanDefinition);
                    }
                }
                bean = beanClass.getConstructor(argClasses).newInstance(argObjects);
            }
        }catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e){
            throw new RuntimeException("", e);
        }
        if (bean != null && beanDefinition.isSingleton()) {
            singletonObjects.putIfAbsent(beanDefinition.getId(), bean);
            return singletonObjects.get(beanDefinition.getId());
        }
        return bean;
    }
}
