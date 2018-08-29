package com.shxseer.watch.common;

/**
 * 接口返回统一对象
 * @author wyf
 * @param <T>
 */
public class InvokeResult<T>{
    /**
     * 状态码
     */
    private int code = Constant.SUCCESS_INT;
    /**
     * 错误信息
     */
    private String message;
    /**
     * 成功时返回的对象
     */
    private T data;

    private String result;

    private String Id;

    private String startTime;

    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {

        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccessed() {
        return code == Constant.SUCCESS_INT;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public static InvokeResult SuccessResult(){
        return new InvokeResult();
    }

    public static <T> InvokeResult SuccessResult(T data){
        InvokeResult<T> result = new InvokeResult<T>();
        result.setData(data);
        return result;
    }

    public static <T> InvokeResult SuccessResult(String message){
        InvokeResult<T> result = new InvokeResult<T>();
        result.setMessage(message);
        return result;
    }

    public static <T> InvokeResult SuccessResult(String message, T data){
        InvokeResult<T> result = new InvokeResult<T>();
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> InvokeResult SuccessResult(String message, T data, Integer count){
        InvokeResult<T> result = new InvokeResult<T>();
        result.setMessage(message);
        result.setData(data);
        result.setCount(count);
        return result;
    }

    public static <T> InvokeResult Fail(String message, int code, T data){
        InvokeResult result =new InvokeResult<T>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static InvokeResult Fail(String message){
        return Fail(message,Constant.ERROR_INT,null);
    }

    public static InvokeResult Fail(String message, int code){
        return Fail(message,code,null);
    }
}
