package entity;


import java.util.Date;

public class SmbmsBill {

  private int id;
  private String billCode;
  private String productName;
  private String productDesc;
  private String productUnit;
  private double productCount;
  private double totalPrice;
  private int isPayment;
  private int createdBy;
  private Date creationDate;
  private int modifyBy;
  private Date modifyDate;
  private int providerId;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getBillCode() {
    return billCode;
  }

  public void setBillCode(String billCode) {
    this.billCode = billCode;
  }


  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }


  public String getProductDesc() {
    return productDesc;
  }

  public void setProductDesc(String productDesc) {
    this.productDesc = productDesc;
  }


  public String getProductUnit() {
    return productUnit;
  }

  public void setProductUnit(String productUnit) {
    this.productUnit = productUnit;
  }


  public double getProductCount() {
    return productCount;
  }

  public void setProductCount(double productCount) {
    this.productCount = productCount;
  }


  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }


  public int getIsPayment() {
    return isPayment;
  }

  public void setIsPayment(int isPayment) {
    this.isPayment = isPayment;
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


  public int getProviderId() {
    return providerId;
  }

  public void setProviderId(int providerId) {
    this.providerId = providerId;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("SmbmsBill{");
    sb.append("id=").append(id);
    sb.append(", billCode='").append(billCode).append('\'');
    sb.append(", productName='").append(productName).append('\'');
    sb.append(", productDesc='").append(productDesc).append('\'');
    sb.append(", productUnit='").append(productUnit).append('\'');
    sb.append(", productCount=").append(productCount);
    sb.append(", totalPrice=").append(totalPrice);
    sb.append(", isPayment=").append(isPayment);
    sb.append(", createdBy=").append(createdBy);
    sb.append(", creationDate=").append(creationDate);
    sb.append(", modifyBy=").append(modifyBy);
    sb.append(", modifyDate=").append(modifyDate);
    sb.append(", providerId=").append(providerId);
    sb.append('}');
    return sb.toString();
  }
}
