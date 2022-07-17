package com.OnlineMobileStore.Services;

import com.OnlineMobileStore.Exceptions.MobileNotFoundException;
import com.OnlineMobileStore.Repositories.ProductRepo;
import com.OnlineMobileStore.entities.MobileModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MobileService implements IMobileService{
    @Autowired
    private ProductRepo productRepo;

    public MobileModel getUserById(int Id) throws MobileNotFoundException { //Need to Change
        Optional<MobileModel> optionalProduct = productRepo.findById(Id);
        if (!optionalProduct.isPresent())
            throw new MobileNotFoundException("Product With this Id Dosn't exist" + Id);
        return optionalProduct.get();
    }

    @Override
    public MobileModel addMobile(MobileModel mobile) {
        return productRepo.save(mobile);
    }



    @Override
    public MobileModel updateMobile( MobileModel mobile) throws MobileNotFoundException {
        Optional<MobileModel> Opti=productRepo.findById(mobile.getMobileId());
        MobileModel mobileModel=Opti.get();
        mobileModel.setMobileCost(mobile.getMobileCost());
        mobileModel.setMobileName(mobile.getMobileName());
        mobileModel.setModelNumber(mobile.getModelNumber());
        mobileModel.setCategory(mobile.getCategory());
        mobileModel.setCompanyName(mobile.getCompanyName());
        mobileModel.setMfd(mobile.getMfd());
        return productRepo.save(mobileModel);
    }

    @Override
    public String deleteMobile(int id) throws MobileNotFoundException {
        productRepo.deleteById(id);
        return "Mobile Deleted !"+ id;
    }

    @Override
    public List<MobileModel> showAllMobile() {
        return productRepo.findAll();
    }

    @Override
    public MobileModel showMobileById(int mobileId) {
        return productRepo.findById(mobileId).get();
    }

    @Override
    public List<MobileModel> showAllMobileByName(String MobileName) {
        return productRepo.findByMobileName(MobileName);
    }





}
