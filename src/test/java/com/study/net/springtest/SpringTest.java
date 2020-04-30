package com.study.net.springtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.ClassUtils;

import java.io.IOException;

/**
 * @description:
 * @author: zjt
 * @date: 2020-04-29 22:50
 */
public class SpringTest {

    @Test
    public void testResource() throws IOException {

        ClassLoader defaultClassLoader = ClassUtils.getDefaultClassLoader();

        ResourceLoader resourceLoader = new DefaultResourceLoader();

        Resource fileResource1 = resourceLoader.getResource("D:/Users/chenming673/Documents/spark.txt");
        System.out.println("fileResource1 is FileSystemResource:" + (fileResource1 instanceof FileSystemResource));

        Resource fileResource2 = resourceLoader.getResource("/Users/chenming673/Documents/spark.txt");
        System.out.println("fileResource2 is ClassPathResource:" + (fileResource2 instanceof ClassPathResource));

        Resource urlResource1 = resourceLoader.getResource("file:/Users/chenming673/Documents/spark.txt");
        System.out.println("urlResource1 is UrlResource:" + (urlResource1 instanceof UrlResource));

        Resource urlResource2 = resourceLoader.getResource("http://www.baidu.com");
        System.out.println("urlResource1 is urlResource:" + (urlResource2 instanceof  UrlResource));

        Resource resource = resourceLoader.getResource("classpath:application.yml");
        System.out.println("resource = " + resource.getFile().getPath());
    }

    @Test
    public void testResolver() throws IOException {

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:org/apache/commons/logging/*.class");
        resources = resolver.getResources("classpath*:com/alibaba/dubbo/rpc/filter/**/*.class");

    }

    @Test
    public void testAll(){
        ClassPathResource resource = new ClassPathResource("bean.xml"); // <1>
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory(); // <2>
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory); // <3>
        reader.loadBeanDefinitions(resource); // <4>
    }

}