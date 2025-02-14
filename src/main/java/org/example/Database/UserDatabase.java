package org.example.Database;

import org.example.Model.Customer;
import org.example.Model.Employee;
import org.example.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private Connection connection;

    // Constructor to initialize database connection
    public UserDatabase(Connection connection) {
        this.connection = connection;
    }

    // Add a new user (Customer or Employee)
    public boolean addUser(User user) {
        String query = "INSERT INTO users (id, name, email, password, role) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getId());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getRole());

            if (stmt.executeUpdate() > 0) {
                // If the user is a Customer, insert into customers table
                if (user instanceof Customer) {
                    Customer customer = (Customer) user;
                    String customerQuery = "INSERT INTO customers (id, accountNumber, balance) VALUES (?, ?, ?)";
                    try (PreparedStatement customerStmt = connection.prepareStatement(customerQuery)) {
                        customerStmt.setString(1, customer.getId());
                        customerStmt.setString(2, customer.getAccountNumber());
                        customerStmt.setDouble(3, customer.getBalance());
                        return customerStmt.executeUpdate() > 0;
                    }
                }
                // If the user is an Employee, insert into employees table
                else if (user instanceof Employee) {
                    Employee employee = (Employee) user;
                    String employeeQuery = "INSERT INTO employees (id, employeeId, department, salary) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement employeeStmt = connection.prepareStatement(employeeQuery)) {
                        employeeStmt.setString(1, employee.getId());
                        employeeStmt.setString(2, employee.getEmployeeId());
                        employeeStmt.setString(3, employee.getDepartment());
                        employeeStmt.setDouble(4, employee.getSalary());
                        return employeeStmt.executeUpdate() > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Retrieve user by ID (returns Customer or Employee)
    public User getUserById(String id) {
        String query = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");

                if ("Customer".equals(role)) {
                    return getCustomerById(id);
                } else if ("Employee".equals(role)) {
                    return getEmployeeById(id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Retrieve all users (both Customers and Employees)
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        users.addAll(getAllCustomers());
        users.addAll(getAllEmployees());
        return users;
    }

    // Retrieve customer by ID
    private Customer getCustomerById(String id) {
        String query = "SELECT u.*, c.accountNumber, c.balance FROM users u JOIN customers c ON u.id = c.id WHERE u.id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Customer(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("accountNumber"),
                        rs.getDouble("balance")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Retrieve employee by ID
    private Employee getEmployeeById(String id) {
        String query = "SELECT u.*, e.employeeId, e.department, e.salary FROM users u JOIN employees e ON u.id = e.id WHERE u.id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Employee(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("employeeId"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Retrieve all customers
    private List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT u.*, c.accountNumber, c.balance FROM users u JOIN customers c ON u.id = c.id";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                customers.add(new Customer(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("accountNumber"),
                        rs.getDouble("balance")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    // Retrieve all employees
    private List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT u.*, e.employeeId, e.department, e.salary FROM users u JOIN employees e ON u.id = e.id";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                employees.add(new Employee(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("employeeId"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Update user details
    public boolean updateUser(User user) {
        String query = "UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getId());
            if (stmt.executeUpdate() > 0) {
                if (user instanceof Customer) {
                    Customer customer = (Customer) user;
                    return updateCustomer(customer);
                } else if (user instanceof Employee) {
                    Employee employee = (Employee) user;
                    return updateEmployee(employee);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update customer details
    private boolean updateCustomer(Customer customer) {
        String query = "UPDATE customers SET accountNumber = ?, balance = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, customer.getAccountNumber());
            stmt.setDouble(2, customer.getBalance());
            stmt.setString(3, customer.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update employee details
    private boolean updateEmployee(Employee employee) {
        String query = "UPDATE employees SET employeeId = ?, department = ?, salary = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, employee.getEmployeeId());
            stmt.setString(2, employee.getDepartment());
            stmt.setDouble(3, employee.getSalary());
            stmt.setString(4, employee.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
