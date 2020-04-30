using System;

namespace Labo_06
{
    public class NullStringException : Exception
    {
        public NullStringException(string message) : base(message)
        {
        }
    }
}