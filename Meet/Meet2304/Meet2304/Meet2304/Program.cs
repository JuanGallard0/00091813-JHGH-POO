using System;
using System.Collections.Generic;

namespace Meet2304
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            var p = new List<Persona>();
            
            p.Add(new Persona("Juan","Gallardo",24 ));
            p.Add(new Persona("Marco",edad:19 ));
            p.Add(new Persona(edad: 60 ));
            p.Add(new Persona(apellido:"Hernandez" ));

            String buscar = "Juan";
            buscar = Console.ReadLine();
            
            p.ForEach(it =>
            {
                if (buscar.Equals(it.Nombre))
                {
                    Console.WriteLine("Nuevo nombre ");
                    it.Nombre = Console.ReadLine();
                    Console.WriteLine(it.ToString());
                }
            });
            int añadir = 12;
            int árbol = 14;
        }
    }
}