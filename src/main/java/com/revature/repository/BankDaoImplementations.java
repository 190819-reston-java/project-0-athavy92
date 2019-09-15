package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Customer;
import com.revature.repository.BankAppConnectionUtil;
import com.revature.repository.BankStreamCloser;

public class BankDaoImplementations implements BankDao {

	private static Customer createCustomerFromRS(ResultSet results) throws SQLException {
		return new Customer(results.getInt("account_id"), results.getString("first_name"), results.getString("username"),
				results.getString("password"), results.getInt("pin_number"), results.getDouble("balance"));
	}
	
	//Customer user = new Customer();
	@Override
	public List<Customer> getCustomers() {
	
		PreparedStatement statement = null;
		ResultSet results = null;

		String query = "SELECT * FROM customer_account.bankacctinfo;";

		List<Customer> customers = new ArrayList<Customer>();

		try (Connection conn = BankAppConnectionUtil.getConnection()) {

			statement = conn.prepareStatement(query);
			results = statement.executeQuery();

			while (results.next()) {
				customers.add(createCustomerFromRS(results));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BankStreamCloser.close(results);
			BankStreamCloser.close(statement);
		}

		return customers;
	}

	@Override
	public Customer getCustomerAccount(String username, String password) {
		Customer user = null;

		PreparedStatement statement = null;
		ResultSet results = null;
		String query = "SELECT * FROM customer_account.bankAcctInfo WHERE username =? AND password = ?";

		try (Connection conn = BankAppConnectionUtil.getConnection()) {
			
			statement = conn.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);
			if(statement.execute()) {
				results = statement.getResultSet();
				if (results.next()) {
					user = createCustomerFromRS(results);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BankStreamCloser.close(results);
			BankStreamCloser.close(statement);
		}

		return user;
	}
	
	@Override
	public Customer getUsername(String username) {
		Customer user = null;

		PreparedStatement statement = null;
		ResultSet results = null;
		String query = "SELECT * FROM customer_account.bankAcctInfo WHERE username  =?";

		try (Connection conn = BankAppConnectionUtil.getConnection()) {
			statement = conn.prepareStatement(query);
			statement.setString(1, username);
			statement.execute();
			results = statement.getResultSet();
			if (results.next()) {
				user = createCustomerFromRS(results);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BankStreamCloser.close(results);
			BankStreamCloser.close(statement);
		}

		return user;
	}
	@Override
	public Customer getPassword(String password) {
		Customer user = null;

		PreparedStatement statement = null;
		ResultSet results = null;
		String query = "SELECT * FROM customer_account.bankAcctInfo WHERE password=?";

		try (Connection conn = BankAppConnectionUtil.getConnection()) {
			statement = conn.prepareStatement(query);
			statement.setString(1, password);
			statement.execute();
			results = statement.getResultSet();
			if (results.next()) {
				user = createCustomerFromRS(results);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BankStreamCloser.close(results);
			BankStreamCloser.close(statement);
		}
		return user;
	}
	
	
	@Override
	public boolean updateAccount(Customer bc) {
		PreparedStatement statement = null;
		
		final String query = "UPDATE customer_account.bankacctinfo SET first_name =?, username=?, password=?, pin_number=?, balance=? WHERE account_id=?;";
		try(Connection conn = BankAppConnectionUtil.getConnection()){
			statement = conn.prepareStatement(query);
			statement.setString(1, bc.getFirstname());
			statement.setString(2, bc.getUsername());
			statement.setString(3, bc.getUserPass());
			statement.setInt(4, bc.getPinNumber());
			statement.setDouble(5, bc.getBalance());
			statement.setInt(6, bc.getId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			BankStreamCloser.close(statement);
		}
		return true;
	}
	
	
//	@Override
//	public Customer getBalance(Customer username) {
//		Customer userBalance = null;
//
//		PreparedStatement statement = null;
//		ResultSet results = null;
//		String query = "SELECT balance FROM customer_account.bankAcctInfo WHERE username  =? OR account_id = ?";
//
//		try (Connection conn = BankAppConnectionUtil.getConnection()) {
//			statement = conn.prepareStatement(query);
//			statement.setString(1, username);
//			statement.execute();
//			results = statement.getResultSet();
//			if (results.next()) {
//				userBalance = createCustomerFromRS(results);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			BankStreamCloser.close(results);
//			BankStreamCloser.close(statement);
//		}
//
//		return userBalance;
//	}
	
	@Override
	public boolean updateBalance(double balanceAmt, String username) {
		final String query = "UPDATE customer_account.bankacctinfo SET balance=? WHERE username = ?;";

		try (Connection conn = BankAppConnectionUtil.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setDouble(1, balanceAmt);
			statement.setString(2, username);
			statement.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} 
		
		return true;
	}

	@Override
	public boolean createNewAccount(Customer bc) {
		PreparedStatement statement = null;
		
		String query = "INSERT INTO customer_account.bankacctinfo VALUES (DEFAULT, ?, ?, ?, ?, ?);";
		
		try (Connection conn = BankAppConnectionUtil.getConnection()){
			
			statement = conn.prepareStatement(query);
			statement.setString(1, bc.getFirstname());
			statement.setString(2, bc.getUsername());
			statement.setString(3, bc.getUserPass());
			statement.setInt(4, bc.getPinNumber());
			statement.setDouble(5, bc.getBalance());
		
			statement.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			BankStreamCloser.close(statement);
		}
		return true;
	}
//
//	@Override
//	public Customer getFirstName(String firstName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
	@Override
	public Customer getPin(int pin) {
		Customer user = null;

		PreparedStatement statement = null;
		ResultSet results = null;
		String query = "SELECT * FROM customer_account.bankAcctInfo WHERE pin_input = ?";

		try (Connection conn = BankAppConnectionUtil.getConnection()) {
		
			statement = conn.prepareStatement(query);
			statement.setInt(1, pin);
			if(statement.execute()) {
				results = statement.getResultSet();
				if (results.next()) {
					user = createCustomerFromRS(results);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BankStreamCloser.close(results);
			BankStreamCloser.close(statement);
		}

		return user;
	}

	@Override
	public Customer getCustomerAccountVerfication(String username, String password, int pin) {
		Customer user = null;

		PreparedStatement statement = null;
		ResultSet results = null;
		String query = "SELECT * FROM customer_account.bankAcctInfo WHERE username =? AND password = ? AND pin_number = ?";

		try (Connection conn = BankAppConnectionUtil.getConnection()) {
			
			statement = conn.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setInt(3, pin);
			if(statement.execute()) {
				results = statement.getResultSet();
				if (results.next()) {
					user = createCustomerFromRS(results);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BankStreamCloser.close(results);
			BankStreamCloser.close(statement);
		}

		return user;
	}

}
