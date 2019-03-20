package work.usepdf.service.anotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import work.usepdf.service.LogUpdateService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LoggingUpdateAnnotationPostBeenProcessor implements BeanPostProcessor {

    @Autowired
    private LogUpdateService logUpdateService;

    @PersistenceContext
    private EntityManager entityManager;

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
                        for (String str : methodsName){
                            if (str.equals(method.getName())){
                                Class<?>[] parameters = method.getParameterTypes();
                                Class<?> cl = parameters[0];
                                Method[] methods = cl.getMethods();
                                List<Method> methodList = Arrays.stream(methods)
                                        .filter(e -> e.getName().contains("get"))
                                        .collect(Collectors.toList());
                                Method m = cl.getMethod("getId");
                                Object nObj = args[0];
                                Object oObj = entityManager.find(cl, m.invoke(nObj));
                                Map<String, Object> diffMap = getDifference(oObj, nObj, methodList);
                                //toDo: this you can write in db or log!
                                System.out.println(diffMap);
                                System.out.println("------------------------------------------------------------------------------------------------");

                            }
                        }
                        return method.invoke(bean, args);
                    });
                }
            }
        }
        return bean;
    }

    /**
     * @return Map with key: nameField value: value this field
     * with has changes
     */
    private Map<String, Object> getDifference(Object oObj, Object nObj, List<Method> methodList) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Map<String, Object> diffMap = new HashMap<>();
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println(oObj);
        System.out.println(nObj);
        for (Method method : methodList){
          Object oVal = method.invoke(oObj);
          Object nVal = method.invoke(nObj);
          if(nObj == null || oVal == null) {
              if (nVal != oVal) {
                  diffMap.put(method.getName(), nVal);
              }
              //for object from our package model
          } else if (nVal.getClass().getPackage().getName().contains("work.usepdf.model.")){
              Method mNObjGetId = nObj.getClass().getMethod("getId");
              Method mOObjGetID = oObj.getClass().getMethod("getId");
              Object clNObj = mNObjGetId.invoke(nObj);
              Object clOObj = mOObjGetID.invoke(oObj);
              if (clNObj != clOObj){
                  diffMap.put(method.getName(), nVal);
              }
          } else if (!oVal.equals(nVal)){
              diffMap.put(method.getName(), nVal);
          }
        }
        return diffMap;
    }
}
