package training.connector;

import org.hibernate.Session;
import training.entity.*;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class DBWorker {

    public List<User> getUserList() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        CriteriaQuery<User> criteriaQuery = session.getCriteriaBuilder().createQuery(User.class);
        criteriaQuery.from(User.class);

        List<User> users = session.createQuery(criteriaQuery).getResultList();
        session.close();

        return users;
    }

    public List<PersonalInfo> getPersonalInfoList(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        CriteriaQuery<PersonalInfo> criteriaQuery =
                session.getCriteriaBuilder().createQuery(PersonalInfo.class);
        criteriaQuery.from(PersonalInfo.class);

        List<PersonalInfo> personalInfoList = session.createQuery(criteriaQuery).getResultList();
        session.close();

        return personalInfoList;
    }

    public List<Event> getEventList(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        CriteriaQuery<Event> criteriaQuery = session.getCriteriaBuilder().createQuery(Event.class);
        criteriaQuery.from(Event.class);

        List<Event> events = session.createQuery(criteriaQuery).getResultList();
        session.close();

        return events;
    }

    public List<Performer> getPerformerList(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        CriteriaQuery<Performer> criteriaQuery = session.getCriteriaBuilder().createQuery(Performer.class);
        criteriaQuery.from(Performer.class);

        List<Performer> performers = session.createQuery(criteriaQuery).getResultList();
        session.close();

        return performers;
    }

    public List<Place> getPlacesList(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        CriteriaQuery<Place> criteriaQuery = session.getCriteriaBuilder().createQuery(Place.class);
        criteriaQuery.from(Place.class);

        List<Place> places = session.createQuery(criteriaQuery).getResultList();
        session.close();

        return places;
    }

    public void addUser(String login, String email, String password){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        User user = new User();

        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);

        session.save(user);
        session.getTransaction().commit();

        session.close();

    }

    public void addPersonalInfo(){

    }

    public void addPlace(){

    }

    public void addEvent(){

    }

    public void addPerformer(){

    }


}
