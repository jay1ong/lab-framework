package com.im.core.strategy;

import cn.hutool.core.util.ReflectUtil;
import com.im.core.enums.StrategyException;
import com.im.core.exception.BizException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/12
 */
@Service
@AllArgsConstructor
public class StrategyService<I extends IStrategy<T>, T> {

    private final ApplicationContext context;

    @SneakyThrows
    public I getStrategy(T param) {
        Class<?> clazz = Class.forName("org.example.strategy.IStrategy");
        Map<String, Object> map = context.getBeansWithAnnotation(Strategy.class);
        for (Object o : map.values()) {
            Method[] methods = ReflectUtil.getMethods(o.getClass());
            Optional<Method> optionalMethod = Arrays.stream(methods).filter(it -> clazz.getMethods()[0].getName().equals(it.getName())).findFirst();
            if (optionalMethod.isPresent()) {
                Method method = optionalMethod.get();
                Optional<Class<?>> classOptional = Arrays.stream(method.getParameterTypes()).sorted().filter(it -> it.isInstance(param)).findFirst();
                if (classOptional.isPresent() && ((I) o).match(param)) {
                    return ((I) o);
                }
            }
        }
        throw new BizException(StrategyException.STRATEGY_NOT_FOUND);
    }

}
