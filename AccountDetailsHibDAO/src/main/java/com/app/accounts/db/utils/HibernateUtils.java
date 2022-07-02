package com.app.accounts.db.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
	
	private HibernateUtils(){}

	private static SessionFactory sessionFactory = null;

	public static synchronized SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
			// build Session factory
			sessionFactory = meta.getSessionFactoryBuilder().build();
		}

		return sessionFactory;

	}
}
