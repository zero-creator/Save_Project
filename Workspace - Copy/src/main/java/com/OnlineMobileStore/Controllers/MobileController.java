package com.OnlineMobileStore.Controllers;

import com.OnlineMobileStore.Exceptions.MobileNotFoundException;
import com.OnlineMobileStore.Services.MobileService;
import com.OnlineMobileStore.entities.MobileModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/MobileModel")
@CrossOrigin(origins = "http://localhost:3000")
public class MobileController {
    @Autowired
    MobileService mobileService;

    @PostMapping("/addMobile")
    public MobileModel addProduct(@RequestBody MobileModel product) {
        return mobileService.addMobile(product);
    }
    @GetMapping("/Mobiles")
    public List<MobileModel> findAllMobiles() {
        return mobileService.showAllMobile();
    }
    @GetMapping("/mobileById/{id}")
    public MobileModel findProductById(@PathVariable int id) {
        return mobileService.showMobileById(id);
    }

    @PutMapping("/update")
    public MobileModel updateProduct(@RequestBody MobileModel product) throws MobileNotFoundException {
        return mobileService.updateMobile(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) throws MobileNotFoundException{
        return mobileService.deleteMobile(id);
    }

    @GetMapping("/search/{name}")
    public List<MobileModel> showmobileByName(@PathVariable String name) {
        return mobileService.showAllMobileByName(name);
    }

}
