//package com.example.jsp.model.abs;
//
//import java.io.Serializable;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//public abstract class BaseDao<T> implements Serializable {
//
//	private Transaction transaction;
//
//	public void salvarOuAlterar(T obj, Session session) {
//		try {
//			transaction = session.beginTransaction();
//			session.saveOrUpdate(obj);
//			transaction.commit();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			transaction.rollback();
//		}
//	}
//
//	public void excluir(T obj, Session session) {
//		try {
//			transaction = session.beginTransaction();
//			session.delete(obj);
//			transaction.commit();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//}
