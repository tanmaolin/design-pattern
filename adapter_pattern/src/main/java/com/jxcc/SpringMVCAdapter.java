package com.jxcc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanmaolin
 * @date 2022-09-19 22:07
 */
//适配器就是处理，当变一个对象的时候，这个时候需要调用不同的方法，就可以使用适配器方式
public class SpringMVCAdapter {
}

class DispatchServlet {
    //聚合所有的适配器
    private static List<HandlerAdapter> handlerAdapters = new ArrayList<>();

    {
        handlerAdapters.add(new HttpHanderApater());
        handlerAdapters.add(new SimpleHanderApater());
        handlerAdapters.add(new AnnotationHanderApater());
    }

    public void doDispatch() {
        //此处模拟SpringMVC从请求request中获取handler的对象，
        //适配器可以获取到希望的Controller
        //HttpController controller = new HttpController();
        //SimpleController controller = new SimpleController();
        AnnotationController controller = new AnnotationController();
        //得到对应的适配器
        HandlerAdapter adapter = getHandler(controller);
        //通过适配器执行对应的controller对应方法
        adapter.handler(controller);
    }

    public HandlerAdapter getHandler(Controller controller) {
        for(HandlerAdapter adapter : handlerAdapters) {
            if(adapter.supports(controller)) {
                return adapter;
            }
        }
        return null;
    }
}


interface Controller {

}

class HttpController implements Controller {
    public void doHttpHandler() {

    }
}

class SimpleController implements Controller {
    public void doSimpleHandler() {

    }
}

class AnnotationController implements Controller {
    public void doAnnotationHandler() {

    }
}

interface HandlerAdapter {
    public void handler(Object handler);

    //判断是不是这个对应的handler
    public boolean supports(Object handler);

}

class HttpHanderApater implements HandlerAdapter {

    @Override
    public void handler(Object handler)  {
        ((HttpController)handler).doHttpHandler();
    }

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof HttpController);
    }
}

class SimpleHanderApater implements HandlerAdapter {

    @Override
    public void handler(Object handler) {
        ((SimpleController)handler).doSimpleHandler();
    }

    @Override
    public boolean supports(Object handler) {
        return handler instanceof SimpleController;
    }
}

class AnnotationHanderApater implements HandlerAdapter {

    @Override
    public void handler(Object handler) {
        ((AnnotationController)handler).doAnnotationHandler();
    }

    @Override
    public boolean supports(Object handler) {
        return handler instanceof AnnotationHanderApater;
    }
}