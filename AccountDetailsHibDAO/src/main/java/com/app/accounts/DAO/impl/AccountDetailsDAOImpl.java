package com.app.accounts.DAO.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.accounts.DAO.AccountDetailsDAO;
import com.app.accounts.db.utils.HibernateUtils;
import com.app.accounts.entity.AccountDetails;

public class AccountDetailsDAOImpl implements AccountDetailsDAO {

	public List<AccountDetails> getAllAccountDetailsByAadharNumber(String aadharNumber) {
		System.out.println("Start:getAccountDetailsByUserNameAadharNumber()");
		Session session = null;
		Transaction transaction = null;
		List<AccountDetails> resp = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
//			String hqlQuery = "Select e from LoginDetails e where e.userName=:empId and userPassword ";
			//String hqlQuery = "Select e from LoginDetails e where e.employeeId=?1 ";
			String hqlQuery = "from AccountDetails  where aadharNumber=:aNumber";
			
			Query query = session.createQuery(hqlQuery);
			//query.setParameter("empId", employeeId);
			query.setString("aNumber", aadharNumber);
			
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
		System.out.println("End:getAccountDetailsByAadharNumber()");
		return null;
	}

	public AccountDetails getAccountDetailsByAccountId(Integer accountId) {
		System.out.println("Start:getAccountDetailsByAccountId()");
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			AccountDetails accountDetails=session.get(AccountDetails.class,accountId);
			transaction.commit();
			return accountDetails;
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

	public AccountDetails saveAccountDetails(AccountDetails accountDetails) {
			System.out.println("START : saveAccountDetails()");
		
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(accountDetails);
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
		System.out.println("END : saveAccountDetails()");
		return accountDetails ;
	}

	

	public AccountDetails saveOrUpdateAccountDetails(AccountDetails accountDetails) {
			System.out.println("START : saveOrUpdateAccountDetails()");
		
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(accountDetails);
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
		return accountDetails ;
	}

	}

