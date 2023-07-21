package med.model.jbdc;

public class Methods {
/*
        *    public void createUsersTable() {
        String sql = "c reate table  if not exists students (" +
                "id serial primary key ," +
                "first_name varchar," +
                "last_name varchar," +
                "age int)";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Table successfully created");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }




//        String sql="create table if not exist users(" +
//                "id serial primary key, " +
//                "first_name varchar," +
//                "last_name varchar, " +
//                "age smallInt )";
//        try(Connection connection = Util.getConnection();
//        Statement statement=connection.createStatement()){
//        statement.executeUpdate(sql);
//            System.out.println("Create new table!");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }

    public void dropUsersTable() {
        String sql="drop users table;";
        try(Connection connection=Util.getConnection();
        Statement statement =connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Table successfully droped!");
        }catch (SQLException e ){
            System.out.println(e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql="insert into users (" +
                "first_name,last_name,age)" +
                "values (" +
                "?,?,?);";
        try(Connection connection = Util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,"first_name");
            preparedStatement.setString(2,"last_name");
            preparedStatement.setInt(3,age);
            preparedStatement.executeUpdate();
            System.out.println("User successfully saved");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void removeUserById(long id) {
        String sql="delete from users where id=?;";
        try(Connection connection=Util.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.executeUpdate();
            preparedStatement.setLong(1,id);
            System.out.println("User by id: "+id+"is deleted!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        List<User>users=new ArrayList<>();
        String sql="select * from users;";
        try(Connection connection=Util.getConnection();
        Statement statement = connection.createStatement()){
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                users.add(new User(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getByte("age")
                ));}
            }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void cleanUsersTable() {
        String sql="delete * from users;";
        try(Connection connection = Util.getConnection();
        Statement statement= connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Table successfully deleted!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
*/
}
}

}
