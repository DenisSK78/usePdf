package work.usepdf.service.anotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import work.usepdf.service.LogUpdateService;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoggingUpdateAnnotationPostBeenProcessor implements BeanPostProcessor {

    @Autowired
    private LogUpdateService logUpdateService;

    private Map<String, Class<?>> beanClasses = new HashMap<>();
    private List<String> methodsName = new ArrayList<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Method[] declaredMethods = beanClass.getDeclaredMethods();
        for (Method method : declaredMethods){
            if (method.isAnnotationPresent(LogUpdate.class)){
                beanClasses.put(beanName, beanClass);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = beanClasses.get(beanName);
        if (beanClass != null) {
            Method[] declaredMethods = beanClass.getDeclaredMethods();
            for (Method methodAnnotation : declaredMethods){
                if (methodAnnotation.isAnnotationPresent(LogUpdate.class)){
                    methodsName.add(methodAnnotation.getName());
                    return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method, args) -> {
                        Object original = method.invoke(bean, args);
                        for (String str : methodsName){
                            if (str.equals(method.getName())){
                                Class<?>[] parameters = method.getParameterTypes();
                                for (Class<?> cl: parameters){
                                    for (Field field : cl.getDeclaredFields()){
                                        System.out.println(field.getType() + " : " + field.getName());


                                    }
                                }
                            }
                        }
                        return original;
                    });
                }
            }
        }
        return bean;
    }


}
