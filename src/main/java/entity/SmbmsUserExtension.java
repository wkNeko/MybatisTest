package entity;


import java.io.Serializable;
import java.util.Date;

public class SmbmsUserExtension implements Serializable {

  private int id;
  private String userCode;
  private String userName;
  private String userPassword;
  private int gender;
  private Date birthday;
  private String phone;
  private String address;
  private int userRole;
  private int createdBy;
  private Date creationDate;
  private int modifyBy;
  private Date modifyDate;
  private String roleName;

  public SmbmsRole getSmbmsRole() {
    return smbmsRole;
  }

  public void setSmbmsRole(SmbmsRole smbmsRole) {
    this.smbmsRole = smbmsRole;
  }

  private SmbmsRole smbmsRole;

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getUserCode() {
    return userCode;
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }


  public int getGender() {
    return gender;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }


  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public int getUserRole() {
    return userRole;
  }

  public void setUserRole(int userRole) {
    this.userRole = userRole;
  }


  public int getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(int createdBy) {
    this.createdBy = createdBy;
  }


  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }


  public int getModifyBy() {
    return modifyBy;
  }

  public void setModifyBy(int modifyBy) {
    this.modifyBy = modifyBy;
  }


  public Date getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(Date modifyDate) {
    this.modifyDate = modifyDate;
  }

  @Override
  public String toString() {
    return "SmbmsUser{" +
      "id=" + id +
      ", userCode='" + userCode + '\'' +
      ", userName='" + userName + '\'' +
      ", userPassword='" + userPassword + '\'' +
      ", gender=" + gender +
      ", birthday=" + birthday +
      ", phone='" + phone + '\'' +
      ", address='" + address + '\'' +
      ", userRole=" + userRole +
      ", createdBy=" + createdBy +
      ", creationDate=" + creationDate +
      ", modifyBy=" + modifyBy +
      ", modifyDate=" + modifyDate +
      '}';
  }
}
