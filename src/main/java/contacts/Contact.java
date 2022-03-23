package contacts;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {
    private String name;
    private int age;
    private String birthDate;
    private String phoneNumber;

    public Contact(String name,  String phoneNumber,String birthDate) throws ParseException {
        if (name==null||name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (phoneNumber.length()<5||phoneNumber.isBlank()||phoneNumber==null){
            throw new IllegalArgumentException("Phone number cannot be less then 5 characters");
        }
        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.age=toAge(this.birthDate);
    }

    public Contact(Contact contact){
        this.age= contact.age;
        this.birthDate= contact.birthDate;
        this.name=contact.name;
        this.phoneNumber=contact.phoneNumber;
    }

    public void setName(String name) {
        if (name==null||name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public void setBirthDate(String birthDate) throws ParseException {
        this.birthDate = birthDate;
        setAge(toAge(birthDate));
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length()<5||phoneNumber.isBlank()||phoneNumber==null){
            throw new IllegalArgumentException("Phone number cannot be less then 5 characters");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Name: toAge
     * @param birthDate
     * @return age (int)
     * @throws ParseException
     *
     * Inside the function:
     * 1.Parses a date from the birthDate String
     * 2.Gets the current date
     * 3.Subtracts the difference and returns the age
     */
    public int toAge(String birthDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        Date birthdayToDate = dateFormat.parse(birthDate);
        long bdToMili = birthdayToDate.getTime();
        long diff = new Date().getTime() - bdToMili;
        int age = ((int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS))/365;
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\n" +

                "Phone number: " + this.phoneNumber + "\n" +

                "Birth Date: " + this.birthDate + "\n" +

                "Age: " + this.age + " year old\n";
    }
}
