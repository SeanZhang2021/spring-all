package org.sean.proxy;

public class ResultBody {

    private String code;
    private String msg;

    public ResultBody(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResultBody{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
