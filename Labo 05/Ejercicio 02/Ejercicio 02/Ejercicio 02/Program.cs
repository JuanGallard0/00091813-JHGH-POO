using System;

namespace Ejercicio_02
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Console.Write("Ingrese una frase: ");
            String frase = Console.ReadLine();
            frase = frase.ToLower();
            String fraseInvertida = "";
            for (int i = frase.Length; i > 0; i--)
                fraseInvertida += frase[i - 1]; 
            if (frase.CompareTo(fraseInvertida) == 0)
                Console.WriteLine("La frase es palindrome.");
            else 
                Console.WriteLine("La frase no es palindrome.");
        }
    }
}