using System;
using System.Collections.Generic;

namespace Ejercicio_05
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Console.Write("Ingrese frase: ");
            String frase = Console.ReadLine();
            frase = frase.ToLower();
            List<char> vocalesFrase = new List<char>();
            for (int i = 0; i < frase.Length; i++)
            {
                if (frase[i] == 'a' || frase[i] == 'e' || 
                    frase[i] == 'i' || frase[i] == 'o' || frase[i] == 'u')
                    vocalesFrase.Add(frase[i]);
            }

            foreach (char vocal in vocalesFrase)
                Console.Write(vocal + ", ");
        }
    }
}