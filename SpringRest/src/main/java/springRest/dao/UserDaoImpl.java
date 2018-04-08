package springRest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import springRest.models.UserDetails;

@Repository
public class UserDaoImpl implements UserDao {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<UserDetails> listAllUser() {
		// TODO Auto-generated method stub
		
		List<UserDetails> userList = new ArrayList<UserDetails>();
		String sql = "select * from user_details"; 
		userList = namedParameterJdbcTemplate.query(sql, getSqlParameterSourceByModel(null),new UserMapper());
		return userList;
	}

	
	
	public void addUser(UserDetails user) {
		String sql = "insert into user_details (name, password) values (:name, :password)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSourceByModel(user));
	}

	public void updateUser(UserDetails user) {
		
		String sql = "update user_details set name= :name where id = :id";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSourceByModel(user));
	}

	public void deleteUser(UserDetails user) {

		String sql = "delete from user_details where id = :id";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSourceByModel(user));
	}

	public UserDetails findUserById(UserDetails user) {
		// TODO Auto-generated method stub
		String sql = "select * from user_details where id = :id";
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterSourceByModel(user), new UserMapper());
	}

	private SqlParameterSource getSqlParameterSourceByModel(UserDetails user)
	{
		MapSqlParameterSource mapSqlPaSrc = new MapSqlParameterSource();
		if (user != null)
		{
			mapSqlPaSrc.addValue("id", user.getId());
			mapSqlPaSrc.addValue("name", user.getName());
			mapSqlPaSrc.addValue("password",user.getPassword());
		}
		return mapSqlPaSrc;
	}
	
	private static final class UserMapper implements RowMapper<UserDetails>{

		public UserDetails mapRow(ResultSet rs, int rownum) throws SQLException {
			// TODO Auto-generated method stub
			return new UserDetails();
		}
		
	}
}
