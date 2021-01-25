package storage;

import model.Role;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserStorage {
    private static List<User> users = new ArrayList<>();
    private static int userId = 1;

    static {
        users.add(new User("Admin","admin","admin", Role.ADMIN));
    }
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
        return new ArrayList<>(users);
    }
}
