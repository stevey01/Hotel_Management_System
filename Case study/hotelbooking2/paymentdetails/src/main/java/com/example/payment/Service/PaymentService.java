package com.example.payment.Service;

import java.util.List;




import com.example.payment.model.Payment;


public interface PaymentService {
	List<Payment> getAllpayments();
	Payment createpayment(Payment payment);
	
	void deletepayment( Long id);
	Payment updatepayment(Long id, Payment paymentdetails);
	Payment getpaymentbyid(Long id);
	
	
	
	
	
	
}
