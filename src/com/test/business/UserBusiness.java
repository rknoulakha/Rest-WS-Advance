package com.test.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.test.beans.User;
import com.test.beans.UserAddress;
import com.test.error.DataNotFoundException;
import com.test.model.Database;

public class UserBusiness {

	private static Map<Long, User> user = Database.getUser();

	UserAddress ma1 = new UserAddress("India", "MP", "Neemuch", 458441);
	UserAddress ma2 = new UserAddress("India", "RAJ", "Chittorgarh", 458126);

	public UserBusiness() {
		user.put(1L, new User(1, "Rohit Kumar", "Software Engineer", ma1));
		user.put(2L, new User(2, "Amit Jain", "Doctor", ma2));
	}

	// check user exist or not
	public boolean isUserExist(long id) {

		User userInfo = user.get(id);
		if (userInfo != null) {
			return false;
		}
		return true;
	}

	// return all the users
	public List<User> getAllUser() {
		return new ArrayList<User>(user.values());

	}

	// return all the users for given year
	public List<User> getAllUserForYear(int year) {
		List<User> userForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (User users : user.values()) {
			cal.setTime(users.getDoj());
			if (cal.get(Calendar.YEAR) == year) {
				userForYear.add(users);
			}
		}
		return userForYear;
	}

	// return all the users by given start and end
	public List<User> getAllUsersPagination(int start, int end) {
		int size;
		ArrayList<User> list = new ArrayList<User>(user.values());
		size = start + end;
		if ((start + end) > list.size()) {
			size = list.size();
		}
		return list.subList(start, size);
	}

	// get a user
	public User getUser(long id) {
		if (isUserExist(id)) {
			throw new DataNotFoundException("User from user Id " + id + " not exist");
		}
		return user.get(id);
	}

	// get address of user
	public UserAddress getUserAddress(long id) {
		if (isUserExist(id)) {
			throw new DataNotFoundException("User from user Id " + id + " not exist");
		}

		return user.get(id).getAddress();
	}

	// add new user
	public User addUser(User u) {
		u.setId(user.size() + 1);
		user.put(u.getId(), u);
		return u;
	}

	// update existing user
	public User updateUser(User u) {
		if (isUserExist(u.getId())) {
			throw new DataNotFoundException("User from user Id " + u.getId() + " not exist");
		}
		user.put(u.getId(), u);
		return u;
	}

	// remove existing user
	public User removeUser(long id) {
		if (isUserExist(id)) {
			throw new DataNotFoundException("User from user Id " + id + " not exist");
		}
		return user.remove(id);
	}

}
