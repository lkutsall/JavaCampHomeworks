package dayFiveHomeworkOne.dataAccess.concretes.inMemoryDatabase;

import java.util.ArrayList;
import java.util.List;

import dayFiveHomeworkOne.dataAccess.abstracts.UserDao;
import dayFiveHomeworkOne.entities.concretes.User;

public class inMemoryUserDao implements UserDao {

	List<User> users;
	User user1 = new User(1,"Ahmet", "Ahmetoğlu", "ahmet@gmail.com", "123456");
	User user2 = new User(2,"Mehmet", "Mehmetoğlu", "mehmet@gmail.com", "123456");
	User user3 = new User(3,"Haşmet", "Haşmetoğlu", "haşmet@gmail.com", "123456");
	User user4 = new User(4,"Samet", "Sametoğlu", "samet@gmail.com", "123456");
	
	public inMemoryUserDao() {
		super();
		this.users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
	}

	@Override
	public void add(User user) {
		users.add(user);
		System.out.println("IN MEMORY DATABASE: " + user.getFirstName() + ", has been added to database successfully.");
		
	}

	@Override
	public void update(User user) {
		System.out.println("IN MEMORY DATABASE: " + user.getFirstName() + ", has been updated successfully.");
		
	}

	@Override
	public void delete(User user) {
		users.remove(user);
		System.out.println("IN MEMORY DATABASE: " + user.getFirstName() + ", has been deleted from database successfully.");
		
	}

	@Override
	public List<User> getAll() {
		List<User> allUsers = new ArrayList<User>();
		for (User user : users) {
			allUsers.add(user);
		}
		
		return allUsers;
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
