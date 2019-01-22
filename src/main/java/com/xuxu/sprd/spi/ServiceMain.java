package com.xuxu.sprd.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @auther chen.haitao
 * @date 2019-01-17
 */
public class ServiceMain {
    public static void main(String[] args) {

        ServiceLoader<DemoService> spiLoader = ServiceLoader.load(DemoService.class);
        Iterator<DemoService> iteratorSpi = spiLoader.iterator();
        while (iteratorSpi.hasNext()) {
            DemoService demoService = iteratorSpi.next();
            demoService.sayHello();

        }
    }
}