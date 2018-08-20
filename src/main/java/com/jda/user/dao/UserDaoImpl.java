/**
 * 
 */
package com.jda.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.jda.user.model.Login;
import com.jda.user.model.User;

/**
 * @author bridgelabz
 *
 */
public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jda.user.dao.UserDao#register(com.jda.user.model.User)
	 */
	@Override
	public void register(User user) {
		String sql = "insert into userinfo values(?,?,?,?,?,?)";
		user.setToken("abc");
		jdbcTemplate.update(sql, new Object[] { user.getEmail(), user.getPassword(), user.getFirstname(),
		      user.getLastname(), user.getMobile(), user.getToken() });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jda.user.dao.UserDao#validateUser(com.jda.user.model.Login)
	 */
	@Override
	public User validateUser(Login login) {
		String sql = "select * from userinfo where email='" + login.getEmail() + "' and password='" + login.getPassword()
		      + "'";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());

		return users.size() > 0 ? users.get(0) : null;
	}

	@Override
	public User validateEmail(String email) {
		String sql = "select * from userinfo where email='" + email + "'";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());

		return users.size() > 0 ? users.get(0) : null;
	}

	@Override
	public void saveToken(String token, String email) {
		String sql = "update userinfo set token='"+token+"' where email='"+email+"'";
		 jdbcTemplate.execute(sql);
	}

	@Override
	public User getUserbyToken(String resetToken) {
		 String sql = "select * from userinfo where token='" + resetToken 
		 	    + "'";
		 	    List<User> users = jdbcTemplate.query(sql, new UserMapper());
		 	    return users.size() > 0 ? users.get(0) : null;

	}

	@Override
	public void newPassword(String password, String token) {
		String sql="update userinfo set password='"+password +"'  where token='"+token+"'";
		System.out.println(password);
		jdbcTemplate.update(sql);
	}
}

class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setPassword(rs.getString("password"));
		user.setFirstname(rs.getString("firsname"));
		user.setLastname(rs.getString("lastname"));
		user.setEmail(rs.getString("email"));
		user.setMobile(rs.getString("mobile"));
		user.setToken(rs.getString("token"));
		return user;
	}
}
