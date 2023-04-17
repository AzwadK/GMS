package main;

public class course {

    String c_name;
    String section;
    String ct1;
    String ct2;
    String ct3;
    String mid;
    String att;
    String assign;
    String fin;


    public course(String c_name, String section, String ct1, String ct2, String ct3, String mid, String att,String assign, String fin ){
        this.c_name = c_name;
        this.section = section;
        this.ct1 = ct1;
        this.ct2 = ct2;
        this.ct3 = ct3;
        this.mid = mid;
        this.att = att;
        this.assign = assign;
        this.fin = fin;

    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getCt2() {
        if(ct2 != null)
            return ct2;
        else {
            return "0";
        }
    }

    public void setCt2(String ct2) {
        this.ct2 = ct2;
    }

    public String getCt3() {
        if (ct3 != null){
        return ct3;}
        else {
            return "0";
        }
    }

    public void setCt3(String ct3) {
        this.ct3 = ct3;
    }

    public String getMid() {
        if(mid != null) {
            return mid;
        }
        else {
            return "0";
        }
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getAtt() {
        if(att != null) {
            return att;
        }else {
            return "0";
        }
    }

    public void setAtt(String att) {
        this.att = att;
    }

    public String getFin() {
        if(fin != null) {
            return fin;
        }else {
            return "0";
        }
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getAssign() {
        if(assign != null) {
            return assign;
        }else {
            return "0";
        }
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    public String getCt1(){
        if(ct1 != null)
            return ct1;
        else {
            return "0";
        }
    }

    public void setCt1(String ct1) {
        this.ct1 = ct1;
    }
}
