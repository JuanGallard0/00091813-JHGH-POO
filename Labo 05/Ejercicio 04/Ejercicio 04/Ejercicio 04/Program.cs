using System;

namespace Ejercicio_04
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Console.Write("Ingrese frase: ");
            String frase = Console.ReadLine();
            frase = frase.ToLower();
            Console.WriteLine("Frase modificada: " + frase.Replace('a', 'b'));
        }
    }
}