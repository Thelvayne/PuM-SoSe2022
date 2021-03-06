public class Contact {
    private String firstName, lastName, phone;
    private Messenger[] messenger;

    public Contact()
    {

    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getPhone()
    {
        return phone;
    }

    public Messenger[] getMessenger()
    {
        return messenger;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public void addMessenger (Messenger messengerString)
    {
        this.messenger = addSpaceToArray(this.messenger);
        this.messenger[this.messenger.length-1] = messengerString;
        
    }

    private static Messenger[] addSpaceToArray(Messenger[] input) // method to increase the length of an array w/out losing content
    { 
        if (input == null){
            input = new Messenger[1];
            return input;
        }
        int oldLength = input.length;
        int newLength = oldLength + 1;

        Messenger[] longerArray = new Messenger[newLength];
        System.arraycopy(input, 0, longerArray, 0, oldLength);
        return longerArray;        
    }
}
