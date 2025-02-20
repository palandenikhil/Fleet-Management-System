
namespace Fleet_Management.Exceptions
{
    public class ApiException : Exception
    {

        public ApiException(string message) : base(message)
        {

        }
        public ApiException(string message, Exception innerException) 
            : base(message, innerException)
        {
        }
    }
}