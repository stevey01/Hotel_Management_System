package com.example.payment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment.Service.PaymentService;

import com.example.payment.model.Payment;


import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/hms/v3/")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	
	 
	@GetMapping("/payment")
	public List<Payment> getAllPayment()
	{
		log.info("Inside the GetallPayment method of Controller");
		 log.info("Retrieving AllPayment Data ");
	 return paymentService.getAllpayments();
	}
	
	@PostMapping("/payment")
	public ResponseEntity<Payment>  createpayment(@RequestBody  @Valid Payment payment)
	{
		 paymentService.createpayment(payment);
		  log.info("Inside the createpayment() method of controller");
			log.info("Adding Payment "+payment);
		 return ResponseEntity.ok(payment);
		 
	}
	
	@PutMapping("/payment/{id}")
	public ResponseEntity<Payment> updatepayment(@PathVariable Long id,@Valid @RequestBody Payment paymentdetails)
	{
		
		 paymentService.updatepayment(id, paymentdetails);
		 log.info("Inside the updatePayment() method of controller");
		 log.info("Updating payment Data by id ");
	        return ResponseEntity.ok(paymentdetails);
		
	}
	@DeleteMapping("/payment/{id}")
	public ResponseEntity<Map<String, Boolean>> deletepayment(@PathVariable Long id)  {
	         paymentService.deletepayment(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		log.info("Inside the deletepayment() method of controller");
		 log.info("Deleting A payment successfully ");
	
		return ResponseEntity.ok(response);
	}
	@GetMapping("/payment/{id}")
	public ResponseEntity<Payment>  getpaymentbyid(@PathVariable Long id)
	{
		 Payment payment = paymentService.getpaymentbyid(id);
		 log.info("Inside the getPaymentbyid() method of controller");
		 log.info("Retrieving Payment Details by Id ");
	        return ResponseEntity.ok(payment);
	}

	
	
}
