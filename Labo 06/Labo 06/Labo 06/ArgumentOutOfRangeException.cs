using System;

namespace Labo_06
{
    public class ArgumentOutOfRangeException : Exception
    {
        public ArgumentOutOfRangeException(string message) : base(message)
        {
        }
    }
}