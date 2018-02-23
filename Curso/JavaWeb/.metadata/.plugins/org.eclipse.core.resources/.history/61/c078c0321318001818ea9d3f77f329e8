package com.moraes;
// Generated 20/02/2018 17:59:01 by Hibernate Tools 4.3.1

import java.io.File;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Home object for domain model class Pagamento.
 * @see com.moraes.Pagamento
 * @author Hibernate Tools
 */
public class PagamentoDAO {

	private static final Log log = LogFactory.getLog(PagamentoDAO.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = new Configuration().configure(new File("src/META-INF/hibernate.cfg.xml"))
				.buildSessionFactory();
		return sessionFactory;
	}

	public void persist(Pagamento transientInstance) {
		log.debug("persisting Pagamento instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.persist(transientInstance);
			session.getTransaction().commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}
	public void delete(Pagamento persistenteInstance) {
		log.debug("delete Pagamento instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.delete(persistenteInstance);
			session.getTransaction().commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public void merge(Pagamento detacheInstance) {
		log.debug("merge Pagamento instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.merge(detacheInstance);
			session.getTransaction().commit();
			log.debug("merge successful");
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	public List<Pagamento> findAll(Pagamento detacheInstance) {
		log.debug("merge Pagamento instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.merge(detacheInstance);
			session.getTransaction().commit();
			log.debug("merge successful");
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
		return null;
	}
	public Pagamento find(PagamentoId pagamentoId) {
		log.debug("find Pagamento instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Pagamento instance = (Pagamento) sessionFactory.getCurrentSession().get("com.moraes.Pagamento", pagamentoId);
			session.getTransaction().commit();
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}
	}
}
