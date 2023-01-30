package com.training.relationshipdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.training.relationshipdemo.pojo.Laptop;
import com.training.relationshipdemo.pojo.Person;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Person p = new Person();
    	Laptop l = new Laptop();
    	
    	l.setLid(1);
    	l.setLname("Dell");
    	
    	p.setPid(101);
    	p.setName("Anil");
    	p.setHobby("Programming");
    	p.setLaptop(l);
    	
    	
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Person.class).addAnnotatedClass(Laptop.class);
    	SessionFactory sf = con.buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	session.save(p);
    	session.save(l);
    	tx.commit();
    }
}

