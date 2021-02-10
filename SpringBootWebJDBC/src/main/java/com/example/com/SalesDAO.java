package com.example.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// Use a Data Access Object (DAO) to abstract and 
// encapsulate all access to the data source. The DAO 
// manages the connection with the data source to obtain and store data. 
// The DAO implements the access mechanism required to work with the data source.

@Repository
@Transactional
public class SalesDAO {

	// The key point here is, we specify that an instance
	// of JdbcTemplate class will be automatically created and injected by Spring:

	@Autowired
	private JdbcTemplate jdbcTemp;

	public List<Sales> list() {

		String sql = "Select * from SALES";

		List<Sales> listSales = jdbcTemp.query(sql, BeanPropertyRowMapper.newInstance(Sales.class));

		// The cool thing here is the BeanPropertyRowMapper
		// does the mapping values from JDBC ResultSet to Java objects.
		// You need to make sure the name of the fields
		// in the Sale class are same as
		// the names of the columns in the table.

		return listSales;
	}

	public void save(Sales sale) {

		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemp);
		insertActor.withTableName("sales").usingColumns("item", "quantity", "amount");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sale);

		insertActor.execute(param);

	}

	
	public Sales get(int id) {
		String sql = "SELECT * FROM SALES WHERE id = ?";
		Object[] args = {id};
		Sales sale = jdbcTemp.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Sales.class));
		return sale;
	}

	public void update(Sales sale) {
	}

	public void delete(int id) {
	}

}
