package com.qsp.banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.banking_management_system.dto.Account;
import com.qsp.banking_management_system.dto.Card;
import com.qsp.banking_management_system.dto.Customer;
import com.qsp.banking_management_system.dto.Loan;
import com.qsp.banking_management_system.repo.CustomerRepo;
@Repository
public class CustomerDao {
	@Autowired
	CustomerRepo customerRepo;
	@Autowired 
	AccountDao accountDao;
	@Autowired
	CardDao cardDao;
	@Autowired
	LoanDao loanDao;
	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	public Customer fetchCustomerById(int customerId) {
		Optional<Customer> customer= customerRepo.findById(customerId);
		if(customer.isPresent()) {
			return customer.get();
		}
		else {
			return null;
		}
	}
	public Customer upateCustomerById(int oldId, Customer newCustomer) {
		newCustomer.setCustomerId(oldId);
		return customerRepo.save(newCustomer);
	}
	public Customer deleteCustomerById(int customerId) {
		Customer customer=customerRepo.findById(customerId).get();
		customerRepo.delete(customer);
		return customer;
	}
	public List<Customer> fetchAllCustomers() {
		return customerRepo.findAll();
	}
	public Customer addExistingAccountToExistingCustomer(int accountId , int customerId) {
		Customer customer=fetchCustomerById(customerId);
		Account account= accountDao.fetchAccountById(accountId);
		List<Account> list=customer.getAccounts();
		list.add(account);
		customer.setAccounts(list);
		return saveCustomer(customer);
	}
	public Customer addNewAccountToExistingCustomer( int customerId , Account newAccount) {
		Customer customer=fetchCustomerById(customerId);
		List<Account> list=customer.getAccounts();
		list.add(newAccount);
		customer.setAccounts(list);
		return saveCustomer(customer);
	}
	public Customer addExistingCardToExistingCustomer(int cardId , int customerId) {
		Customer customer=fetchCustomerById(customerId);
		Card card= cardDao.fetchCardById(cardId);
		List<Card> list=customer.getCards();
		list.add(card);
		customer.setCards(list);
		return saveCustomer(customer);
	}
	public Customer addNewCardExistingCustomer( int customerId , Card newCard) {
		Customer customer=fetchCustomerById(customerId);
		List<Card> list=customer.getCards();
		list.add(newCard);
		customer.setCards(list);
		return saveCustomer(customer);
	}
	public Customer addExistingLoanToExistingCustomer(int loanId , int customerId) {
		Customer customer=fetchCustomerById(customerId);
		Loan loan= loanDao.fetchLoanById(loanId);
		List<Loan> list=customer.getLoans();
		list.add(loan);
		customer.setLoans(list);
		return saveCustomer(customer);
	}
	public Customer addNewLoanExistingCustomer( int customerId , Loan newLoan) {
		Customer customer=fetchCustomerById(customerId);
		List<Loan> list=customer.getLoans();
		list.add(newLoan);
		customer.setLoans(list);
		return saveCustomer(customer);
	}

}
