/*
package by.iba.training.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

*/
/*@Entity
@Table(name = "performer_on_event")
@Proxy(lazy = false)*//*

public class PerformerOnEvent {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "event_ID")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "performer_id")
    private Performer performer;

    public PerformerOnEvent() {
    }

    public PerformerOnEvent(Event event, Performer performer) {
        this.event = event;
        this.performer = performer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Performer getPerformer() {
        return performer;
    }

    public void setPerformer(Performer performer) {
        this.performer = performer;
    }
}
*/
