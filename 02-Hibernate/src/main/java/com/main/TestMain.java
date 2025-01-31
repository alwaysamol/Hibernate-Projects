package com.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.config.HibernateUtil;
import com.model.Employee;

public class TestMain {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        try (Session session = factory.openSession(); Scanner s = new Scanner(System.in)) {
            System.out.println("Choose operation: \n1. Insert \n2. Update \n3. Delete \n4. Get Record");
            int choice = s.nextInt();
            
            switch (choice) {
                case 1:
                    insertRecord(session, s);
                    break;
                case 2:
                    updateRecord(session, s);
                    break;
                case 3:
                    deleteEmployee(session, s);
                    break;
                case 4:
                    getRecord(session, s);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateRecord(Session session, Scanner s) {
        Transaction txn = null;
        try {
            txn = session.beginTransaction();
            System.out.print("Enter Eid to update record: ");
            int eid = s.nextInt();

            Employee emp = session.get(Employee.class, eid);
            if (emp != null) {
                System.out.print("Enter new name: ");
                emp.setEname(s.next());
                System.out.print("Enter new salary: ");
                emp.setSalary(s.nextDouble());
                System.out.print("Enter new mobile no: ");
                emp.setMno(s.nextLong());

                session.update(emp);
                txn.commit();
                System.out.println("Employee updated successfully!");
            } else {
                System.out.println("Employee not found!");
            }
        } catch (Exception e) {
            if (txn != null) txn.rollback();
            e.printStackTrace();
        }
    }

    private static void deleteEmployee(Session session, Scanner s) {
        Transaction txn = null;
        try {
            txn = session.beginTransaction();
            System.out.print("Enter eid to delete record: ");
            int eid = s.nextInt();

            Employee emp = session.get(Employee.class, eid);
            if (emp != null) {
                session.delete(emp);
                txn.commit();
                System.out.println("Record deleted successfully!");
            } else {
                System.out.println("Employee not found!");
            }
        } catch (Exception e) {
            if (txn != null) txn.rollback();
            e.printStackTrace();
        }
    }

    private static void getRecord(Session session, Scanner s) {
        System.out.print("Enter eid to fetch record: ");
        int eid = s.nextInt();
        Employee emp = session.get(Employee.class, eid);
        if (emp != null) {
            System.out.println(emp);
        } else {
            System.out.println("Employee not found!");
        }
    }

    private static void insertRecord(Session session, Scanner s) {
        Transaction txn = null;
        try {
            txn = session.beginTransaction();
            Employee emp = new Employee();

            System.out.print("Enter eid: ");
            emp.setEid(s.nextInt());
            System.out.print("Enter ename: ");
            emp.setEname(s.next());
            System.out.print("Enter salary: ");
            emp.setSalary(s.nextDouble());
            System.out.print("Enter mobile no: ");
            emp.setMno(s.nextLong());

            session.save(emp);
            txn.commit();
            System.out.println("Employee added successfully!");
        } catch (Exception e) {
            if (txn != null) txn.rollback();
            e.printStackTrace();
        }
    }
}
