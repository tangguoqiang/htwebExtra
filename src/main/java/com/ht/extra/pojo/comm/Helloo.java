package com.ht.extra.pojo.comm;

public class Helloo {
    private Integer a;

    private String aa;

    private String aaa;

    private String aaaa;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa == null ? null : aa.trim();
    }

    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa == null ? null : aaa.trim();
    }

    public String getAaaa() {
        return aaaa;
    }

    public void setAaaa(String aaaa) {
        this.aaaa = aaaa == null ? null : aaaa.trim();
    }
}