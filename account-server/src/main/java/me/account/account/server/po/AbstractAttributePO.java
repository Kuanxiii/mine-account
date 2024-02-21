package me.account.account.server.po;


public abstract class AbstractAttributePO {

    protected Integer userId;

    protected String attributeName;

    protected String attributeDesc;

    protected Boolean rigidDemand;

    protected String remark;

    public AbstractAttributePO() {
    }

    public AbstractAttributePO(Integer userId, String attributeName, String attributeDesc, Boolean rigidDemand, String remark) {
        this.userId = userId;
        this.attributeName = attributeName;
        this.attributeDesc = attributeDesc;
        this.rigidDemand = rigidDemand;
        this.remark = remark;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName == null ? null : attributeName.trim();
    }

    public String getAttributeDesc() {
        return attributeDesc;
    }

    public void setAttributeDesc(String attributeDesc) {
        this.attributeDesc = attributeDesc == null ? null : attributeDesc.trim();
    }

    public Boolean getRigidDemand() {
        return rigidDemand;
    }

    public void setRigidDemand(Boolean rigidDemand) {
        this.rigidDemand = rigidDemand;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

}
