using System;

namespace Ejercicio_01
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Console.Write("Ingrese n:");
            int n = Convert.ToInt16(Console.ReadLine());
            int[] fibonacciMemory = new int[n];
            Console.WriteLine("Primeros " + n + " terminos de fibonacci:");
            fibonacciMemory[0] = 0;
            fibonacciMemory[1] = 1;
            for (int i = 0; i < n; i++)
            {
                if (i > 1)
                    fibonacciMemory[i] = fibonacciMemory[i - 1] + fibonacciMemory[i - 2];
                Console.Write(fibonacciMemory[i] + ", ");
            }
        }
    }
}