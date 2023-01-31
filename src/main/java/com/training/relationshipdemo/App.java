package com.training.relationshipdemo;

import java.util.ArrayList;
import java.util.List;

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
    	Person p1 = new Person();
    	p.setPid(102);
    	p.setName("Gurmandeep");
    	p.setHobby("Programming");
    	
    	p1.setPid(101);
    	p1.setName("Anil");
    	p1.setHobby("Singing");
    	
    	List<Person> personList = new ArrayList<Person>();
    	personList.add(p1);
    	personList.add(p);
    	
    	Laptop l = new Laptop();
    	l.setLid(1);
    	l.setLname("Dell");
    	l.setListPerson(personList);
    	
    	Laptop l1 = new Laptop();
    	l1.setLid(2);
    	l1.setLname("Mac");
    	l1.setListPerson(personList);
    	
    	List<Laptop> llist = new ArrayList<Laptop>();
    	llist.add(l);
    	llist.add(l1);
    	
    	
    	p.setLlist(llist);
    	p1.setLlist(llist);
    	
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Person.class).addAnnotatedClass(Laptop.class);
    	SessionFactory sf = con.buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	session.save(p);
    	session.save(p1);
    	session.save(l);
    	session.save(l1);
    	tx.commit();
    }
}

