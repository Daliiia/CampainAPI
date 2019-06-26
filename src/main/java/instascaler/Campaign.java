package instascaler;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name="campaign")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @Column(name = "Name",nullable = false)
    private String Name;

    @Column(name = "Country",nullable = false)
    private String country;


    @Column(name = "Budget",nullable = false)
    private String budget;

    @Column(name = "Goal",nullable = false)
    private String goal;

    @Column(name = "category")
    private String category;

    @Column(name = "startDate")
    private String startDate;

    @Column(name = "endDate")
    private String  endDate;

    Campaign() {

    }

    Campaign(String Name, String country, String goal, String category, String budget){
        this.setName(Name);
        this.setCountry(country);
        this.setBudget(budget);
        this.setGoal(goal);
        this.setCategory(category);


    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getCategory() {
        return category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCategory(String category) {
        this.category = category;
    }



    public String getBudget() {
        return budget;
    }

    public void setBudget(String  budget) {
        this.budget = budget;
    }
}
