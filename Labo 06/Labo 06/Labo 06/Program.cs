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
                        throw new ArgumentOutOfRangeException("Esa opcion no existe.");
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
                        porcentajeActual = calcularPorcentaje(listaEvaluaciones);
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
                            eliminarEvaluacion(listaEvaluaciones);
                        else
                            Console.WriteLine("La lista esta vacia.");
                        break;
                    case 4:
                        double notaFinal = CalcularNota.Calcular(listaEvaluaciones);
                        Console.WriteLine("Nota final: " + notaFinal);
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
                        throw new ArgumentOutOfRangeException("Esa opcion no existe.");
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
                    if (porcentaje < 0 || porcentaje > 100)
                        throw new ArgumentOutOfRangeException(
                            "El porcentaje no puede ser menor que 0 o superior a 100.");
                    else if (porcentaje + porcentajeActual > 100)
                        throw new PorcentajeOverflowException("*Porcentaje OverFlow.");
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
            string nombre = null;
            while (loop)
            {
                try
                {
                    loop = false;
                    Console.Write("Nombre: ");
                    nombre = Console.ReadLine();
                    if (string.IsNullOrEmpty(nombre))
                        throw new NullStringException("*Required field.");
                }
                catch (NullStringException e)
                {
                    Console.WriteLine(e);
                    loop = true;
                }
            }
            loop = true;
            switch (choice)
            {
                case 1:
                    string tipo = null;
                    while (loop)
                    {
                        try
                        {
                            loop = false;
                            Console.Write("Tipo: ");
                            tipo = Console.ReadLine();
                            if (string.IsNullOrEmpty(tipo))
                                throw new NullStringException("*Required field.");
                        }
                        catch (NullStringException e)
                        {
                            Console.WriteLine(e);
                            loop = true;
                        }
                    }
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
                                throw new ArgumentOutOfRangeException("La cantidad de preguntas no puede ser negativa.");
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

        public static void eliminarEvaluacion(List<Evaluacion> listaEvaluaciones)
        {
            bool loop = true;
            string nombre = null;
            while (loop)
            {
                try
                {
                    loop = false;
                    Console.Write("Nombre de la evaluacion a eliminar: ");
                    nombre = Console.ReadLine();
                    if (string.IsNullOrEmpty(nombre))
                        throw new NullStringException("*Required field.");
                }
                catch (NullStringException e)
                {
                    Console.WriteLine(e);
                    loop = true;
                }
            }
            listaEvaluaciones.RemoveAll(x => x.nombre == nombre);
        }

        public static int calcularPorcentaje(List<Evaluacion> listaEvaluaciones)
        {
            int sum = 0;
            foreach (var evaluacion in listaEvaluaciones)
            {
                sum += evaluacion.porcentaje;
            }
            return sum;
        }
    }
}