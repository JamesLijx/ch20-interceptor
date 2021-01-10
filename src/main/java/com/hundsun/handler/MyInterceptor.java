package com.hundsun.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

//拦截器类：拦截用户的请求
public class MyInterceptor implements HandlerInterceptor {
    //初始化开始时间属性
    private long btime = 0;
    /**
     * preHandle:预处理方法
     *      重要：是整个项目的入口，门户。当preHandler返回true，请求可以被处理。
     *      当preHandler返回false，请求到此方法就截止。
     * @param request
     * @param response
     * @param handler：被拦截的控制器对象
     * @return
     * @throws Exception
     *
     * 特点：
     *  1.方法在控制器方法之前先执行的
     *      用户的请求首先到达此方法
     *  2.在这个方法中可以获取请求的信息，验证请求是否符合要求。
     *      可以验证用户是否登录，验证用户是否有权限访问某个连接地址。
     *      如果验证失败，可以截断请求，请求不能处理。
     *      如果验证成功，可以放行请求，此时控制器方法才能执行。
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //把preHandler方法开始执行的时间进行记录
        btime = System.currentTimeMillis();
        System.out.println("拦截器的preHandle()");
            return true;
    }

    /**
     * postHandle:后处理方法
     * @param request
     * @param response
     * @param handler 被拦截的处理器对象
     * @param modelAndView 处理器方法的返回值
     * @throws Exception
     *
     * 特点：
     *  1）在处理器方法之后执行的
     *  2）能够获取到处理器方法的返回值ModelAndView,可以修改ModelAndView中
     *  的数据和视图，可以影响到最后的执行结果。
     *  3）主要是对原来的执行结果做二次修正。
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器的postHandle()");
        //对原来的doSome()执行结果进行调整
        if (modelAndView != null){
            //修改数据
            modelAndView.addObject("myDate",new Date());
            //修改视图
            modelAndView.setViewName("other");
        }
    }

    /**
     * afterCompletion 最后执行的方法
     * @param request
     * @param response
     * @param handler 被拦截器的处理对象
     * @param ex 程序中发生的异常
     * @throws Exception
     *
     * 特点：
     *    1.在请求处理完成之后执行的。框架中规定是当你的视图处理完成后，对视图执行了forward，就认为请求处理完成了。
     *    2.一般是用来做资源回收工作的，程序请求过程中创建了一些对象，在这里可以删除，把占用的内存回收。
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        //执行afterCompletion方法的时间
        long endTime = System.currentTimeMillis();
        System.out.println("拦截器的afterCompletion");
        //打印从preHandler方法到afterCompletion方法中间的耗费时间:单位 毫秒
        System.out.println("从preHandler方法到afterCompletion方法中间耗费的时间:"+(endTime-btime));
    }
}
