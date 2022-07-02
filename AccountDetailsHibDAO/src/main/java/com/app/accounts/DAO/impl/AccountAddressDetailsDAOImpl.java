package com.app.accounts.DAO.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.accounts.DAO.AccountAddressDetailsDAO;
import com.app.accounts.db.utils.HibernateUtils;
import com.app.accounts.entity.AccountAddressDetails;

public class AccountAddressDetailsDAOImpl implements AccountAddressDetailsDAO {

	public AccountAddressDetails getAccountAddressDetailsByProfileId(Integer profileId) {
		System.out.println("Start:getAccountAddressDetailsByProfileId()");
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			AccountAddressDetails accountAddressDetails=session.get(AccountAddressDetails.class,profileId);
			transaction.commit();
			return accountAddressDetails;
		} catch (Exception e) {
			e.printStackTrace();
			if( transaction != null )
				transaction.rollback();
		}finally {
			
			if( session != null ){
				session.close();
			}
		}
		System.out.println("End:getaccountAddressDetailsByLoginId()");
		return null;
	}

	public AccountAddressDetails getAccountAddressDetailsByAddressId(Integer addressId) {
		System.out.println("Start:getAccountAddressDetailsByAddressId()");
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			AccountAddressDetails accountAddressDetails=session.get(AccountAddressDetails.class,addressId);
			transaction.commit();
			return accountAddressDetails;
		} catch (Exception e) {
			e.printStackTrace();
			if( transaction != null )
				transaction.rollback();
		}finally {
			
			if( session != null ){
				session.close();
			}
		}
		System.out.println("End:getaccountAddressDetailsByAddressId()");
		return null;
	}
	public AccountAddressDetails saveAccountAddressDetails(AccountAddressDetails accountAddressDetails){
		System.out.println("START : saveaccountAddressDetails()");
		
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(accountAddressDetails);
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if( transaction != null )
				transaction.rollback();
		}finally {
			
			if( session != null ){
				session.close();
			}
		}
		System.out.println("END : saveaccountAddressDetails()");
		
		return accountAddressDetails;
		
	}

	public AccountAddressDetails saveOrUpdateAccountAddressDetails(AccountAddressDetails accountAddressDeails) {
		System.out.println("START : saveaccountAddressDetails()");
		
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(accountAddressDeails);
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if( transaction != null )
				transaction.rollback();
		}finally {
			
			if( session != null ){
				session.close();
			}
		}
		System.out.println("END : saveaccountAddressDetails()");
		
		return accountAddressDeails;
	}

}
