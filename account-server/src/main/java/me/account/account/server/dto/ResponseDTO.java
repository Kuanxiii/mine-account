package me.account.account.server.dto;


import java.io.Serializable;

public class ResponseDTO< D > implements Serializable {
    /**
     * 接口响应状态码
     */
    private String returnCode = "0";
    /**
     * 接口响应信息
     */
    private String msg = "success";
    /**
     * 接口响应数据
     */
    private D data;

    public D getData() {
        return data;
    }

    public void setData( D data ) {
        this.data = data;
    }
}
