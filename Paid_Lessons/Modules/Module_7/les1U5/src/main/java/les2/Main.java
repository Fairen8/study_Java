package Paid_Lessons.Modules.Module_7.les1U5.src.main.java.les2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    private static final EntityManagerFactory MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    public static void main(String[] args) {
        addItems("Minecrfat" , 100, "Microsoft");



        MANAGER_FACTORY.close();
    } public static void addItems(String name, int price, String info) {
        EntityManager entityManager =MANAGER_FACTORY.createEntityManager();

        EntityTransaction entityTransaction = null;

        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

//            Item item = new Item(name, price, info);
//            entityManager.persist(item);
            entityTransaction.commit();

        } catch (Exception e) {
            if (entityTransaction != null)
                entityTransaction.rollback();

            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

}
