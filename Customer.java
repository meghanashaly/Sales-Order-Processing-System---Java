public class Customer implements java.io.Serializable {
    private String name, phone, address;

    public Customer(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    @Override
    public String toString() {
        return name + " (" + phone + ")";
    }
}
