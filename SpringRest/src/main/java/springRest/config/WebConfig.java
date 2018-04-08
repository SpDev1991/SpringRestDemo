package springRest.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author SOUTAM Date: 04-08-2018 Spring configuration file
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "springRest")
public class WebConfig {

	@Autowired
	DataSource ds;

	/**
	 * @return Jdbc Template
	 */
	@Bean
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(ds);
	}

	/**
	 * @return DataSource after JndiLookup
	 * @throws NamingException
	 */
	@Bean
	public DataSource getDataSource() throws NamingException {
		JndiTemplate jndiT = new JndiTemplate();
		DataSource ds = (DataSource) jndiT.lookup("");
		return ds;
	}
}
