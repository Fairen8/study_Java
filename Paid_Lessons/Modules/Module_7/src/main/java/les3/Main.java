//package les3;
//
//import javax.persistence.*;
//import java.util.List;
//
//public class Main {
//
//    private static final EntityManagerFactory MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
//
//    public static void main(String[] args) {
//        getItem(3);
//
//        MANAGER_FACTORY.close();
//    }
//
//    private static void getItem(int id) {
//        EntityManager entityManager = MANAGER_FACTORY.createEntityManager();
//
//        String query = "SELECT i FROM les4.Item i WHERE i.id = :id1";
//
//        TypedQuery<Item> typedQuery = entityManager.createQuery(query, Item.class);
//        typedQuery.setParameter("id1", id);
//
//        Item item = null;
//        try {
//            item = typedQuery.getSingleResult();
//
//            System.out.println("Name: " + item.getName() +
//                    ", price: " + item.getPrice() +
//                    ", info: " + item.getInfo());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            entityManager.close();
//        }
//
//    }
//
//    public static void addItems(String name, int price, String info) {
//        EntityManager entityManager = MANAGER_FACTORY.createEntityManager();
//
//        EntityTransaction entityTransaction = null;
//
//        try {
//            entityTransaction = entityManager.getTransaction();
//            entityTransaction.begin();
//
//            Item item = new Item(name, price, info);
//            entityManager.persist(item);
//            entityTransaction.commit();
//
//        } catch (Exception e) {
//            if (entityTransaction != null)
//                entityTransaction.rollback();
//
//            e.printStackTrace();
//        } finally {
//            entityManager.close();
//        }
//    }
//
//}
