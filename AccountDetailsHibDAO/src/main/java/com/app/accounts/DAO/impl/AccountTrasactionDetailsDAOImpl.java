package com.app.accounts.DAO.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.accounts.DAO.AccountTrasactionDetailsDAO;
import com.app.accounts.db.utils.HibernateUtils;
import com.app.accounts.entity.AccountTrasactionDetails;

public class AccountTrasactionDetailsDAOImpl implements AccountTrasactionDetailsDAO {

	public List<AccountTrasactionDetails> getAllAccountTrasactionDetailsByAccountId(Integer accountId) {
		System.out.println("Start:getAccountTransactionDetailsByAccountId()");
		Session session = null;
		Transaction transaction = null;
		List<AccountTrasactionDetails> resp = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
//			String hqlQuery = "Select e from LoginDetails e where e.userName=:empId and userPassword ";
			//String hqlQuery = "Select e from LoginDetails e where e.employeeId=?1 ";
			String hqlQuery = "from AccountDetails  where accountId=:aId";
			
			Query query = session.createQuery(hqlQuery);
			//query.setParameter("empId", employeeId);
			query.setInteger("aId", accountId);
			
			resp=query.list();
			
			transaction.commit();
			return resp;
		} catch (Exception e) {
			e.printStackTrace();
			if( transaction != null )
				transaction.rollback();
		}finally {
			
			if( session != null ){
				session.close();
			}
		}
		System.out.println("End:getAccountTransactionDetailsByAadharNumber()");
		return null;
	}
	public AccountTrasactionDetails getAccountTrasactionDetailsByTransactionId(Integer transactionId) {
		System.out.println("Start:getAccountTransactionDetailsByTransactionId()");
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			AccountTrasactionDetails accountAddressDetails=session.get(AccountTrasactionDetails.class,transactionId);
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
		System.out.println("End:getAccountTransactionDetailsBy()");
		return null;
	}

	public AccountTrasactionDetails saveAccountTrasactionDetails(AccountTrasactionDetails accountTrasactionDetails) {
			System.out.println("START : saveaccountTransactionDetails()");
		
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(accountTrasactionDetails);
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
		System.out.println("END : saveaccountTransactionDetails()");
		
		return accountTrasactionDetails;
		
	}

	public AccountTrasactionDetails saveOrUpdateAccountTrasactionDetails(AccountTrasactionDetails accountTrasactionDetails) {
				System.out.println("START : saveOrUpdateAccountTransactionDetails()");
		
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(accountTrasactionDetails);
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
		System.out.println("END : saveOrUpdateAccountDetails()");
		return accountTrasactionDetails ;
	}

}
