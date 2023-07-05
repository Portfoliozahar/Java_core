
public class Client {

  private String lastName;

  private String firstName;

  private int age;

  private String phone;

  private Gender gender;

  public Client(String lastName, String firstName, int age, String phone, Gender gender) {
    setLastName(lastName);
    setFirstName(firstName);
    setAge(age);
    setPhone(phone);
    setGender(gender);
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {

    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {

    this.firstName = firstName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    if (phone == null || phone.isEmpty() || !phone.matches("\\d+")) {
      throw new IllegalArgumentException("Номер телефона не может содержать нецифровые символы.");
    }
    this.phone = phone;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return lastName + " " + firstName + '\n' +
        " Возраст " + age + '\n' +
        " телефон " + phone + '\n' +
        " Пол " + gender + '\n';
  }

}
