package me.account.account.server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> implements Serializable {
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
    private T data;
}
