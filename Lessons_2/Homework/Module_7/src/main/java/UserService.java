import java.util.List;

public class UserService {
    private static final UserDAO _userDAO = new UserDAO();

    public static void add(User user) {
        _userDAO.add((user));
    }

    public static void edit(int id, User user) {
        _userDAO.edit(id, user);
    }
    public static User getUser(String username) {
        return _userDAO.getUser(username);
    }

    public static List<User> getUsers(int from, int to) {
        return _userDAO.getUsers(from, to);
    }

    public static void delete(String username) {
        _userDAO.delete(username);
    }
}
