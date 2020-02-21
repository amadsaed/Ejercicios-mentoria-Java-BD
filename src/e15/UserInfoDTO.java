package e15;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserInfoDTO {
    private int id ;
    private String name;
    private String nationality;
    private String age;
    private String work;
    private String relationship;
    private List<String> friends;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public void addFriends(String friend) {

        if (friends == null) {
            friends = new ArrayList<String>();
        }
        friends.add(friend);
    }

    public String toString(){
        return "id: " + this.id +
                " Nombre: " + this.name +
                "    Age :" + this.age +
                "    Nationality :" + this.nationality +
                "    relationship : " + this.relationship;

    }
}
