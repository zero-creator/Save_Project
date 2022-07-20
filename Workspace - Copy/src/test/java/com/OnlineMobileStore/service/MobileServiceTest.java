package com.OnlineMobileStore.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.OnlineMobileStore.Exceptions.MobileNotFoundException;
import com.OnlineMobileStore.Repositories.ProductRepo;
import com.OnlineMobileStore.Services.MobileService;
import com.OnlineMobileStore.entities.MobileModel;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class MobileServiceTest {
    @InjectMocks
    private MobileService mobileService=new MobileService();
    @Mock
    private ProductRepo productRepo;

    @Test
    void testGetProductById() {
        MobileModel product = new MobileModel();
        product.setMobileId(100);
        product.setMobileName("Iphone11");
        product.setMobileCost(50000);
        product.setModelNumber("SE55455");
        product.setCompanyName("Apple");
        product.setCategory(product.getCategory());
        Optional<MobileModel> optionalProduct = Optional.of(product);
        when(productRepo.findById(100)).thenReturn(optionalProduct);
        MobileModel myProduct = mobileService.showMobileById(100);
        assertEquals("Iphone11", myProduct.getMobileName());
    }
    @Test
    void testGetProductByIdWithException() {
        when(productRepo.findById(100)).thenThrow(MobileNotFoundException.class);
        assertThrows(MobileNotFoundException.class,()->mobileService.showMobileById(100));
    }
    @Test
    void testGetAllProducts() {
        MobileModel product = new MobileModel();
        product.setMobileId(100);
        product.setMobileName("Iphone11");
        product.setMobileCost(50000);
        product.setModelNumber("SE55455");
        product.setCompanyName("Apple");
        product.setCategory(product.getCategory());
        MobileModel product2 = new MobileModel();
        product2.setMobileId(200);
        product2.setMobileName("SumsungM32");
        product2.setMobileCost(20000);
        product2.setModelNumber("SE79455");
        product2.setCompanyName("Android");
        product2.setCategory(product2.getCategory());
        MobileModel product3 = new MobileModel();
        product3.setMobileId(300);
        product3.setMobileName("Nokia");
        product3.setMobileCost(60000);
        product3.setModelNumber("SE2672");
        product3.setCompanyName("Android");
        product3.setCategory(product3.getCategory());
        List<MobileModel> productList = new ArrayList<>();
        productList.add(product3);
        productList.add(product2);
        productList.add(product);
        when(productRepo.findAll()).thenReturn(productList);
        List<MobileModel> products = mobileService.showAllMobile();
        assertEquals(3,products.size());
    }
    @Test
    void testSaveProduct() {
        MobileModel product = new MobileModel();
        product.setMobileId(100);
        product.setMobileName("Iphone11");
        product.setMobileCost(50000);
        product.setModelNumber("SE55455");
        product.setCompanyName("Apple");
        product.setCategory(product.getCategory());
        when(productRepo.save(product)).thenReturn(product);
        MobileModel newProduct = mobileService.addMobile(product);
        assertEquals("Iphone11",newProduct.getMobileName());
        verify(productRepo,times(1)).save(product); // useful for testing void methods
    }
    @Test
    void testDeleteProduct() throws MobileNotFoundException {
        MobileModel product = new MobileModel();
        product.setMobileId(100);
        product.setMobileName("Iphone11");
        product.setMobileCost(50000);
        product.setModelNumber("SE55455");
        product.setCompanyName("Apple");
        product.setCategory(product.getCategory());
        Optional<MobileModel> optionalProduct = Optional.of(product);
        when(productRepo.findById(100)).thenReturn(optionalProduct);
        MobileModel myProduct = mobileService.showMobileById(100);
        mobileService.deleteMobile(100);
        verify(productRepo,times(1)).findById(100);
        verify(productRepo,times(1)).deleteById(100);
    }
    @Test
    void testGetProductByName() {
        MobileModel product = new MobileModel();
        product.setMobileId(100);
        product.setMobileName("Iphone11");
        product.setMobileCost(50000);
        product.setModelNumber("SE55455");
        product.setCompanyName("Apple");
        product.setCategory(product.getCategory());
        MobileModel product2 = new MobileModel();
        product2.setMobileId(200);
        product2.setMobileName("Iphone11");
        product2.setMobileCost(20000);
        product2.setModelNumber("SE79455");
        product2.setCompanyName("Android");
        List<MobileModel> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product2);
        when(productRepo.findByMobileName("Iphone11")).thenReturn(productList);
        List<MobileModel> products = mobileService.showAllMobileByName("Iphone11");
        assertEquals(2,products.size());
    }

}
