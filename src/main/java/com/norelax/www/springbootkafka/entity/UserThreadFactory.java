package com.norelax.www.springbootkafka.entity;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class UserThreadFactory implements ThreadFactory {
    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    // 定义线程组名称，在 jstack 问题排查时，非常有帮助
    public UserThreadFactory(String whatFeaturOfGroup) {
        namePrefix = whatFeaturOfGroup + "-Worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null, task, name, 0);
        System.out.println(thread.getName());
        return thread;
    }

    public static void main(String[] args) {
        UserThreadFactory userThreadFactory = new UserThreadFactory("1");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 20, 300, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10000), userThreadFactory);
        threadPoolExecutor.execute(() -> {
            log.info("线程池日志打印。。。");
            System.out.println(">>>>>>>>>");
        });
        threadPoolExecutor.shutdown();

    }
}