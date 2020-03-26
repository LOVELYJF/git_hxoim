package com.hxoim.common.hxThread;
/*
 * @description:带队列的线程基类，以队列中的类为参数，循环执行指定类指定方法，以队列中的类为参数，只支持一个参数，多个参数需要封装到一个类中
 * @author 杨波
 * @date:2019-06-24
 */

import java.lang.reflect.Method;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class hxBaseThreadWithQueue<T> extends Thread {
    protected Queue<T> taskQueue = new ConcurrentLinkedDeque<>();
    protected Object targetClass ;
    protected String targetMethod;

    public hxBaseThreadWithQueue(Object target, String method) {
        targetClass = target;
        targetMethod = method;
    }

    /**
     * @description:线程中队列中未处理任务数量
     * @author:杨波
     * @date:2019-06-24 * @param null
     * @return:
     **/
    public long QueueCount() {
        return taskQueue.size();
    }

    /**
     * @description:往队列中添加元素
     * @author:杨波
     * @date:2019-06-24 * @param T
     * @return:
     **/
    public boolean Offer(T t) {
        return taskQueue.offer(t);
    }

    /**
     * @description:从队列中取出第一个元素
     * @author:杨波
     * @date:2019-06-24 * @param null
     * @return:
     **/
    public T Poll() {
        return taskQueue.poll();
    }

    //执行线程
    @Override
    public void run() {
        //目标类和方法为空，该线程不执行
        if (targetClass == null) return;
        if (targetMethod == null || targetMethod.isEmpty()) return;

        while (this.isAlive()) {
            T arg = Poll();
            if (arg == null) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            try {
                Method method = targetClass.getClass().getMethod(targetMethod, arg.getClass());
                try {
                    method.invoke(targetClass,arg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }
}
