package jsp;


import java.io.*;
import java.nio.Buffer;

/**
 * Created by Admin on 9/25/16.
 */
public class UserDataSource {


    public User getByUsernameAndPassword(String username, String password) {

try(FileReader fileReader = new FileReader(new File("/Users/Admin/Documents/javaservl/src/main/resources/user.txt")))

    {

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = null;
        while((line = bufferedReader.readLine())!=null){
            String[] cols = line.split(",");

        if (cols[0].equals(username)&&cols[1].equals(password)){
                User user = new User();
                user.setUsername(cols[0]);
                user.setPassword(cols[1]);
                user.setFirstname(cols[2]);
                user.setLastname(cols[3]);
                user.setAge(Integer.parseInt(cols[4]));

                return user;
           }
        }

    }
    catch(FileNotFoundException e)
    {
        e.printStackTrace();
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
    return null;
    }
}

