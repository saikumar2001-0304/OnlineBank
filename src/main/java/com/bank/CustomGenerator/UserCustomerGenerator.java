package com.bank.CustomGenerator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UserCustomerGenerator implements IdentifierGenerator{

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		
		String prefix="OBA";
		String suffix="";
		
		try {
			JdbcConnectionAccess access = session.getJdbcConnectionAccess();
			Connection connection = access.obtainConnection();
			Statement statement = connection.createStatement();
			String sql="select nextval('user_id_seq')";
			ResultSet resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				int seqval = resultSet.getInt(1);
				suffix=String.valueOf(seqval);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prefix+suffix;
	}

	
}
