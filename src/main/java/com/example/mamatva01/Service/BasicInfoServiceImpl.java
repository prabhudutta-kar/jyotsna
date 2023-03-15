package com.example.mamatva01.Service;

import com.example.mamatva01.model.BasicInfo;
import com.example.mamatva01.model.User;
import com.example.mamatva01.repository.BasicInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicInfoServiceImpl implements BasicInfoService{

    @Autowired
    private BasicInfoRepository basicInfoRepo;

    @Override
    public BasicInfo createBasicInfo(BasicInfo theBasicInfo) {
        return basicInfoRepo.save(theBasicInfo);
    }

    @Override
    public boolean checkId(int motherId) {
        return basicInfoRepo.existsById(motherId);
    }
}
