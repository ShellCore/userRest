package resources;

import builders.UserBuilder;
import models.User;

import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Objects;

@Stateless
@Path("users")
public class UserResources {

    @PersistenceContext
    private EntityManager em;

    @GET
    public String getAll() {
        if (em != null) {
            return em.toString();
        }
        return "It works!";
    }

    @POST
    @Path("add")
    public String addUser(JsonObject jsonObject) {
        if (jsonObject != null) {
            User user = UserBuilder.getUser(jsonObject);
            if (em != null) {
                em.getTransaction().begin();
                em.persist(user);
                em.getTransaction().commit();
                return user.toString();
            }
            else {
                return "No se pudo persistir (pinchi entity manager! =\\";
            }
        }

        return "Lo siento, no llegó un json válido";
    }
}
