package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.meiju;

/**
 * @author huojianxiong
 * 2021/9/26 10:50
 */
public enum Color {

    /**
     * 爆黄注释
     */
    RED(0, "红色"),
    YELLOW(1, "黄色"),
    GREEN(2, "绿色");

    private int code;
    private String msg;


    Color(int code, String msg) {
        this.code=code;
        this.msg=msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static Color getValue(int code){
        for(Color color : values()){
            if(color.getCode() == code){
                return color ;
            }
        }
        return null;
    }



}
