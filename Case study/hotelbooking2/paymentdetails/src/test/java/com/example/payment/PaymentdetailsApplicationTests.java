package com.example.payment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.example.payment.Service.PaymentService;

import com.example.payment.model.Payment;
import com.example.payment.repository.PaymentRepository;


@SpringBootTest
class PaymentdetailsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	PaymentService paymentservice;
	
	@MockBean
	PaymentRepository paymentRepository;
	
	@Test
	public void getallpayment()
	{
		when(paymentRepository.findAll()).thenReturn(Stream.of(new Payment((long) 1,"sam",365384065,"chef",56,"sam@gmail.com")).collect(Collectors.toList()));
	
	assertEquals(1,paymentservice.getAllpayments().size());
	}
	@Test
public void savepayment()
{
Payment  payment=new Payment((long) 1,"sam",365384065,"chef",56,"sam@gmail.com");
	when(paymentRepository.save(payment)).thenReturn(payment);
	
	assertEquals(payment,paymentservice.createpayment(payment));
}
	@Test
	public void deletepayment()
	{
	     Long id = 1L;
	     Payment  payment=new Payment((long) 1,"sam",365384065,"chef",56,"sam@gmail.com");
payment.setId(id);



	        when(paymentRepository.findById(id)).thenReturn(Optional.of(payment));

	        paymentservice.deletepayment(id);

	        verify(paymentRepository,times(1)).delete(payment);
	}
	   @Test
	    void updatepayment() {
		   Payment payments= new Payment((long) 1,"sam",365384065,"chef",56,"sam@gmail.com");
	        Long id = 1L;

	       
	        Payment payment = new Payment();
	        Payment existingPayment = new Payment();
	        existingPayment.setId(id);
	        when(paymentRepository.findById(id)).thenReturn(Optional.of(existingPayment));
	        when(paymentRepository.save(existingPayment)).thenReturn(existingPayment);	      
	        Payment updatedPayment = paymentservice.updatepayment(id,payment);
	        assertEquals(payment.getCard_holder_name(), updatedPayment.getCard_holder_name());
	        assertEquals(payment.getAmount(), updatedPayment.getAmount());
	      
	    }
	   @Test
	   void getguestbyid()
	   {
		   Payment payments= new Payment((long) 1,"sam",365384065,"chef",56,"sam@gmail.com");
	        Long id = 1L;
	       payments.setId(id);
	      
	       when(paymentRepository.findById(id)).thenReturn(Optional.of(payments));

	       Payment retrievedPayment = paymentservice.getpaymentbyid(id);

	       
	       assertEquals(payments.getId(), retrievedPayment.getId());
	       
	   }

	   

}
