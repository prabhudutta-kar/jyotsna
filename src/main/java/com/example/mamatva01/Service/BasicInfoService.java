package com.example.mamatva01.Service;

import com.example.mamatva01.model.BasicInfo;


public interface BasicInfoService {
    public BasicInfo createBasicInfo(BasicInfo theBasicInfo);
    public boolean checkId(int motherId);
}
