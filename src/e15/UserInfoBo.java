package e15;

public class UserInfoBo {
    private int id;
    private String name;
    private String nationality;
    private String age;
    private String work;
    private String relationship;
    private UserInfoDTO userInfoDTO;

    public int getId() {
        return userInfoDTO.getId();
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return userInfoDTO.getName();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return userInfoDTO.getNationality();
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAge() {
        return userInfoDTO.getAge();
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWork() {
        return userInfoDTO.getWork();
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getRelationship() {
        return userInfoDTO.getRelationship();
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public UserInfoBo() {
    }

    public UserInfoBo(int id, String name, String nationality, String age, String work, String relationship) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.age = age;
        this.work = work;
        this.relationship = relationship;
    }

    public UserInfoBo(UserInfoDTO userInfoDTO) {
        this.userInfoDTO = userInfoDTO;
    }

    public UserInfoDTO getUserInfoDTO() {
        return userInfoDTO;
    }

    public void setUserInfoDTO(UserInfoDTO userInfoDTO) {
        this.userInfoDTO = userInfoDTO;
    }
}
