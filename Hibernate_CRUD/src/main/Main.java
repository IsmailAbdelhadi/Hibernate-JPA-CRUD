package main;

import main.com.myApp.controller.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main
{
    public static void main(String[] args) {
        // define the Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        //define session
        Session session = sessionFactory.getCurrentSession();

        try {

            //---------GuestModel CRUD using Hibernate---------------------------------------------
            //Create guest object
            User user = new User(2 ,"ali","password");

            //open the transaction
            session.beginTransaction();

            //save object into table
             session.save(user);

            //retrieve object from database
            User user1 = session.get(User.class , 1);
            System.out.println(user);

            //update the object
            user.setPassword("HII9966");

            //delete the object
            session.delete(user);

            //commit the changes
            session.getTransaction().commit();
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }finally {
            session.close();
        }

    }
}
