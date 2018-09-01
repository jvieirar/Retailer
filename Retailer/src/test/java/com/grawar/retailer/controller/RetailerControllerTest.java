package com.grawar.retailer.controller;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.grawar.retailer.model.RetailerModel;

@RunWith(SpringRunner.class)
@WebMvcTest(RetailerController.class)
public class RetailerControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private RetailerController retailerController;

	@Test
	public void getBarcodes() {
		RetailerModel retailerModel = new RetailerModel();
		retailerModel.setBarcode(5);
	}

}
