using System;

namespace Ejercicio_03
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Console.Write("Ingrese n: ");
            int n = Convert.ToInt16(Console.ReadLine());
            Console.WriteLine("Secuencia: ");
            secuencia(n, 1);
        }

        public static void secuencia(int n, int i)
        {
            if (i < n)
            {
                Console.Write(i + ", ");
                secuencia(n, i + 1);
            }
            Console.Write(i + ", ");
        }
    }
}