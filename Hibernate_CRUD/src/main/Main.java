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

            //---------UserModel CRUD using Hibernate---------------------------------------------
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




            //------------Products using ProductModel & HQL-------------------------------------------
            //Create Product object
            //UserModel user = new UserModel("sherif","password",new Date());
            //ProductModel product = new ProductModel("samsung s23","mobile_phone",24500.0,4,"china","2023-08-04");

            //save object into table
            //session.save(user);
            //System.out.println(user);
            //session.save(product);
            //System.out.println(product);

            //update query
            //Query query = session.createQuery("update ProductModel set product_name=:name where id=:i");

            //set the parameter
            //query.setParameter("name","samsung a54");
            //query.setParameter("i",31);
            //Execute query
            //int status = query.executeUpdate();
            //System.out.println(status);

            //aggregation function with query HQL
            //Query query = session.createQuery("select sum(price) from ProductModel");

            //excute query
            //List<Integer> priceResult = query.getResultList();
            //System.out.println("the total price of all products is:  "+priceResult.get(0));

            //get all products in a list with pagination
            //Query query = session.createQuery("from ProductModel");

            //set the start row
            //query.setFirstResult(21); //this number is not included in fetch data will start with the next/following number
            //set the total rows to fetch
            //query.setMaxResults(10);

            //list all product
            //List<ProductModel> productList = query.getResultList();
            //for(Object product : productList)
            //System.out.println(product);
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }finally {
            session.close();
        }

    }
}
