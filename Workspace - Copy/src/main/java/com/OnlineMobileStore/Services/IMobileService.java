package com.OnlineMobileStore.Services;

import com.OnlineMobileStore.Exceptions.MobileNotFoundException;
import com.OnlineMobileStore.entities.MobileModel;

import java.util.List;

public interface IMobileService {
    public MobileModel addMobile(MobileModel mobile);
    public MobileModel updateMobile(MobileModel mobile) throws MobileNotFoundException;
    public String deleteMobile(int id) throws MobileNotFoundException;
    public List<MobileModel> showAllMobile();
    public MobileModel showMobileById(int mobileId);
    public List<MobileModel> showAllMobileByName(String MobileName);
}
