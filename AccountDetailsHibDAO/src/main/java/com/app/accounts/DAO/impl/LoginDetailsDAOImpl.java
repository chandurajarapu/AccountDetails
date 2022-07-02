package com.app.accounts.DAO.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.accounts.DAO.LoginDetailsDAO;
import com.app.accounts.db.utils.HibernateUtils;
import com.app.accounts.entity.LoginDetails;

public class LoginDetailsDAOImpl implements LoginDetailsDAO {

	public LoginDetails getLoginDetailsByUserNamePassword(String userName, String userPassword) {
		System.out.println("Start:getLoginDetailsByUserNamePassword()");
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
//			String hqlQuery = "Select e from LoginDetails e where e.userName=:empId and userPassword ";
			//String hqlQuery = "Select e from LoginDetails e where e.employeeId=?1 ";
			String hqlQuery = "from LoginDetails  where userName=:uName and userPassword=:uPassword ";
			
			Query query = session.createQuery(hqlQuery);
			//query.setParameter("empId", employeeId);
			query.setParameter("uName", userName);
			query.setParameter("uPassword", userPassword);
			
			
			
			LoginDetails  loginDetails = (LoginDetails) query.uniqueResult();
			transaction.commit();
			return loginDetails;
		} catch (Exception e) {
			e.printStackTrace();
			if( transaction != null )
				transaction.rollback();
		}finally {
			
			if( session != null ){
				session.close();
			}
		}
		System.out.println("End:getLoginDetailsByUserNamePassword");
		return null;
	}

	public LoginDetails getLoginDetailsByLoginId(Integer loginId) {
		System.out.println("Start:getLoginDetailsByLoginId()");
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			LoginDetails loginDetails=session.get(LoginDetails.class,loginId);
			transaction.commit();
			return loginDetails;
		} catch (Exception e) {
			e.printStackTrace();
			if( transaction != null )
				transaction.rollback();
		}finally {
			
			if( session != null ){
				session.close();
			}
		}
		System.out.println("End:getLoginDetailsByLoginId()");
		return null;
	}

	public LoginDetails getLoginDetailsByAadharNumber(String aadharNumber) {
		System.out.println("Start:getLoginDetailsByUserNameAadharNumber()");
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
//			String hqlQuery = "Select e from LoginDetails e where e.userName=:empId and userPassword ";
			//String hqlQuery = "Select e from LoginDetails e where e.employeeId=?1 ";
			String hqlQuery = "from LoginDetails  where aadharNumber=:aNumber";
			
			Query query = session.createQuery(hqlQuery);
			//query.setParameter("empId", employeeId);
			query.setParameter("aNumber", aadharNumber);
			
			
			
			LoginDetails  loginDetails = (LoginDetails) query.uniqueResult();
			transaction.commit();
			return loginDetails;
		} catch (Exception e) {
			e.printStackTrace();
			if( transaction != null )
				transaction.rollback();
		}finally {
			
			if( session != null ){
				session.close();
			}
		}
		System.out.println("End:getLoginDetailsByAadharNumber()");
		return null;
	}

	public LoginDetails saveLoginDetails(LoginDetails loginDetails) {
		System.out.println("START : saveLoginDetails()");
		
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(loginDetails);
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
		System.out.println("END : saveLoginDetails()");
		
		return loginDetails;
	}

	public LoginDetails saveOrUpdateLoginDetails(LoginDetails loginDetails) {
			System.out.println("START : saveOrUpdateLoginDetails()");
		
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(loginDetails);
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
		System.out.println("END : saveOrUpdateLoginDetails()");
		return loginDetails ;
	}

}
