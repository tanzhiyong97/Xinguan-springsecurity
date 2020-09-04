package com.tan.response;

public enum ResultCode implements CustomizeResultCode{
    /**
     * 200: 成功
     */
    SUCCESS(20000, "成功"),
    ERROR(20001,"失败"),
    PASS_NOT_CORRECT(3005, "密码不正确！请重新尝试"),
    NOT_LOGIN(3006,"尚未登录！"),
    INTRODUCTION_NOT_FOUND(2005,"没有找到这一条历史信息！有人侵入数据库强制删除了"),
    PAGE_NOT_FOUND(404, "你要请求的页面好像暂时飘走了...要不试试请求其他页面？"),
    USER_NOT_FONUD(3007, "用户不存在"),
    INTERNAL_SERVER_ERROR(500,"服务器冒烟了...要不等它降降温后再来访问？"),
    UNKNOWN_SERVER_ERROR(2001, "未知异常，请联系管理员！")
    ;

    private Integer code;
    private String message;

    ResultCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
