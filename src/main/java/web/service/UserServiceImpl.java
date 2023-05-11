package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override

    public void saveUser(User user) {
        userDao.saveUser(user);
    }


}
