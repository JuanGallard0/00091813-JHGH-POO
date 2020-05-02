using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;

namespace Labo_06
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            byte choice = 0;
            List<Evaluacion> listaEvaluaciones = new List<Evaluacion>();
            int porcentajeActual = 0;
            while (choice != 4)
            {
                mainMenu();
                try
                {
                    choice = Convert.ToByte(Console.ReadLine());
                    if (choice < 1 || choice > 4)
                        throw new ArgumentOutOfRangeException();
                }
                catch (ArgumentOutOfRangeException e)
                {
                    Console.WriteLine(e);
                }
                catch (System.FormatException e)
                {
                    Console.WriteLine(e);
                }
                switch (choice)
                {
                    case 1:
                        porcentajeActual = CalcularPorcentaje(listaEvaluaciones);
                        if (porcentajeActual < 100)
                            listaEvaluaciones.Add(InputEvaluacion(porcentajeActual));
                        else 
                            Console.WriteLine("Porcentaje al limite.");
                        break;
                    case 2:
                        if (listaEvaluaciones.Any())
                        {
                            foreach (var evaluacion in listaEvaluaciones)
                            {
                                Console.WriteLine(evaluacion.ToString());
                            }
                        }
                        else
                            Console.WriteLine("La lista esta vacia.");
                        break;
                    case 3:
                        if (listaEvaluaciones.Any())
                            EliminarEvaluacion(listaEvaluaciones);
                        else
                            Console.WriteLine("La lista esta vacia.");
                        break;
                    case 4:
                        if (listaEvaluaciones.Any())
                        {
                            double notaFinal = CalcularNota.Calcular(listaEvaluaciones);
                            Console.WriteLine("Nota final: " + notaFinal);
                        }
                        else
                            Console.WriteLine("Ninguna evaluacion registrada.");
                        break;
                }
            }
        }

        public static void mainMenu()
        {
            Console.Write("\nMENU PRINCIPAL\n(1) Agregar evaluacion\n(2) Mostrar evaluaciones almacenadas" +
                          "\n(3) Eliminar evaluacion\n(4) Terminar programa\nOPCION: ");
        }

        public static Evaluacion InputEvaluacion(int porcentajeActual)
        {
            byte choice = 0;
            bool loop = true;
            while (loop)
            {
                try
                {
                    loop = false;
                    Console.Write("(1)Laboratorio\t(2)Parcial\t(3)Tarea\nOPCION: ");
                    choice = Convert.ToByte(Console.ReadLine());
                    if (choice < 1 || choice > 3)
                        throw new ArgumentOutOfRangeException();
                }
                catch (ArgumentOutOfRangeException e)
                {
                    Console.WriteLine(e);
                    loop = true;
                }
                catch (System.FormatException e)
                {
                    Console.WriteLine(e);
                    loop = true;
                }
            }
            loop = true;
            int porcentaje = 0;
            while (loop)
            {
                try
                {
                    loop = false;
                    Console.Write("(Actual% = " + porcentajeActual + ") Porcentaje: ");
                    porcentaje = Convert.ToInt16(Console.ReadLine());
                    if (porcentaje < 0)
                        throw new ArgumentOutOfRangeException();
                    else if (porcentaje + porcentajeActual > 100)
                        throw new PorcentajeOverflowException("*Porcentaje desbordado.");
                }
                catch (ArgumentOutOfRangeException e)
                {
                    Console.WriteLine(e);
                    loop = true;
                }
                catch (System.FormatException e)
                {
                    Console.WriteLine(e);
                    loop = true;
                }
                catch (PorcentajeOverflowException e)
                {
                    Console.WriteLine(e);
                    loop = true;
                }
            }
            loop = true;
            string nombre = EmptyStringCheck("Nombre: ");
            switch (choice)
            {
                case 1:
                    string tipo = EmptyStringCheck("Tipo: ");
                    return new Laboratorio(porcentaje, nombre, tipo);
                case 2:
                    int cantPreguntas = 0;
                    while (loop)
                    {
                        try
                        {
                            loop = false;
                            Console.Write("Cantidad de preguntas: ");
                            cantPreguntas = Convert.ToInt16(Console.ReadLine());
                            if (cantPreguntas < 0)
                                throw new ArgumentOutOfRangeException();
                        }
                        catch (ArgumentOutOfRangeException e)
                        {
                            Console.WriteLine(e);
                            loop = true;
                        }
                        catch (System.FormatException e)
                        {
                            Console.WriteLine(e);
                            loop = true;
                        }
                    }
                    return new Parcial(porcentaje, nombre, cantPreguntas);
                case 3:
                    string fecha, format = "d";
                    var fechaEntrega = DateTime.MinValue;
                    CultureInfo provider = CultureInfo.InvariantCulture;
                    while (loop)
                    {
                        loop = false;
                        Console.Write("Fecha de entrega \"MM/DD/YYYY\": ");
                        fecha = Console.ReadLine();
                        try {
                            fechaEntrega = DateTime.ParseExact(fecha, format, provider);
                            Console.WriteLine("{0} converts to {1}.", fecha, fechaEntrega.ToString());
                        }
                        catch (FormatException) {
                            Console.WriteLine("{0} is not in the correct format.", fecha);
                            loop = true;
                        }
                    }
                    return new Tarea(porcentaje, nombre, fechaEntrega);
            }
            return null;
        }

        public static void EliminarEvaluacion(List<Evaluacion> listaEvaluaciones)
        {
            string nombre = EmptyStringCheck("Nombre de la evaluacion a eliminar: ");
            listaEvaluaciones.RemoveAll(x => x.nombre == nombre);
        }

        public static int CalcularPorcentaje(List<Evaluacion> listaEvaluaciones)
        {
            int sum = 0;
            if (listaEvaluaciones.Any())
            {
                foreach (var evaluacion in listaEvaluaciones)
                {
                    sum += evaluacion.porcentaje;
                }
            }
            return sum;
        }

        public static string EmptyStringCheck(string desc)
        {
            bool loop = true;
            string str = null;
            while (loop)
            {
                try
                {
                    loop = false;
                    Console.Write(desc);
                    str = Console.ReadLine();
                    if (string.IsNullOrEmpty(str))
                        throw new ArgumentNullException();
                }
                catch (ArgumentNullException e)
                {
                    Console.WriteLine(e);
                    loop = true;
                }
            }
            return str;
        }
    }
}