package com.design.design.factory.context;

import com.design.design.factory.bean.BeanConfigParser;
import com.design.design.factory.bean.BeanDefinition;
import com.design.design.factory.bean.BeanFactory;
import com.design.design.factory.bean.XmlBeanConfigParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassPathXmlApplicationContext 负责组装 BeansFactory 和 BeanConfigParser 两个类，串联执行流程：
 * 从 classpath 中加载 XML 格式的配置文件，通过 BeanConfigParser 解析为统一的 BeanDefinition 格式，
 * 然后，BeansFactory 根据 BeanDefinition 来创建对象
 *
 *
配置文件beans.xml
<beans>
    <bean id="rateLimiter" class="com.xzg.RateLimiter">
        <constructor-arg ref="redisCounter"/>
    </bean>

    <bean id="redisCounter" class="com.xzg.redisCounter" scope="singleton" lazy-init="true">
        <constructor-arg type="String" value="127.0.0.1">
        <constructor-arg type="int" value=1234>
    </bean>
</beans>
 */
public class ClassPathXmlApplicationContxt implements ApplicationContext {

    private BeanFactory beanFactory;

    private BeanConfigParser beanConfigParser;

    public ClassPathXmlApplicationContxt(String configLocation){
        this.beanFactory=new BeanFactory();
        this.beanConfigParser=new XmlBeanConfigParser();
    }


    private void loadBeanDefinitions(String configLocation){
        InputStream in=null;
        try {
            in=this.getClass().getResourceAsStream("/"+configLocation);
            if(in==null){
                throw new RuntimeException("Can not find config file:"+configLocation);
            }
            List<BeanDefinition> beanDefinitions=beanConfigParser.parse(in);
            beanFactory.addBeanDefinitions(beanDefinitions);
        }finally {
            if(in!=null){
                try {
                    in.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Object getBean(String beanId) {
        return beanFactory.getClass();
    }
}
