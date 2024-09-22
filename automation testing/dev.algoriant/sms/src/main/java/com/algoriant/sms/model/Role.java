package com.algoriant.sms.model;
public class Role {
    private String role;
    private String roleDesc;
    public Role(String role,String roleDesc) {
        this.role=role;
        this.roleDesc=roleDesc;
    }
    public Role() {

    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}