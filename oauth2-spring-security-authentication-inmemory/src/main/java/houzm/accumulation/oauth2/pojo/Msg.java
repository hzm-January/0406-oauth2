package houzm.accumulation.oauth2.pojo;

import java.io.Serializable;

/**
 * Package: houzm.accumulation.oauth2.pojo
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/3 19:22
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： Msg
 */
public class Msg implements Serializable {
    private String title;
    private String content;
    private String etraInfo;

    public Msg(String title, String content, String etraInfo) {
        this.title = title;
        this.content = content;
        this.etraInfo = etraInfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEtraInfo() {
        return etraInfo;
    }

    public void setEtraInfo(String etraInfo) {
        this.etraInfo = etraInfo;
    }
}
