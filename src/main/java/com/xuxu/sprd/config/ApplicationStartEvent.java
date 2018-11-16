package com.xuxu.sprd.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by martea on 2018/10/30.
 */
public class ApplicationStartEvent implements ApplicationListener<ContextRefreshedEvent>{

    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("*****");
    }


}
