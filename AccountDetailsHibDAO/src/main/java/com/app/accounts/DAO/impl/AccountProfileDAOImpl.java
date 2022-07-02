package com.app.accounts.DAO.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.accounts.DAO.AccountProfileDAO;
import com.app.accounts.db.utils.HibernateUtils;
import com.app.accounts.entity.AccountProfile;

public class AccountProfileDAOImpl implements AccountProfileDAO {

	public AccountProfile getAccountProfileByAccountId(Integer accountId) {
		System.out.println("Start:getAccountProfileByAccountId()");
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			AccountProfile accountProfile=session.get(AccountProfile.class,accountId);
			transaction.commit();
			return accountProfile;
		} catch (Exception e) {
			e.printStackTrace();
			if( transaction != null )
				transaction.rollback();
		}finally {
			
			if( session != null ){
				session.close();
			}
		}
		System.out.println("End:getAccountTransactionDetailsByAccountId()");
		return null;
	}

	public AccountProfile getAccountProfileByProfileId(Integer profileId) {
		System.out.println("Start:getAccountProfileByProfileId()");
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			AccountProfile accountProfile=session.get(AccountProfile.class,profileId);
			transaction.commit();
			return accountProfile;
		} catch (Exception e) {
			e.printStackTrace();
			if( transaction != null )
				transaction.rollback();
		}finally {
			
			if( session != null ){
				session.close();
			}
		}
		System.out.println("End:getAccountTransactionDetailsByProfileId()");
		return null;
	}

	public AccountProfile saveAccountProfile(AccountProfile accountProfile) {
			System.out.println("START : saveAccountProfile()");
		
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(accountProfile);
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
		return accountProfile ;
	}

	public AccountProfile saveOrUpdateAccountProfile(AccountProfile accountProfile) {
			System.out.println("START : saveOrUpdateAccountProfile()");
		
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(accountProfile);
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
		System.out.println("END : saveOrUpdateAccountProfile()");
		return accountProfile ;
	}

	}

