package com.hqgml.domian;

import lombok.Data;

//旅客
@Data
public class Traveller {
    private String id;
    private String name;
    private String sex;
    private String phoneNum;
    private Integer credentialsType;
    private String credentialsTypeStr;  //证件类型 0身份证 1护照 2军官证
    private String credentialsNum;
    private Integer travellerType;  //旅客类型(人群) 0 成人 1 儿童
    private String travellerTypeStr;

    public String getCredentialsTypeStr() {
        if (credentialsTypeStr == null) {
            if (credentialsType == 0) {
                credentialsTypeStr = "身份证";
            } else if (credentialsType == 1) {
                credentialsTypeStr = "护照";

            } else if (credentialsType == 2) {
                credentialsTypeStr = "军官证";
            }

        }
        return credentialsTypeStr;
    }

    public String getTravellerTypeStr() {
        if (travellerTypeStr==null){
            if (travellerType==0){
                travellerTypeStr="成人";
            }else if (travellerType==1){
                travellerTypeStr="儿童";
            }
        }
        return travellerTypeStr;
    }
}
