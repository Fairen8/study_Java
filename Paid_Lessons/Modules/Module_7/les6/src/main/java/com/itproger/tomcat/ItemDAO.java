package com.itproger.tomcat;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

// Data Access Object – будет помогать получить доступ к данным из БД
@Transactional // – говорим, что класс работает с транзакциями
// @Repository
public class ItemDAO {

    private static final EntityManagerFactory MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    @PersistenceContext
    private EntityManager entityManager;

    public int add(Item item) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(item);
        entityTransaction.commit();

        return item.getId();
    }

    public void edit(int id, Item item) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Item newItem = entityManager.find(Item.class, id);
        newItem.setPrice(item.getPrice());
        newItem.setInfo(item.getInfo());
        newItem.setName(item.getName());

        entityManager.persist(newItem);
        entityTransaction.commit();
    }

    public void delete(int id) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Item item = entityManager.find(Item.class, id);

        entityManager.remove(item);
        entityTransaction.commit();
    }

    public List<Item> getAll() {
        EntityManager entityManager = MANAGER_FACTORY.createEntityManager();

        String query = "SELECT i FROM Item i";

        TypedQuery<Item> typedQuery = entityManager.createQuery(query, Item.class);
        List<Item> items = typedQuery.getResultList();

        return items;
    }

    public Item getField(int id) {
        EntityManager entityManager = MANAGER_FACTORY.createEntityManager();

        String query = "SELECT i FROM Item i WHERE i.id = :id1";

        TypedQuery<Item> typedQuery = entityManager.createQuery(query, Item.class);
        typedQuery.setParameter("id1", id);
        Item item = typedQuery.getSingleResult();

        return item;
    }

}
