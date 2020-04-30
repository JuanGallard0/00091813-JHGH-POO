using System;

namespace Labo_06
{
    public class PorcentajeOverflowException : Exception
    {
        public PorcentajeOverflowException(string message) : base(message)
        {
        }
    }
}