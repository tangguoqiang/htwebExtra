package com.ht.extra.pojo.insurance;

import java.math.BigDecimal;

public class InsuranceInterfaceDict {
    private String interfacecode;

    private String interfacename;

    private String interfacetype;

    private String outpflag;

    private String inpflag;

    private String interfaceobj;

    private BigDecimal marks;

    private String description;

    public String getInterfacecode() {
        return interfacecode;
    }

    public void setInterfacecode(String interfacecode) {
        this.interfacecode = interfacecode == null ? null : interfacecode.trim();
    }

    public String getInterfacename() {
        return interfacename;
    }

    public void setInterfacename(String interfacename) {
        this.interfacename = interfacename == null ? null : interfacename.trim();
    }

    public String getInterfacetype() {
        return interfacetype;
    }

    public void setInterfacetype(String interfacetype) {
        this.interfacetype = interfacetype == null ? null : interfacetype.trim();
    }

    public String getOutpflag() {
        return outpflag;
    }

    public void setOutpflag(String outpflag) {
        this.outpflag = outpflag == null ? null : outpflag.trim();
    }

    public String getInpflag() {
        return inpflag;
    }

    public void setInpflag(String inpflag) {
        this.inpflag = inpflag == null ? null : inpflag.trim();
    }

    public String getInterfaceobj() {
        return interfaceobj;
    }

    public void setInterfaceobj(String interfaceobj) {
        this.interfaceobj = interfaceobj == null ? null : interfaceobj.trim();
    }

    public BigDecimal getMarks() {
        return marks;
    }

    public void setMarks(BigDecimal marks) {
        this.marks = marks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}