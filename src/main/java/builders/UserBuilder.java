package builders;

import models.User;

import javax.json.JsonObject;

public class UserBuilder {

    public static User getUser(JsonObject jsonObject) {
        User user = new User();
        if (jsonObject.containsKey("id"))
            user.setId(jsonObject.getInt("id"));
        if (jsonObject.containsKey("name"))
            user.setName(jsonObject.getString("name"));
        if (jsonObject.containsKey("lastName"))
            user.setLastName(jsonObject.getString("lastName"));
        if (jsonObject.containsKey("email"))
            user.setEmail(jsonObject.getString("email"));
        return user;
    }
}
