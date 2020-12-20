import java.util.ArrayList;
import java.util.List;

public class InMemoryStorage {
    private static List<User> users = new ArrayList<>();
    private static int userId = 1;

    public void saveUser(User user){
        user.setId(userId++);
        users.add(user);
    }
    public User getUserByLogin(String login){
        for (User user: users){
            if (user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }

    public List<User> getUsers() {
        return users;
    }
}
