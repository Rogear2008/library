package com.rogear.library.pojo;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbg.generated Mon Apr 20 15:50:00 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.username
     *
     * @mbg.generated Mon Apr 20 15:50:00 CST 2020
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.passwod
     *
     * @mbg.generated Mon Apr 20 15:50:00 CST 2020
     */
    private String passwod;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbg.generated Mon Apr 20 15:50:00 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbg.generated Mon Apr 20 15:50:00 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.username
     *
     * @return the value of user.username
     *
     * @mbg.generated Mon Apr 20 15:50:00 CST 2020
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.username
     *
     * @param username the value for user.username
     *
     * @mbg.generated Mon Apr 20 15:50:00 CST 2020
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.passwod
     *
     * @return the value of user.passwod
     *
     * @mbg.generated Mon Apr 20 15:50:00 CST 2020
     */
    public String getPasswod() {
        return passwod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.passwod
     *
     * @param passwod the value for user.passwod
     *
     * @mbg.generated Mon Apr 20 15:50:00 CST 2020
     */
    public void setPasswod(String passwod) {
        this.passwod = passwod == null ? null : passwod.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passwod='" + passwod + '\'' +
                '}';
    }
}