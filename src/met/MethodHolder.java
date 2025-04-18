package met;

public class MethodHolder {
    public String met1(String s){
        return "public method prints : " + s;
    }
    private String met2(String s){
        return "private method prints : " + s;
    }
    protected String met3(String s){
        return "protected method prints : " + s;
    }
    String met4(String s){
        return "method prints : " + s;
    }
}
