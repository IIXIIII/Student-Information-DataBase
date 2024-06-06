package com.example.demo;

public class Response <T> {

    private T data;
    private Boolean success;
    private String errMessage;

    /**
     * return all true and pass
     * @param data
     * @return
     * @param <K>
     */
    public static <K> Response<K> newSuccess(K data ){
        Response<K> response = new Response<>();
        response.setData(data);
        response.setSuccess(true);
        response.setErrMessage(null);
        return response;
    }

    /**
     * return all fail
     * @return
     */
    public static Response<Void> newFail(String errMessage){
        Response<Void> response = new Response<>();
        response.setSuccess(false);
        response.setErrMessage(errMessage);
        return response;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
