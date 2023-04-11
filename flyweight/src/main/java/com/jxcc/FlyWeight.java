package com.jxcc;

import java.util.HashMap;

/**
 * @author tanmaolin
 * @date 2022-09-29 16:25
 */
public class FlyWeight {
}
//外部享元
class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class WebSiteFactory {
    //集合，充当池的作用
    private HashMap<String, ConcreteWebSite> pool = new HashMap<>();

    //根据网站类型，返回一个网站，如果没有就创建一个网站，并放入到池中，并返回
    public WebSite getWebSitCategory(String type) {
        if(!pool.containsKey(type)) {
            pool.put(type, new ConcreteWebSite(type));
        }
        return (WebSite) pool.get(type);
    }

    //获取网站分了的总数
    public int getWebSiteCount() {
        return pool.size();
    }
}

abstract class WebSite {
    public abstract void use(User user);
}

class ConcreteWebSite extends WebSite {

    private String type = ""; //网站发布的形式

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println(type + user.getName());
    }
}
