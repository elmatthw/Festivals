package by.iba.training.connector;

import by.iba.training.entity.*;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
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

    public static List<Event> getEventList(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        CriteriaQuery<Event> criteriaQuery = session.getCriteriaBuilder().createQuery(Event.class);
        Root <Event> root = criteriaQuery.from(Event.class);
        criteriaQuery.select(root);
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

    public void addAdmin(String login, String email, String password){
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

    public void addUser(String login, String email, String password, String firstName,
                        String lastName, String fatherName, String phoneNumber, int age){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        User user = new User();

        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);

        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setFirstName(firstName);
        personalInfo.setLastName(lastName);
        personalInfo.setFatherName(fatherName);
        personalInfo.setPhoneNumber(phoneNumber);
        personalInfo.setAge(age);
        personalInfo.setUserAuthorization(user);
        personalInfo.setUserStatus(UserStatus.USER);
        user.setPersonalInfo(personalInfo);

        session.save(user);
        session.getTransaction().commit();

        session.close();

    }

    public void addQuest(String firstName, String lastName, String fatherName, String phoneNumber,
                         int age){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setFirstName(firstName);
        personalInfo.setLastName(lastName);
        personalInfo.setFatherName(fatherName);
        personalInfo.setPhoneNumber(phoneNumber);
        personalInfo.setAge(age);
        personalInfo.setUserStatus(UserStatus.QUEST);

        session.save(personalInfo);
        session.getTransaction().commit();

        session.close();
    }


    public void addPlace(String address, int numberOfParticipant){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        Place place = new Place();
        place.setPlaceName(address);
        place.setNumberOfParticipants(numberOfParticipant);

        session.getTransaction().commit();
        session.close();

    }

    public void addEvent(String eventName, Date date, Date deadLineDate, Place place, Festival eventType){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        Event event = new Event();
        event.setEventName(eventName);
        event.setDate(date);
        event.setDeadlineDate(deadLineDate);
        event.setPlace(place);
        event.setEventType(eventType);

        session.save(event);
        session.getTransaction().commit();

        session.close();
    }

    public void addPerformer(String name, String summary){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        Performer performer = new Performer();
        performer.setPerformerName(name);
        performer.setSummary(summary);

        session.save(performer);
        session.getTransaction().commit();

        session.close();
    }

    public void addPerformerOnEvent(Performer performer, Event event){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();
        performer.getListOfEvents().add(event);

        session.save(performer);
        session.getTransaction().commit();

        session.close();

    }

    public void addUsersEvent(PersonalInfo personalInfo, Event event){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();
        personalInfo.getListOfEvents().add(event);

        session.save(personalInfo);
        session.getTransaction().commit();

        session.close();
    }

    public static void addParticipant(int id){
        CriteriaBuilder criteriaBuilder=HibernateSessionFactory.getSessionFactory().createEntityManager().getCriteriaBuilder();
        CriteriaQuery<Event> criteriaQuery=criteriaBuilder.createQuery(Event.class);
        Root<Event> root=criteriaQuery.from(Event.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), id));
        Event event=HibernateSessionFactory.getSessionFactory().createEntityManager().createQuery(criteriaQuery).getSingleResult();
        Session session=HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.evict(event);
        event.setCurrentNumberOfParticipants(event.getCurrentNumberOfParticipants()+1);
        session.merge(event);
        session.getTransaction().commit();
        session.close();
    }
}
