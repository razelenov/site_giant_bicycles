package api.database;

import api.data.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {
    List<Categories> categories = new ArrayList<>();
    List<Users> users = new ArrayList<>();
    List<Items> items = new ArrayList<>();
    List<Orders> orders = new ArrayList<>();
    List<Cart> cart = new ArrayList<>();

    //Данные
    public class Auth {
        private String url = "jdbc:postgresql://localhost:4800/restapi";
        private String login = "postgres";
        private String password = "admin";
    }

    Auth auth = new Auth();
    Date date = new Date();

    public void log(String str) {
        System.out.println("[ " + date.toString() + " ] " + str);
    }

    public List getResult(Class classname) {
        if (classname.equals(Users.class)) {
            String SQL_SELECT = "Select * from users";
            try (Connection conn = DriverManager.getConnection(auth.url, auth.login, auth.password);
                 PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
                if (conn != null) {
                    //log("Connected.");
                    ResultSet resultSet = preparedStatement.executeQuery();
                    log(preparedStatement.toString());
                    while (resultSet.next()) {
                        //Структура данных
                        int id = resultSet.getInt("id");
                        String email = resultSet.getString("email");
                        String password = resultSet.getString("password");
                        String date = resultSet.getString("dateofbirthday");
                        String address = resultSet.getString("address");
                        Users users = new Users(id, email, password, date, address);
                        this.users.add(users);
                    }
                    return this.users;
                } else {
                    log("WARNING: Can't connect to database");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //log("Count of categories: " + this.categories.size());
        } else if (classname.equals(Categories.class)) {
            String SQL_SELECT = "Select * from categories";
            try (Connection conn = DriverManager.getConnection(auth.url, auth.login, auth.password);
                 PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
                if (conn != null) {
                    //log("Connected.");
                    ResultSet resultSet = preparedStatement.executeQuery();
                    log(preparedStatement.toString());
                    while (resultSet.next()) {
                        //Структура данных
                        int Id = resultSet.getInt("id");
                        String Name = resultSet.getString("name");
                        Categories categories = new Categories(Id, Name);
                        this.categories.add(categories);
                    }
                    return this.categories;
                } else {
                    log("WARNING: Can't connect to database");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //log("Count of categories: " + this.categories.size());
        } else if (classname.equals(Items.class)) {
            String SQL_SELECT = "Select * from item";
            try (Connection conn = DriverManager.getConnection(auth.url, auth.login, auth.password);
                 PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
                if (conn != null) {
                    //log("Connected.");
                    ResultSet resultSet = preparedStatement.executeQuery();
                    log(preparedStatement.toString());
                    while (resultSet.next()) {
                        //Структура данных
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        int id_category = resultSet.getInt("id_category");
                        Double price = resultSet.getDouble("price");
                        String information = resultSet.getString("information");
                        Items items = new Items(id, name, id_category, price, information);
                        this.items.add(items);
                    }
                    return this.items;
                } else {
                    log("WARNING: Can't connect to database");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (classname.equals(Orders.class)) {
            String SQL_SELECT = "Select * from orders";
            try (Connection conn = DriverManager.getConnection(auth.url, auth.login, auth.password);
                 PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
                if (conn != null) {
                    //log("Connected.");
                    ResultSet resultSet = preparedStatement.executeQuery();
                    log(preparedStatement.toString());
                    while (resultSet.next()) {
                        //Структура данных
                        int id = resultSet.getInt("id");
                        String time = resultSet.getString("time");
                        String date = resultSet.getString("date");
                        String status = resultSet.getString("status");
                        Orders orders = new Orders(id, time, date, status);
                        this.orders.add(orders);
                    }
                    return this.orders;
                } else {
                    log("WARNING: Can't connect to database");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (classname.equals(Cart.class)) {
            String SQL_SELECT = "Select * from cart";
            try (Connection conn = DriverManager.getConnection(auth.url, auth.login, auth.password);
                 PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
                if (conn != null) {
                    //log("Connected.");
                    ResultSet resultSet = preparedStatement.executeQuery();
                    log(preparedStatement.toString());
                    while (resultSet.next()) {
                        //Структура данных
                        int id = resultSet.getInt("id");
                        int id_user = resultSet.getInt("id_user");
                        int id_item = resultSet.getInt("id_item");
                        int count = resultSet.getInt("count");
                        int id_order = resultSet.getInt("id_order");
                        Cart cart = new Cart(id, id_user, id_item, count, id_order);
                        this.cart.add(cart);
                    }
                    return this.cart;
                } else {
                    log("WARNING: Can't connect to database");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Categories addCategory(String name) {
        String SQL_SELECT = "insert into categories (name) values ('" + name + "') returning id, name";
        try (Connection conn = DriverManager.getConnection(auth.url, auth.login, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
             ResultSet result = preparedStatement.executeQuery();
             log(preparedStatement.toString());
             while (result.next()) {
                 return (new Categories(result.getInt("id"), result.getString("name")));
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log("Error addCategory(): false");
        return null;
    }

    public Users addUser(String email, String password, String dateofbirthday, String address) {
        String SQL_SELECT = "insert into users (email, password, dateofbirthday, address) values ('" + email + "', '" + password + "', '" + String.valueOf(dateofbirthday) + "', '" + address + "') returning id, email, password, dateofbirthday, address";
        try (Connection conn = DriverManager.getConnection(auth.url, auth.login, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet result = preparedStatement.executeQuery();
            log(preparedStatement.toString());
            while (result.next()) {
                return (new Users(result.getInt("id"), result.getString("email"), result.getString("password"),
                        result.getString("dateofbirthday"), result.getString("address")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log("Error addUser(): false");
        return null;
    }

    public Items addItem(String name, int id_category, double price, String information) {
        String SQL_SELECT = "insert into item (name, id_category, price, information) values ('" + name + "', '" + id_category + "', '" + price + "', '" + information + "') returning id, name, id_category, price, information";
        try (Connection conn = DriverManager.getConnection(auth.url, auth.login, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet result = preparedStatement.executeQuery();
            log(preparedStatement.toString());
            while (result.next()) {
                return (new Items(result.getInt("id"), result.getString("name"), result.getInt("id_category"),
                        result.getDouble("price"), result.getString("information")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log("Error addItem(): false");
        return null;
    }

    public Orders addOrder(String time, String date, String status) {
        String SQL_SELECT = "insert into orders (time, date, status) values ('" + time + "', '" + date + "', '" + status + "') returning id, time, date, status";
        try (Connection conn = DriverManager.getConnection(auth.url, auth.login, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet result = preparedStatement.executeQuery();
            log(preparedStatement.toString());
            while (result.next()) {
                return (new Orders(result.getInt("id"), result.getString("time"), result.getString("date"),
                        result.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log("Error addOrder(): false");
        return null;
    }

    public Cart addCart(int id_user, int id_item, int count, int id_order) {
        String SQL_SELECT = "insert into cart (id_user, id_item, count, id_order) values ('" + id_user + "', '" + id_item + "', '" + count + "', '" + id_order + "') returning id, id_user, id_item, count, id_order";
        try (Connection conn = DriverManager.getConnection(auth.url, auth.login, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet result = preparedStatement.executeQuery();
            log(preparedStatement.toString());
            while (result.next()) {
                return (new Cart(result.getInt("id"), result.getInt("id_user"), result.getInt("id_item"),
                        result.getInt("count"), result.getInt("id_order")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log("Error addCart(): false");
        return null;
    }

    public Categories changeCategory(Integer id, String name) {

        String SQL_SELECT = "update categories set name = '" + name + "' where id = " + id + " returning id, name";

        try (Connection conn = DriverManager.getConnection(auth.url, auth.login, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet result = preparedStatement.executeQuery();
            log(preparedStatement.toString());
            while (result.next()) {
                return (new Categories(result.getInt("id"), result.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log("Error changeCategory(): false");
        return null;
    }

    public Users changeUser(Integer id, String email, String password, String dateofbirthday, String address) {
        String SQL_SELECT = "update users set email = '" + email + "', password = '" + password +
                "', dateofbirthday = '" + dateofbirthday + "', address = '" + address + "' where id = " + id +
                " returning id, email, password, dateofbirthday, address";

        try (Connection conn = DriverManager.getConnection(auth.url, auth.login, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet result = preparedStatement.executeQuery();
            log(preparedStatement.toString());
            while (result.next()) {
                return (new Users(result.getInt("id"), result.getString("email"),
                        result.getString("password"), result.getString("dateofbirthday"), result.getString("address")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log("Error changeUser(): false");
        return null;
    }

    public Items changeItem(Integer id, String name, int id_category, Double price, String information) {
        String SQL_SELECT = "update item set name = '" + name + "', id_category = '" + id_category +
                "', price = '" + price + "', information = '" + information + "' where id = " + id +
                " returning id, name, id_category, price, information";

        try (Connection conn = DriverManager.getConnection(auth.url, auth.login, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet result = preparedStatement.executeQuery();
            log(preparedStatement.toString());
            while (result.next()) {
                return (new Items(result.getInt("id"), result.getString("name"), result.getInt("id_category"), result.getDouble("price"), result.getString("information")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log("Error changeItem(): false");
        return null;
    }

    public Orders changeOrder(Integer id, String time, String date, String status) {
        String SQL_SELECT = "update orders set time = '" + time + "', date = '" + date +
                "', status = '" + status + "' where id = " + id +
                " returning id, time, date, status";

        try (Connection conn = DriverManager.getConnection(auth.url, auth.login, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet result = preparedStatement.executeQuery();
            log(preparedStatement.toString());
            while (result.next()) {
                return (new Orders(result.getInt("id"), result.getString("time"), result.getString("date"), result.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log("Error changeOrder(): false");
        return null;
    }

    public Cart changeCart(Integer id, Integer id_user, Integer id_item, Integer count, Integer id_order) {
        System.out.println(id_item);
        String SQL_SELECT = "update cart set id_user = '" + id_user + "', id_item = '" + id_item +
                "', count = '" + count + "', id_order = '" + id_order + "' where id = " + id +
                " returning id, id_user, id_item, count, id_order";

        try (Connection conn = DriverManager.getConnection(auth.url, auth.login, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet result = preparedStatement.executeQuery();
            log(preparedStatement.toString());
            while (result.next()) {
                return (new Cart(result.getInt("id"), result.getInt("id_user"), result.getInt("id_item"), result.getInt("count"), result.getInt("id_order")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log("Error changeCart(): false");
        return null;
    }

    public Categories deleteCategory(Integer id) {
        String SQL_SELECT = "delete from categories where id = " + id + " returning id, name";

        try (Connection conn = DriverManager.getConnection(auth.url, auth.login, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet result = preparedStatement.executeQuery();
            log(preparedStatement.toString());
            while (result.next()) {
                int id1 = result.getInt("id");
                String name = result.getString("name");
                return (new Categories(id1, name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log("Error deleteCategory(): false");
        return null;
    }

    public Users deleteUser(Integer id) {
        String SQL_SELECT = "delete from users where id = " + id + " returning id, email, password, dateofbirthday, address";

        try (Connection conn = DriverManager.getConnection(auth.url, auth.login, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet result = preparedStatement.executeQuery();
            log(preparedStatement.toString());
            while (result.next()) {
                int id1 = result.getInt("id");
                String email = result.getString("email");
                String password = result.getString("password");
                String dateofbirthday = result.getString("dateofbirthday");
                String address = result.getString("address");
                return new Users(id1, email, password, dateofbirthday, address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log("Error deleteUser(): false");
        return null;
    }

    public Items deleteItem(Integer id) {
        String SQL_SELECT = "delete from item where id = " + id + " returning id, name, id_category, price, information";

        try (Connection conn = DriverManager.getConnection(auth.url, auth.login, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet result = preparedStatement.executeQuery();
            log(preparedStatement.toString());
            while (result.next()) {
                int id1 = result.getInt("id");
                String name = result.getString("name");
                int id_category = result.getInt("id_category");
                Double price = result.getDouble("price");
                String information = result.getString("information");
                return (new Items(id1, name, id_category, price, information));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log("Error deleteItem(): false");
        return null;
    }

    public Orders deleteOrder(Integer id) {
        String SQL_SELECT = "delete from orders where id = " + id + " returning id, time, date, status";

        try (Connection conn = DriverManager.getConnection(auth.url, auth.login, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet result = preparedStatement.executeQuery();
            log(preparedStatement.toString());
            while (result.next()) {
                int id1 = result.getInt("id");
                String time = result.getString("time");
                String date = result.getString("date");
                String status = result.getString("status");
                return (new Orders(id1, time, date, status));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log("Error deleteOrder(): false");
        return null;
    }

    public Cart deleteCart(Integer id) {
        String SQL_SELECT = "delete from cart where id = " + id + " returning id, id_user, id_item, count, id_order";

        try (Connection conn = DriverManager.getConnection(auth.url, auth.login, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet result = preparedStatement.executeQuery();
            log(preparedStatement.toString());
            while (result.next()) {
                int id1 = result.getInt("id");
                int id_user = result.getInt("id_user");
                int id_item = result.getInt("id_item");
                int count = result.getInt("count");
                int id_order = result.getInt("id_order");
                return (new Cart(id1, id_user, id_item, count, id_order));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log("Error deleteCart(): false");
        return null;
    }
}