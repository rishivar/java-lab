package myException;


public class UserNotFoundException extends Exception
{
    String detail;
    public UserNotFoundException(String detail)
    {
        this.detail = detail;
    }
    public String toString()
    {
        return "User: "+detail+" Not Found!";
    }
}
