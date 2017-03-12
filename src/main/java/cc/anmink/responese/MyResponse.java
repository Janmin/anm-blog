package cc.anmink.responese;

/**
 * Created by Jamin on 2017/3/11.
 */
public class MyResponse<T> {
    private Integer ret;
    private String msg;
    private T data;

    public MyResponse(Integer ret, String msg, T data){
        this.ret = ret;
        this.msg = msg;
        this.data = data;
    }

    public Integer getRet() {
        return ret;
    }

    public void setRet(Integer ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
