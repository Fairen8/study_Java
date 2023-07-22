import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserDAO {

    private static final EntityManagerFactory MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    @PersistenceContext
    private EntityManager entityManager;

    public void add(User user) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(user);
        entityTransaction.commit();
    }

    public void edit(int id, User user) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User newUser = entityManager.find(User.class, id);
        newUser.setUsername(user.getUsername());
        newUser.setAge(user.getAge());

        entityManager.persist(newUser);
        entityTransaction.commit();
    }

    public User getUser(String username) {
        EntityManager entityManager = MANAGER_FACTORY.createEntityManager();

        String query = "SELECT u FROM User u WHERE u.username = :username1";

        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        typedQuery.setParameter("username1", username);

        return typedQuery.getSingleResult();
    }

    public List<User> getUsers(int from, int to) {
        EntityManager entityManager = MANAGER_FACTORY.createEntityManager();

        String query = "SELECT u FROM User u WHERE u.age >= :age1 AND u.age < :age2";

        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        typedQuery.setParameter("age1", from);
        typedQuery.setParameter("age2", to);

        return typedQuery.getResultList();
    }

    public void delete(String username) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User user = entityManager.find(User.class, UserService.getUser(username).getId());

        entityManager.remove(user);
        entityTransaction.commit();
    }
}
